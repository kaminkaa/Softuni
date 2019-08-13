const qs = require('querystring');
let movies = require('../config/dataBase');

const errorTemplate = `
    <div id="errBox"><h2 id="errMsg">Please fill all fields</h2></div>
`;

const successTemplate = `
    <div id="succssesBox"><h2 id="succssesMsg">Movie Added</h2></div>
`;

function addMovieHandler(req, res) {
    if (req.path == '/addMovie' && req.method === 'GET') {
        res.sendHtml('./views/addMovie.html');
    } else if (req.path == '/addMovie' && req.method === 'POST') {
        let body = [];
        req.on('data', (chunk) => {
            body.push(chunk);
        }).on('end', () => {
            body = Buffer.concat(body).toString();

            let movieData = qs.parse(body);
            //console.log(movieData);

            if (!movieData.moviePoster || !movieData.movieTitle) {
                res.sendHtml('./views/addMovie.html', errorTemplate);
                return;
            }

            movies.push(movieData);

            res.sendHtml('./views/addMovie.html', successTemplate);
        })
    } else {
        return true;
    }
}

module.exports = addMovieHandler;