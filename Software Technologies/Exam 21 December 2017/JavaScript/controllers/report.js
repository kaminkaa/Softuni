const Report = require('../models/Report');

module.exports = {
    index: (req, res) => {
        // Get all reports and pass them to the index view
        Report.find({}).then(reports => {
            res.render('report/index', {'reports': reports})
        })
    },
    createGet: (req, res) => {
        // Render the create view
        res.render('report/create');
    },
    createPost: (req, res) => {
        // Get the entered data from the form
        let report = req.body;

        // Create the report
        Report.create(report);

        // Redirect user to home page
        res.redirect('/');
    },
    detailsGet: (req, res) => {
        // Get the id of the report
        let id = req.params.id;

        // Get the report and pass it to the details view
        Report.findById(id).then(report => {
            res.render('report/details', report);
        });
    },
    deleteGet: (req, res) => {
        // Get the id of the report to be deleted
        let id = req.params.id;

        // Get the report and pass it to the delete view
        Report.findById(id).then(report => {
            res.render('report/delete', report);
        });
    },
    deletePost: (req, res) => {
        // Get the id of the report to be deleted
        let id = req.params.id;

        // Get the report, delete it and redirect user to home page
        Report.findByIdAndRemove(id).then(
            res.redirect('/')
        );
    }
};