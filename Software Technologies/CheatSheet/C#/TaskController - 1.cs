using System;
using System.Linq;
using System.Net;
using System.Web.Mvc;
using TodoList.Models;

namespace TodoList.Controllers
{
        [ValidateInput(false)]
	public class TaskController : Controller
	{
	    [HttpGet]
        [Route("")]
	    public ActionResult Index()
	    {
            using (var database = new TodoListDbContext())
            {
                // Get tasks from database
                var tasks = database.Tasks.ToList();

                return View(tasks);
            }
        }

        [HttpGet]
        [Route("create")]
        public ActionResult Create()
		{
		    return View();
		}

		[HttpPost]
		[Route("create")]
        [ValidateAntiForgeryToken]
		public ActionResult Create(Task task)
		{
            // Check model state
            if (ModelState.IsValid)
            {
                using (var database = new TodoListDbContext())
                {
                    // Save task in database
                    database.Tasks.Add(task);
                    database.SaveChanges();

                    // Return user to home page
                    return RedirectToAction("Index");
                }
            }
		    return View(task);
        }

		[HttpGet]
		[Route("delete/{id}")]
        public ActionResult Delete(int id)
		{
            // Check if input is valid
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var database = new TodoListDbContext())
            {
                // Get task from database
                var task = database.Tasks
                    .Where(t => t.Id == id)
                    .First();

                // Check if task exists
                if (task == null)
                {
                    return HttpNotFound();
                }

                // Pass task to view
                return View(task);
            }                
        }

		[HttpPost]
		[Route("delete/{id}")]
        [ValidateAntiForgeryToken]
		public ActionResult DeleteConfirm(int id)
		{
            // Check if input is valid
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var database = new TodoListDbContext())
            {
                // Get task from database
                var task = database.Tasks
                    .Where(t => t.Id == id)
                    .First();

                // Check if task exists
                if (task == null)
                {
                    return HttpNotFound();
                }

                // Delete task from database
                database.Tasks.Remove(task);
                database.SaveChanges();

                // Return user to home page
                return RedirectToAction("Index");
            }
        }
	}
}