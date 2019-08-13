// regex:
function solve(text) {
    let pattern = /[a-zA-Z_0-9]+/g;
    let result = text.match(pattern);

    console.log(result.join('|'));
}

solve('_(Underscores) are also word characters');
solve('A Regular Expression needs to have the global flag in order to match all occurrences in the text');