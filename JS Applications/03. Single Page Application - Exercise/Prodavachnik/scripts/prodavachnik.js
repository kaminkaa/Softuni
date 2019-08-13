const BASE_URL = 'https://baas.kinvey.com/';
const APP_KEY = 'kid_HkPRzR1oz';
const APP_SECRET = '209a7cf0384041d48732865fef63e6d3';
const AUTH_HEADERS = {'Authorization': "Basic " + btoa(APP_KEY + ":" + APP_SECRET)};


function startApp() {
    arrangeMenuLinks();
    showView('viewHome');
    attackEventListeners();
}

function registerUser() {
    let username = $('#formRegister input[name=username]').val();
    let password = $('#formRegister input[name=passwd]').val();

    $.ajax({
        method: 'POST',
        url: BASE_URL + 'user/' + APP_KEY + '',
        headers: AUTH_HEADERS,
        data: {username, password}
    }).then(function (res) {
        signInUser(res, 'Registration successful.')
    }).catch(handleError);
}

function loginUser() {
    let username = $('#formLogin input[name=username]').val();
    let password = $('#formLogin input[name=passwd]').val();

    $.ajax({
        method: 'POST',
        url: BASE_URL + 'user/' + APP_KEY + '/login',
        headers: AUTH_HEADERS,
        data: {username, password}
    }).then(function (res) {
        console.log(res);
        signInUser(res, 'Login successful.')
    }).catch(handleError);
}

function signInUser(res, msg) {
    sessionStorage.setItem('username', res.username);
    sessionStorage.setItem('authToken', res._kmd.authtoken);
    sessionStorage.setItem('userId', res._id);
    showHomeView();
    arrangeMenuLinks();
    showInfo(msg);
}

function logoutUser() {
    sessionStorage.clear();
    showHomeView();
    arrangeMenuLinks();
    showInfo('Logout successful.');
}

function createAd() {
    let title = $('#formCreateAd input[name=title]').val();
    let description = $('#formCreateAd textarea[name=description]').val();
    let datePublished = $('#formCreateAd input[name=datePublished]').val();
    let price = $('#formCreateAd input[name=price]').val();
    let publisher = sessionStorage.getItem('username');

    $.ajax({
        method: 'POST',
        url: BASE_URL + 'appdata/' + APP_KEY + '/ads',
        data: {title, description, datePublished, price, publisher},
        headers: {'Authorization': 'Kinvey ' + sessionStorage.getItem('authToken')}
    }).then(function (res) {
        showInfo('Ad created!')
        $('#formCreateAd input[name=title]').val('');
        $('#formCreateAd textarea[name=description]').val('');
        $('#formCreateAd input[name=datePublished]').val('');
        $('#formCreateAd input[name=price]').val('');
    }).catch(handleError);
}

function listAds() {
    $.ajax({
        method: 'GET',
        url: BASE_URL + 'appdata/' + APP_KEY + '/ads',
        headers: {'Authorization': 'Kinvey ' + sessionStorage.getItem('authToken')}})
        .then(displayAds)
        .catch(handleError);
}

function displayAds(ads) {
    $('#ads tr').slice(1).remove();
    for (let ad of ads) {
        let adRow = $('<tr>');
        adRow
            .append($(`<td>${ad.title}</td>`))
            .append($(`<td>${ad.publisher}</td>`))
            .append($(`<td>${ad.description}</td>`))
            .append($(`<td>${ad.price}</td>`))
            .append($(`<td>${ad.datePublished}</td>`));

        if(ad._acl.creator === sessionStorage.getItem('userId')) {
            adRow.append($('<td>')
                .append($('<a href="#">[Delete]</a>').on('click', function () {
                    deleteAd(ad);
                }))
                .append($('<a href="#">[Edit]</a>').on('click', function () {
                    editAd(ad);
                })));
        } else {
            adRow.append($('<td align="center">-</td>'));
        }

        $('#ads > table').append(adRow);
    }
}

function deleteAd(ad) {
    $.ajax({
        method: 'DELETE',
        url: BASE_URL + 'appdata/' + APP_KEY + '/ads/' + ad._id,
        headers: {'Authorization': 'Kinvey ' + sessionStorage.getItem('authToken')}
    }).then(function () {
        listAds();
        showInfo('Ad deleted.');
    }).catch(handleError);
}

function editAd(ad) {
    $('#formEditAd input[name=title]').val(ad.title);
    $('#formEditAd textarea[name=description]').val(ad.description);
    $('#formEditAd input[name=datePublished]').val(ad.datePublished);
    $('#formEditAd input[name=price]').val(ad.price);
    showView('viewEditAd');
    $('#buttonEditAd').on('click', updateAdData);

    function updateAdData() {
        let title = $('#formEditAd input[name=title]').val();
        let description = $('#formEditAd textarea[name=description]').val();
        let datePublished = $('#formEditAd input[name=datePublished]').val();
        let price = $('#formEditAd input[name=price]').val();
        let publisher = sessionStorage.getItem('username');

        console.log(ad._id);

        $.ajax({
            method: 'PUT',
            url: BASE_URL + 'appdata/' + APP_KEY + '/ads/' + ad._id,
            data: {title, description, datePublished, price, publisher},
            headers: {'Authorization': 'Kinvey ' + sessionStorage.getItem('authToken')}
        }).then(function (res) {
            showInfo('Ad edited!');
        }).catch(handleError);
    }
}

function handleError(err) {
    let errorMessage = JSON.stringify(err);
    if (err.readyState === 0) {
        errorMessage = 'Network error';
    }
    if (err.responseJSON && err.responseJSON.description) {
        errorMessage = err.responseJSON.description;
    }
    showError(errorMessage);
}