// regex:
function solve(sentence, word) {
    let count = 0;
    let regex = new RegExp('\\b' + word + '\\b', 'gi');

    while (regex.exec(sentence)) {
        count++;
    }

    console.log(count);
}

solve('The waterfall was so high, that the child couldn’t see its peak.', 'the');