const BASE_URL = 'https://baas.kinvey.com/';
const APP_KEY = 'kid_HkPRzR1oz';
const APP_SECRET = '209a7cf0384041d48732865fef63e6d3';
const AUTH_HEADERS = {
    'Authorization': "Basic " + btoa(APP_KEY + ":" + APP_SECRET),
    'Content-Type': 'application/json'
};

async function register(data) {

    return await fetch(BASE_URL + 'user/' + APP_KEY, {
        method: 'POST',
        body: JSON.stringify(data),
        headers: AUTH_HEADERS
    }).then(data => data.json())
        .then(response => signInUser(response, 'Registration successful'));
}

async function login(data) {

    return await fetch(BASE_URL + 'user/' + APP_KEY + '/login', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: AUTH_HEADERS
    }).then(data => data.json())
        .then(response => signInUser(response, 'Login successful'));
}

function signInUser(response, msg) {

    if (response.hasOwnProperty('error')) {
        return {
            'success': false,
            'msg': response.description
        };
    }

    localStorage.setItem('username', response.username);
    localStorage.setItem('authToken', response._kmd.authtoken);
    localStorage.setItem('userId', response._id);

    return {
        'success': true,
        'msg': msg
    };
}

function logout() {
    localStorage.clear();
}

export { register, login, logout }