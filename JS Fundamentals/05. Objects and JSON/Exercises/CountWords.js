// associative arrays
function solve(arrStr) {
    let text = arrStr.join('\n');
    let words = text.split(/[^A-Za-z0-9_]+/).filter(w => w !== '');
    let wordsCounter = {};
    for (let word of words) {
        if (wordsCounter.hasOwnProperty(word)) {
            wordsCounter[word] ++;
        } else {
            wordsCounter[word] = 1;
        }
    }
    console.log(JSON.stringify(wordsCounter));
}

solve(['Far too slow, you\'re far too slow.']);