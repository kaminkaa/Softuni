// objects
// input comes as a single string argument – the array of objects as a JSON
function solve(strArr) {
    let arr = JSON.parse(strArr);
    let result = '<table>\n';
    let keys = Object.keys(arr[0]);

    // print the names of the columns:
    result += ' <tr>';
    for (let key of keys) {
        result += `<th>${key}</th>`;
    }
    result += '</tr>\n';

    for (let obj of arr) {
        result += ' <tr>';
        for (let i = 0; i < keys.length; i++) {
            result += `<td>${htmlEscape(obj[keys[i]] + '')}</td>`;
        }
        result += '</tr>\n';
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

solve('[{"Name":"Tomatoes & Chips","Price":2.35},{"Name":"J&B Chocolate","Price":0.96}]');