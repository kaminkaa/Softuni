// array of objects:
// from JSON:
function solve(strArr) {
    let data = [];

    for (let current of strArr) {
        let object = JSON.parse(current);
        data.push(object);
    }

    let result = '<table>\n';

    for (let current of data) {
        result += `    <tr>\n`;
        let keys =  Object.keys(current);
        for (let i = 0; i < keys.length; i++) {
            result += `        <td>${htmlEscape(current[keys[i]] + '')}</td>\n`;
        }
        result += `    <tr>\n`;
    }

    result += '</table>';
    console.log(result);

    function htmlEscape(text) {
        return text.replace(/&/g, '&amp;')
            .replace(/</g, '&lt;')
            .replace(/>/g, '&gt;')
            .replace(/"/g, '&quot;')
            .replace(/'/g, '&#39;');
    }
}

solve(['{"name":"Pesho","position":"Promenliva","salary":100000}','{"name":"Teo","position":"Lecturer","salary":1000}','{"name":"Georgi","position":"Lecturer","salary":1000}']);