function solve(str, substr) {
    console.log(str.substring(0,substr.length) === substr);
}

solve('How have you been?', 'how');
solve('The quick brown fox…', 'The quick brown fox…');