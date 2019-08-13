// sets:
// regex:
function solve(arrStr) {
    let wordPattern = /\b[a-zA-Z0-9_]+\b/g;
    let uniqueWods = new Set();

    for (let sentence of arrStr) {
        let matches = sentence.match(wordPattern);
        matches.forEach(x => uniqueWods.add(x.toLowerCase()));
    }

    console.log([...uniqueWods.values()].join(', '));
}

solve(['JS and Node.js', 'JS again and again', 'Oh, JS?']);
