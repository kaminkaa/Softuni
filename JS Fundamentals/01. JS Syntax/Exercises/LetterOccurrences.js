function countLetterOccurences(word, letter) {
    var count = 0;

    for (var i = 0; i < word.length; i++) {
        var currentLetter = word.charAt(i);

        if (currentLetter === letter) {
            count++;
        }
    }

    return count;
}

console.log(countLetterOccurences('hello', 'l'));