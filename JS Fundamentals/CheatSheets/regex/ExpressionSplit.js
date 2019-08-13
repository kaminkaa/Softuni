// regex:
function solve (str) {
    let elements = str.split(/[\s.();,]+/);
    console.log(elements.join('\n'));
}

solve('let sum = 4 * 4,b = "wow";');