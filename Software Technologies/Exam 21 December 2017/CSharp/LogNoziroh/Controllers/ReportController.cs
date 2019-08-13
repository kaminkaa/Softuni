namespace LogNoziroh.Controllers
{
    using System.Collections.Generic;
    using System.Linq;
    using System.Web.Mvc;
    using Models;

    [ValidateInput(false)]
    public class ReportController : Controller
    {
        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            using (var database = new LogNozirohDbContext())
            {
                // Get all reports from database
                var reports = database.Reports.ToList();

                // Pass them to the index view
                return View(reports);
            }
        }

        [HttpGet]
        [Route("details/{id}")]
        public ActionResult Details(int id)
        {
            using (var database = new LogNozirohDbContext())
            {
                // Get the report from database
                var report = database.Reports
                    .Where(r => r.Id == id)
                    .First();

                // Pass the report to the details view
                return View(report);
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
        public ActionResult Create(Report report)
        {
            if (ModelState.IsValid)
            {
                using (var database = new LogNozirohDbContext())
                {
                    // Save report in database
                    database.Reports.Add(report);
                    database.SaveChanges();

                    // Redirect user to home page
                    return RedirectToAction("Index");
                }
            }
            return View(report);
        }

        [HttpGet]
        [Route("delete/{id}")]
        public ActionResult Delete(int id)
        {
            using (var database = new LogNozirohDbContext())
            {
                // Get the report from database
                var report = database.Reports
                    .Where(r => r.Id == id)
                    .First();

                // Pass the report to the delete view
                return View(report);
            }
        }

        [HttpPost]
        [Route("delete/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirm(int id, Report reportModel)
        {
            using (var database = new LogNozirohDbContext())
            {
                // Get the report from database
                var report = database.Reports
                    .Where(r => r.Id == id)
                    .First();

                // Remove the report from database
                database.Reports.Remove(report);
                database.SaveChanges();

                // Redirect user to home page
                return RedirectToAction("Index");
            }
        }
    }
}