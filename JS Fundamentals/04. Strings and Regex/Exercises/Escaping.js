function solve(arrStr) {
    let output = '<ul>\n';
    for (let current of arrStr) {
     output += '    <li>' + escapedString(current) + '</li>\n';
    }
    output += '</ul>';

    console.log(output);

    function escapedString (string) {
        return string.replace(/&/g, '&amp')
            .replace(/</g, '&lt;')
            .replace(/>/g, '&gt;')
            .replace(/"/g, '&quot;')
            .replace(/'/g, '&#39;');
    }
}

solve(['<b>unescaped text</b>', 'normal text']);
solve((["<br>", "It's OK"]));