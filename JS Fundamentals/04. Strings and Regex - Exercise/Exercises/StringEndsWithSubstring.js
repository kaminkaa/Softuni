function solve(str, substr) {
    console.log(str.substring(str.length-substr.length) === substr);
}

solve('This sentence ends with fun?', 'fun?');
solve('This is Houston, we have…', 'We have…');