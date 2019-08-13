function homeHandler(req, res) {
    if (req.path == '/' || req.path == '/home.html') {
        res.sendHtml('./views/home.html');
    } else {
        return true;
    }
}

module.exports = homeHandler;