function solve(str) {
    let words = str.split(' ');
    let newWords = [];
    for (let word of words) {
        let newWord = word[0].toUpperCase() + word.substring(1).toLowerCase();
        newWords.push(newWord);
    }

    console.log(newWords.join(' '));
}

solve('Capitalize these words');
solve('Was that Easy? tRY thIs onE for SiZe!');