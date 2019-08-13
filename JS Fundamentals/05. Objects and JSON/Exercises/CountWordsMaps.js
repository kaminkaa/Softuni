// maps
// sort a map by key alphabetically
function solve(input) {

    let myMap = new Map();

    for (let str of input) {

        let words = str.split(/[^0-9a-zA-Z_]+/)
            .filter(s => s.trim() !== '');

        for (let word of words) {
            word = word.toLowerCase();
            if (myMap.has(word)) {
                myMap.set(word, myMap.get(word) + 1);
            } else {
                myMap.set(word,1);
            }
        }
    }

    let keysSorted = Array.from(myMap.keys()).sort((a, b) => a.localeCompare(b));

    for (let key of keysSorted)
        console.log(`'${key}' -> ${myMap.get(key)} times`);
}

solve(['JS and Node.js', 'JS again and again', 'Oh, JS?']);