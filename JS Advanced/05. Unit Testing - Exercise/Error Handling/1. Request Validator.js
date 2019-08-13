function validateRequest(request) {
    if (Object.keys(request).length < 4) {
        if (!Object.keys(request).includes('method')) { throw new Error('Invalid request header: Invalid Method'); }
        if (!Object.keys(request).includes('uri')) { throw new Error('Invalid request header: Invalid URI'); }
        if (!Object.keys(request).includes('version')) { throw new Error('Invalid request header: Invalid Version'); }
        if (!Object.keys(request).includes('message')) { throw new Error('Invalid request header: Invalid Message'); }
    }

    let validMethods = ['GET', 'POST', 'DELETE', 'CONNECT'];
    if (!validMethods.includes(request.method)) {
        throw new Error('Invalid request header: Invalid Method');
    }

    let uriPattern = /^[a-zA-Z\.\d]+$/g;
    if (!uriPattern.test(request.uri) || request.uri.length <= 0) {
        if (request.uri !== '*') {
            throw new Error('Invalid request header: Invalid URI');
        }
    }

    let validVersions = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];
    if (!validVersions.includes(request.version)) {
        throw new Error('Invalid request header: Invalid Version');
    }

    let messagePattern = /^[^<>\\&'"]*$/g;
    if (!messagePattern.test(request.message)) {
        throw new Error('Invalid request header: Invalid Message');
    }

    return request;
}

console.log(validateRequest({
    method: 'GET',
    uri: 'svn.public.catalog',
    version: 'HTTP/1.1',
    message: ''
}));



