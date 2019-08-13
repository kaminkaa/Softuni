const http = require('http');
const url = require('url');
const fs = require('fs');
const port = 5000;
const handlers = require('./handlers');

const server = http.createServer(frontController);

const placeholder = `<div id="replaceMe">{{replaceMe}}</div>`;

// pishem tezi utochnenia za da se znae req i res kakvi sa i da imame pulen dostup do tehnite funkcii
/**
 * 
 * @param {http.ClientRequest} req 
 * @param {http.ClientResponse} res 
 */
function frontController(req, res) {
    // vmesto const path = url.parse(req.url).pathname; zakachame novo property path za request-a:
    req.path = url.parse(req.url).pathname;

    // dobavqme novo property kum response-a, za da ne se povtarq edin i sushti kod v handler-ite:
    res.sendHtml = (path, dynamicContent) => {
        // chetene na file: izpolzva se callback:
        fs.readFile(path, 'utf8', (err, data) => {
            if (err) {
                console.dir(err);
                res.writeHead(500, {
                    'content-type': 'text/plain'
                });
                res.end(`Could not read file with path "${path}".`);
                return;
            }

            if (dynamicContent) {
                data = data.replace(placeholder, dynamicContent); // replace trqbva da e = na neshto, immutable e!!
            }

            // vajno e da se izprashta pravilen header:
            res.writeHead(200, {
                'content-type': 'text/html'
            });
            res.write(data); // mojem da podadem string ili bufer
            res.end(); // zaduljitelno trqbva da imame end nakraq za da se znae che survura e prikluchil
        });
    };

    // zarejdane na dinamichen html:


    // vzimame zaqvkata i q prashtame na vsichki handleri dokato nqkoi si q poznae i otreagira:
    for (let handler of handlers) {
        if (handler(req, res) !== true) {
            break;
        }
    }

}

server.listen(port);
console.log('Listening on port ' + port + '...');