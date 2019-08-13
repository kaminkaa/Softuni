package imdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import imdb.bindingModel.FilmBindingModel;
import imdb.entity.Film;
import imdb.repository.FilmRepository;

import java.util.List;

@Controller
public class FilmController {

	private final FilmRepository filmRepository;

	@Autowired
	public FilmController(FilmRepository filmRepository) {
		this.filmRepository = filmRepository;
	}

	@GetMapping("/")
	public String index(Model model) {

		// Get all films from the database
		List<Film> films = this.filmRepository.findAll();

		// Pass the films to the view that will show them all
		model.addAttribute("films", films);
		model.addAttribute("view", "film/index");

		return "base-layout";
	}

	@GetMapping("/create")
	public String create(Model model) {

		// Show the form for creating a task
		model.addAttribute("view", "film/create");

		return "base-layout";
	}

	@PostMapping("/create")
	public String createProcess(Model model, FilmBindingModel filmBindingModel) {
		// Create a new film
		Film filmEntity = new Film(
				filmBindingModel.getName(),
				filmBindingModel.getGenre(),
				filmBindingModel.getDirector(),
				filmBindingModel.getYear()
		);

		// Upload the film to the database
		this.filmRepository.saveAndFlush(filmEntity);

		// Redirect user to home page
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable int id) {

        // Check if film exists
        if (!this.filmRepository.exists(id)){
            return "redirect:/";
        }

        // Get the film that is to be edited
        Film film = this.filmRepository.findOne(id);

        // Pass the film to the edit view
        model.addAttribute("film", film);
        model.addAttribute("view", "film/edit");

        return "base-layout";
	}

	@PostMapping("/edit/{id}")
	public String editProcess(Model model, @PathVariable int id, FilmBindingModel filmBindingModel) {
        // Check if film exists
        if (!this.filmRepository.exists(id)){
            return "redirect:/";
        }

        // Get the film to be edited
        Film film = this.filmRepository.findOne(id);

        // Edit the film
        film.setName(filmBindingModel.getName());
        film.setGenre(filmBindingModel.getGenre());
        film.setDirector(filmBindingModel.getDirector());
        film.setYear(filmBindingModel.getYear());

        // Update database
        filmRepository.saveAndFlush(film);

        // Redirect user to home page
        return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {

        // Check if film exists
        if (!this.filmRepository.exists(id)){
            return "redirect:/";
        }

        // Get the film that is to be deleted
        Film film = this.filmRepository.findOne(id);

        // Pass the film to the delete view
        model.addAttribute("film", film);
        model.addAttribute("view", "film/delete");

        return "base-layout";
	}

	@PostMapping("/delete/{id}")
	public String deleteProcess(@PathVariable int id) {

        // Check if film exists
        if (!this.filmRepository.exists(id)){
            return "redirect:/";
        }

        // Get the film to be deleted
        Film task = this.filmRepository.findOne(id);

        // Remove task from database
        this.filmRepository.delete(task);

        // Redirect user to home page
        return "redirect:/";
    }
}
