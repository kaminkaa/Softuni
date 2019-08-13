const BASE_URL = 'https://baas.kinvey.com/';
const APP_KEY = 'kid_HkPRzR1oz';
const AUTH_HEADERS = {
    'Authorization': "Kinvey " + localStorage.getItem('authToken'),
    'Content-Type': 'application/json'
};

async function updateUser(id, data) {

    return await fetch(BASE_URL + 'user/' + APP_KEY + '/' + id, {
        method: 'PUT',
        body: JSON.stringify(data),
        headers: AUTH_HEADERS
    }).then(data => data.json())
        .then(response => verifySuccess(response, 'User updated successfully'));
}

function verifySuccess(response, msg) {

    if (response.hasOwnProperty('error')) {
        return {
            'success': false,
            'msg': response.description
        };
    }

    return {
        'success': true,
        'msg': msg
    };
}

async function getUsersUsernames() {

    return await fetch(BASE_URL + 'user/' + APP_KEY + '/?query={}&fields=username&sort=_id', {
        method: 'GET',
        headers: AUTH_HEADERS
    }).then(data => data.json());
}

async function getUserInfo(username) {

    return await fetch(BASE_URL + 'user/' + APP_KEY + `/?query={"username":"${username}"}`, {
        method: 'GET',
        headers: AUTH_HEADERS
    }).then(data => data.json());
}

async function getUsersPerPage(page, count) {
    let skip = (page - 1) * count;

    return await fetch(BASE_URL + 'user/' + APP_KEY + '/?query={}&skip=' + skip + '&limit=' + count, {
        method: 'GET',
        headers: AUTH_HEADERS
    }).then(data => data.json());
}

async function getUsersCount() {

    return await fetch(BASE_URL + 'user/' + APP_KEY + '/_count', {
        method: 'GET',
        headers: AUTH_HEADERS
    }).then(data => data.json());
}

export { getUsersUsernames, getUserInfo, updateUser, getUsersPerPage, getUsersCount };