function showView(viewName) {
    $('main > section').hide(); // Hide all views
    $('#' + viewName).show();   // Show the selected view
}

async function arrangeMenuLinks() {
    let authToken = sessionStorage.getItem('authToken');
    let headers = window.headers.noUser;

    if (authToken) {
        headers = window.headers.loggedInUser;
    }

    let source = await $.get('./templates/header-template.hbs');
    let compile = Handlebars.compile(source);
    let template = compile({
        headers
    });

    if ($('#menu').length) {
        $('#menu').html(template);
    } else {
        $('#app').append(template);
    }

    attackEventListeners();
}

function showHomeView() {
    showView('viewHome');
}

function showLoginView() {
    showView('viewLogin');
    $('#formLogin').trigger('reset');
}

function showRegisterView() {
    showView('viewRegister');
    $('#formLogin').trigger('reset');
}

function showCreateAdFormView() {
    showView('viewCreateAd');
    $('#formLogin').trigger('reset');
}

function showError(msg) {
    $('#errorBox').text("Error! " + msg).show();
}

function showInfo(msg) {
    $('#infoBox').text(msg).show();
    setTimeout(function () {
        $('#infoBox').fadeOut();
    }, 3000);
}

