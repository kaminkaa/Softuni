const publicHandler = require('./public');
const homeHandler = require('./home');
const errorHandler = require('./error');
const addMovieHandler = require('./addMovie');
const viewAllMoviesHandler = require('./viewAllMovies');
const movieDetailsHandler = require('./details');

// vajen e reda, v koito se izbroqvat. error-a trqbva vinagi da e posleden:
module.exports = [
    publicHandler,
    homeHandler,
    addMovieHandler,
    viewAllMoviesHandler,
    movieDetailsHandler,
    errorHandler
];