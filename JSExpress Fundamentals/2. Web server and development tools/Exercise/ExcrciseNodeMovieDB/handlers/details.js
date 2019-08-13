let movies = require('../config/dataBase');

const poster = '{{posterURL}}';
const title = '{{title}}';
const year = '{{year}}';
const description = '{{description}}';

const detailsTemplate = `
    <div class="content">
        <img src="{{poster}}" alt=""/>
        <h3>Title  {{title}}</h3>
        <h3>Year {{year}}</h3>
        <p>{{description}}</p>
    </div>
`;

function movieDetailsHandler(req, res) {
    if (req.path.startsWith('/movies/details') && req.method === 'GET') {
        let index = req.path.substr(req.path.lastIndexOf('/') + 1);

        let movie = movies[index];
        let movieHtml = detailsTemplate.replace('{{poster}}', decodeURIComponent(movie.moviePoster))
            .replace('{{title}}', movie.movieTitle)
            .replace('{{year}}', movie.movieYear)
            .replace('{{description}}', movie.movieDescription);

        res.sendHtml('./views/details.html', movieHtml);
    } else {
        return true;
    }
}

module.exports = movieDetailsHandler;