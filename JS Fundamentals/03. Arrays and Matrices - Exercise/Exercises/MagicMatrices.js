function solve(matrix) {

    let rowSum = 0;

    for (let i = 0; i < matrix[0].length; i++) {
        rowSum += matrix[0][i];
    }

    for (let r = 1; r < matrix.length; r++) {
        let prevRowSum = rowSum;
        rowSum = 0;
        for (let c = 0; c < matrix[r].length; c++) {
            rowSum += matrix[r][c];
        }
        if (prevRowSum !== rowSum) {
            return false;
        }
    }

    let colSum = 0;

    for (let i = 0; i < matrix.length; i++) {
        colSum += matrix[i][0];
    }

    for (let c = 1; c < matrix.length; c++) {
        let prevColSum = colSum;
        colSum = 0;
        for (let r = 0; r < matrix.length; r++) {
            colSum += matrix[r][c];
        }
        if (prevColSum !== colSum) {
            return false;
        }
    }

    return rowSum === colSum;
}

console.log(solve([[4, 5, 6],
    [6, 5, 4],
    [5, 5, 5]]
));

console.log(solve([[11, 32, 45],
    [21, 0, 1],
    [21, 1, 1]]
));