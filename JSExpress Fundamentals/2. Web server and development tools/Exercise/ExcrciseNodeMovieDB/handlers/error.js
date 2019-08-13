function errorHandler(req, res) {
    res.sendHtml('./views/error.html');
    //return; // mnogo e vajen!!! ako ima kod po-nadolu   
}

module.exports = errorHandler;