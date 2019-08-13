function solve(input) {
    let matrix = [];
    let row = '';

    for (let i = 0; i < input.length; i++) {
        row = input[i] + '';
        matrix.push(row.split(' ').map(Number));
    }

    let diagonal1 = 0, diagonal2 = 0;

    for (let row = 0; row < matrix.length; row++) {
        diagonal1 += matrix[row][row];
        diagonal2 += matrix[row][matrix.length-row-1];
    }

    if (diagonal1 === diagonal2) {
        for (let r = 0; r < matrix.length; r++) {
            for (let c = 0; c < matrix[r].length; c++) {
                if (r !== c && c !== matrix.length-r-1) {
                    matrix[r][c] = diagonal1;
                }
            }
        }
    }

    // print matrix:
    let rowStr = '';
    for (let r = 0; r < matrix.length; r++) {
        for (let c = 0; c < matrix[r].length; c++) {
            rowStr += matrix[r][c] + ' ';
        }
        rowStr += '\n';
    }

    console.log(rowStr);
}

solve(
    ['5 3 12 3 1',
    '11 4 23 2 5',
    '101 12 3 21 10',
    '1 4 5 2 2',
    '5 22 33 11 1']

);