function solve(str) {
    let result = [];
    let startIndex = str.indexOf('(');

    while (startIndex !== -1) {
        let endIndex = str.indexOf(')', startIndex);
        if (endIndex === -1) {
            break;
        }

        let snippet = str.substring(startIndex + 1, endIndex);
        result.push(snippet);
        startIndex = str.indexOf('(', endIndex);
    }

    console.log(result.join(', '));
}

solve('Rakiya (Bulgarian brandy) is self-made liquor (alcoholic drink)');