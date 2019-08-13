function solve(n) {

    let output = '';

    let middle = 0;
    let length = 0;
    let width = n*2 - 1;
    let widthMiddle =  Math.floor(width / 2) + 1;

    if (n%2 === 0) {
        middle = n/2;
        length = n-1;
    } else {
        middle = Math.floor(n / 2) + 1;
        length = n;
    }

    for (let i = 1; i <= length; i++) {
        if (i === 1 || i === length || i === middle) {
            for (let i = 1; i <= width; i++) {
                if (i === 1 || i === width || i === widthMiddle) {
                    output += '+';
                } else {
                    output += '-';
                }
            }
        } else {
            for (let i = 1; i <= width; i++) {
                if (i === 1 || i === width || i === widthMiddle) {
                    output += '|';
                } else {
                    output += ' ';
                }
            }
        }

        output += '\n';
    }

    console.log(output);
}

solve(7);