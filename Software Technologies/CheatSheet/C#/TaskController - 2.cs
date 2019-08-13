using System;
using System.Linq;
using System.Net;
using System.Web.Mvc;
using TeisterMask.Models;

namespace TeisterMask.Controllers
{
        [ValidateInput(false)]
	public class TaskController : Controller
	{
	    [HttpGet]
            [Route("")]
	    public ActionResult Index()
	    {
            using (var database = new TeisterMaskDbContext())
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
                using (var database = new TeisterMaskDbContext())
                {
                    // Save film in database
                    database.Tasks.Add(task);
                    database.SaveChanges();

                    // Return user to home page
                    return RedirectToAction("Index");
                }
            }
            return View(task);
        }

		[HttpGet]
		[Route("edit/{id}")]
        public ActionResult Edit(int id)
		{
            // Check if input is valid
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var database = new TeisterMaskDbContext())
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

                // Return an edit view for the task
                return View(task);
            }
        }

		[HttpPost]
		[Route("edit/{id}")]
        [ValidateAntiForgeryToken]
		public ActionResult EditConfirm(int id, Task taskModel)
		{
            // Check if input is valid
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var database = new TeisterMaskDbContext())
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

                if (this.ModelState.IsValid)
                {
                    // Edit task's content
                    task.Title = taskModel.Title;
                    task.Status = taskModel.Status;

                    database.SaveChanges();

                    // Return user to home page
                    return RedirectToAction("Index");
                }

                return View();
            }
        }
	}
}