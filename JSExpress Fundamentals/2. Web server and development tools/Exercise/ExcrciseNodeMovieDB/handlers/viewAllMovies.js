let movies = require('../config/dataBase');
const moviePlaceholder = '{{replace-me}}';

const movieTemplate = `
    <div class="movie">
        <img class="moviePoster" src="${moviePlaceholder}"/>          
    </div>
`;

function viewAllMoviesHandler(req, res) {
    let moviesHtml = ''; // da e vutre vuv funkziata!!
    if (req.path == '/viewAllMovies') {
        for (movie of movies) {
            moviesHtml += movieTemplate.replace(moviePlaceholder, decodeURIComponent(movie.moviePoster));
        }
        res.sendHtml('./views/viewAll.html', moviesHtml);
    } else {
        return true;
    }
}

module.exports = viewAllMoviesHandler;