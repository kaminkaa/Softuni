function solve(matrix) {
    let count = 0;

    for (let row = 0; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            // check for vertical pairs:
            if ( row + 1 < matrix.length) {
                if (matrix[row][col] === matrix[row + 1][col]) {
                    count++;
                }
            }
            // check for horizontal pairs:
            if (col + 1 < matrix[row].length) {
                if (matrix[row][col] === matrix[row][col + 1]) {
                    count++;
                }
            }
        }
    }

    return count;
}

console.log(solve([['test', 'yes', 'yo', 'ho'],
    ['well', 'done', 'yo', '6'],
    ['not', 'done', 'yet', '5']]
));