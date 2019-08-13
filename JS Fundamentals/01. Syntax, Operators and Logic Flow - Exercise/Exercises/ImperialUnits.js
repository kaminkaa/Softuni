function solve(n) {
    if (n < 12) {
        console.log('0\'-' + n + '\"');
    } else {
        console.log(Math.floor(n/12) + '\'-' + n%12 + '\"');
    }
}

solve(12);