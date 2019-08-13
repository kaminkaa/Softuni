// nested functions:
function wordsUppercase(str) {
    let strUpper = str.toUpperCase();
    let words = extractWords();
    words = words.filter(w => w !== '');
    return words.join(', ');

    // inner functions have access to variable from their parent:
    function extractWords() { return strUpper.split(/\W+/); }
}

console.log(wordsUppercase('Hi, how are you?'));