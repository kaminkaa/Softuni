// objects
// input comes as a single string argument – the array of objects as a JSON
function solve(strArr) {
    let arr = JSON.parse(strArr);
    let result = '<table>\n';
    let keys = Object.keys(arr[0]);
    result += `  <tr><th>${keys[0]}</th><th>${keys[1]}</th></tr>\n`;

    for (let obj of arr) {
        result += `  <tr><td>${htmlEscape(obj[keys[0]])}</td><td>${obj[keys[1]]}</td></tr>\n`;
    }

    result += '</table>';

    return result;

    function htmlEscape(text) {
        return text.replace(/&/g, '&amp;')
            .replace(/</g, '&lt;')
            .replace(/>/g, '&gt;')
            .replace(/"/g, '&quot;')
            .replace(/'/g, '&#39;');
    }
}

console.log(solve(
'[{"name":"Pesho","score":479},{"name":"Gosho","score":205}]'
));