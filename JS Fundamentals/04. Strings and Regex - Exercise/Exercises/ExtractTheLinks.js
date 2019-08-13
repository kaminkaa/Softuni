// regex:
// 87 tochki s \b .. \b, 100 tochki bez tqh
function solve(arrStr) {
    let links = [];
    let regex =  /www\.([a-zA-Z0-9-]+)(\.[a-z]+){1,}/g;
    let match;

    for (let sentence of arrStr) {
        while (match = regex.exec(sentence)){
            links.push(match[0]);
        }
    }

    console.log(links.join('\n'));
}

solve(['Join WebStars now for free, at www.web-stars.com',
'You can also support our partners:',
'Internet - www.internet.com',
'WebSpiders - www.webspiders101.com',
'Sentinel - www.sentinel.-ko']);