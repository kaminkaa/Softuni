const fs = require('fs');

const mimeTypes = {
    'css': 'text/css',
    'js': 'application/javascript',
    'png': 'image/png'
};

function publicHandler(req, res) {
    if (req.path.startsWith('/public/')) {
        const extension = req.path.split('.').pop();

        res.writeHead(200, {
            'content-type': mimeTypes[extension]
        });

        try {
            // za zarejdane na failove i kartinki, vmesto dolnoto zakomentirano:
            const read = fs.createReadStream('.' + req.path);
            read.pipe(res);
        } catch (err) {
            console.log(err);
            return true;
        }

        /*fs.readFile('.' + req.path, 'utf8', (err, data) => {
            console.log('.' + req.path);

            res.write(data);
            res.end();
        });*/

    } else {
        return true;
    }
}

module.exports = publicHandler;