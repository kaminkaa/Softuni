const BASE_URL = 'https://baas.kinvey.com/';
const APP_KEY = 'kid_HkPRzR1oz';
const AUTH_HEADERS = {
    'Authorization': "Kinvey " + localStorage.getItem('authToken'),
    'Content-Type': 'application/json'
}; 

async function addPlayer(data) {

    return await fetch(BASE_URL + 'appdata/' + APP_KEY + '/players', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: AUTH_HEADERS
    }).then(data => data.json())
        .then(response => verifySuccess(response, 'Player added successfully'));
}

async function updatePlayer(id, data) {

    return await fetch(BASE_URL + 'appdata/' + APP_KEY + '/players/' + id, {
        method: 'PUT',
        body: JSON.stringify(data),
        headers: AUTH_HEADERS
    }).then(data => data.json())
        .then(response => verifySuccess(response, 'Player updated successfully'));
}

async function deletePlayer(id) {

    return await fetch(BASE_URL + 'appdata/' + APP_KEY + '/players/' + id, {
        method: 'DELETE',
        headers: AUTH_HEADERS
    }).then(data => data.json())
        .then(response => verifySuccess(response, 'Player deleted successfully'));
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

async function getPlayersForSaleCount() {

    return await fetch(BASE_URL + 'appdata/' + APP_KEY + '/players/?query={"forSale":true}', {
        method: 'GET',
        headers: AUTH_HEADERS
    }).then(data => data.json());
}

async function getPlayersForSalePerPage(page) {
    let skip = (page - 1) * 6;

    return await fetch(BASE_URL + 'appdata/' + APP_KEY + '/players/?query={"forSale":true}&skip=' + skip + '&limit=6', {
        method: 'GET',
        headers: AUTH_HEADERS
    }).then(data => data.json());
}

async function getPlayersCount() {

    return await fetch(BASE_URL + 'appdata/' + APP_KEY + '/players/_count', {
        method: 'GET',
        headers: AUTH_HEADERS
    }).then(data => data.json());
}

async function getPlayersPerPage(page, count) {
    let skip = (page - 1) * count;

    return await fetch(BASE_URL + 'appdata/' + APP_KEY + '/players/?query={}&skip=' + skip + '&limit=' + count, {
        method: 'GET',
        headers: AUTH_HEADERS
    }).then(data => data.json());
}

async function getPlayerInfo(id) {

    return await fetch(BASE_URL + 'appdata/' + APP_KEY + '/players/' + id, {
        method: 'GET',
        headers: AUTH_HEADERS
    }).then(data => data.json());
}

async function getPlayersPerUser(username) {

    return await fetch(BASE_URL + 'appdata/' + APP_KEY + `/players/?query={"owner":"${username}"}`, {
        method: 'GET',
        headers: AUTH_HEADERS
    }).then(data => data.json());
}

export { addPlayer, updatePlayer, deletePlayer, getPlayersForSaleCount, getPlayersForSalePerPage, getPlayersCount, getPlayersPerPage, getPlayerInfo, getPlayersPerUser };