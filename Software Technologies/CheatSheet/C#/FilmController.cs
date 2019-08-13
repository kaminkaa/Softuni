using System.Linq;
using System.Net;
using System.Web.Mvc;
using IMDB.Models;

namespace IMDB.Controllers
{
    [ValidateInput(false)]
    public class FilmController : Controller
    {
        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            using (var database = new IMDBDbContext())
            {
                // Get films from database
                var films = database.Films.ToList();

                return View(films);
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
        public ActionResult Create(Film film)
        {
            // Check model state
            if (ModelState.IsValid)
            {
                using (var database = new IMDBDbContext())
                {
                    // Save film in database
                    database.Films.Add(film);
                    database.SaveChanges();

                    // Return user to home page
                    return RedirectToAction("Index");
                }
            }
            return View(film);
        }

        [HttpGet]
        [Route("edit/{id}")]
        public ActionResult Edit(int? id)
        {
            // Check if input is valid
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var database = new IMDBDbContext())
            {
                // Get film from database
                var film = database.Films
                    .Where(f => f.Id == id)
                    .First();

                // Check if film exists
                if (film == null)
                {
                    return HttpNotFound();
                }

                // Return an edit view for the film
                return View(film);
            }
        }

        [HttpPost]
        [Route("edit/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult EditConfirm(int? id, Film filmModel)
        {
            // Check if input is valid
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var database = new IMDBDbContext())
            {
                // Get film from database
                var film = database.Films
                    .Where(f => f.Id == id)
                    .First();

                // Check if film exists
                if (film == null)
                {
                    return HttpNotFound();
                }

                if (this.ModelState.IsValid)
                {
                    // Edit film's content
                    film.Name = filmModel.Name;
                    film.Genre = filmModel.Genre;
                    film.Director = filmModel.Director;
                    film.Year = filmModel.Year;

                    database.SaveChanges();

                    // Return user to home page
                    return RedirectToAction("Index");
                }

                return View();
            }
        }

        [HttpGet]
        [Route("delete/{id}")]
        public ActionResult Delete(int? id)
        {
            // Check if input is valid
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var database = new IMDBDbContext())
            {
                // Get film from database
                var film = database.Films
                    .Where(f => f.Id == id)
                    .First();

                // Check if film exists
                if (film == null)
                {
                    return HttpNotFound();
                }

                // Return an edit view for the film
                return View(film);
            }
        }

        [HttpPost]
        [Route("delete/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirm(int? id, Film filmModel)
        {
            // Check if input is valid
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var database = new IMDBDbContext())
            {
                // Get film from database
                var film = database.Films
                    .Where(f => f.Id == id)
                    .First();

                // Check if film exists
                if (film == null)
                {
                    return HttpNotFound();
                }

                // Delete film
                database.Films.Remove(film);
                database.SaveChanges();

                // Return user to home page
                return RedirectToAction("Index");
            }
        }
    }
}