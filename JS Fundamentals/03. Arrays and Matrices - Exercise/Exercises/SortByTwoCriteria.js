function solve(input) {
    // orders by alphabetical value and then orders by length:
    return input.sort((a, b) => a.toLowerCase().localeCompare(b.toLowerCase()))
        .sort((a, b) => a.length - b.length)
        .join('\n');
}


console.log(solve(['alpha', 'beta', 'gamma']));