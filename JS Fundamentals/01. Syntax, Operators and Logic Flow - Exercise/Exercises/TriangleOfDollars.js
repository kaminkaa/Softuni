function solve(n) {

    let line = '';

    for (let i = 1; i <= n; i++) {
        line = '';
        for (let j = 0; j < i; j++) {
            line += '$';
        }
        console.log(line);
    }
}

solve(3);