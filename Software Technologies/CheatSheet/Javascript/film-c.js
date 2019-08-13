const Film = require('../models/Film');

module.exports = {
	index: (req, res) => {
		// Get all films and pass them to the index view
        Film.find({}).then(films => {
            res.render('film/index', {'films': films});
        })
	},
	createGet: (req, res) => {
		// Render the create view
        res.render('film/create');
	},
	createPost: (req, res) => {
		// Get the entered data from the form
        let filmArgs = req.body;

        let errorMsg = '';

        if(!filmArgs.name){
            errorMsg = 'Invalid name';
        } else if (!filmArgs.genre){
            errorMsg = 'Invalid genre';
        } else if (!filmArgs.director){
            errorMsg = 'Invalid director';
        } else if (!filmArgs.year){
            errorMsg = 'Invalid year';
        }

        if (errorMsg){
            res.render('film/create', {error: errorMsg});
            return;
        }

        // Create the film
        Film.create(filmArgs);

        // Redirect user to home page
        res.redirect('/');
	},
	editGet: (req, res) => {
        // Get the id of the film that is to be edited
        let id = req.params.id;

        // Get the film and pass it to the edit view
        Film.findById(id).then(film => {
            res.render('film/edit', film);
        })
	},
	editPost: (req, res) => {
        // Get the entered data from the form
        let filmArgs = req.body;

        // Get the id of the film that is to be edited
        let id = req.params.id;

        // Get the film, edit it and redirect user to home page
        Film.findByIdAndUpdate(id, filmArgs, {runValidators: true}).then(
            res.redirect("/")
        );
	},
	deleteGet: (req, res) => {
		// Get the id of the film that is to be deleted
        let id = req.params.id;

        // Get the film and pass it to the delete view
        Film.findById(id).then(film => {
            res.render('film/delete', film);
        })
	},
	deletePost: (req, res) => {
        // Get the id of the film that is to be deleted
        let id = req.params.id;

        // Get the film, delete it and redirect user to home page
        Film.findByIdAndRemove(id).then(
            res.redirect('/')
        );
	}
};