let remote = (() => {
    const BASE_URL = 'https://baas.kinvey.com/';
    const APP_KEY = 'kid_S1pibjJnz';
    const APP_SECRET = 'a28bf5801ee042049a698813354d4107';

    function makeAuth(auth) {
        if (auth === 'basic') {
            return `Basic ${btoa(APP_KEY + ":" + APP_SECRET)}`;
        } else {
            return `Kinvey ${sessionStorage.getItem('authtoken')}`
        }
    }

    function makeRequest(method, module, endpoint, auth) {
        let request = {
            url: BASE_URL + module + '/' + APP_KEY + '/' + endpoint,
            method: method,
            headers: {
                'Authorization': makeAuth(auth)
            }
        };

        return request;
    }

    function get (module, endpoint, auth) {
        return $.ajax(makeRequest('GET', module, endpoint, auth));
    }

    function post (module, endpoint, auth, data) {
        let obj = makeRequest('POST', module, endpoint, auth);
        if (data) {
            obj.data = data;
        }
        return $.ajax(obj);
    }

    function update(module, endpoint, auth, data) {
        let obj = makeRequest('PUT', module, endpoint, auth);
        obj.data = data;
        return $.ajax(obj);
    }

    function remove(module, endpoint, auth) {
        return $.ajax(makeRequest('DELETE', module, endpoint, auth));
    }

    return {
        get,
        post,
        update,
        remove
    }
})();