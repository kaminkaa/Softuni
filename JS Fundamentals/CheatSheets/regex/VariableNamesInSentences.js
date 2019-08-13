// regex:
function solve(str) {
    let variables = [];
    let regex = /\b[_][a-zA-Z0-9]+\b/g;
    let match;

    while (match = regex.exec(str)) {
        let variable = match + '';
        variables.push(variable.substring(1));
    }

    console.log(variables.join(','));
}

solve('__invalidVariable _evenMoreInvalidVariable_ _validVariable');
solve('Calculate the _area of the _perfectRectangle object.');