function showView(viewName) {
    $('main > section').hide(); // Hide all views
    $('#' + viewName).show();   // Show the selected view
}

function arrangeMenuLinks() {
    $('#linkHome').show().on('click', showHomeView);
    // No logged in user:
    if (sessionStorage.getItem('authToken') === null) {
        $('#linkLogin').show();
        $('#linkRegister').show();
        $('#linkListAds').hide();
        $('#linkCreateAd').hide();
        $('#linkLogout').hide();
    }
    // There is a logged in user:
    if (sessionStorage.getItem('authToken') !== null) {
        $('#linkLogin').hide();
        $('#linkRegister').hide();
        $('#linkListAds').show();
        $('#linkCreateAd').show();
        $('#linkLogout').show();
    }
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

function showAdsView(ads) {
    showView('viewAds');
    listAds();
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

