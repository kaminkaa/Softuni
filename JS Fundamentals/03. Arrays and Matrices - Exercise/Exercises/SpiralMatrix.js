function solve(rows, cols) {

    let number = 1;
    let targetNum = rows * cols;
    let round = 0;

    // create a matrix and fill it with zeroes:
    let matrix = [];
    for (let r = 0; r < rows; r++) {
        matrix.push('0'.repeat(cols).split('').map(Number));
    }

    let currentRow = 0;
    let currentCol = 0;

    while (targetNum >= number) {
        // row top:
        for (let i = 0; i < cols - round; i++) {
            matrix[currentRow][currentCol] = number++;
            currentCol++;
        }

        // column downwards:
        currentCol--;
        for (let i = 0; i < rows - 1 - round; i++) {
            currentRow++;
            matrix[currentRow][currentCol] = number++;
        }

        // row bottom:
        currentCol--;
        for (let i = 0; i < cols - 1 - round; i++) {
            matrix[currentRow][currentCol] = number++;
            currentCol--;
        }

        // column upwards:
        currentCol = round/2;
        for (let i = 0; i < rows - 2 - round; i++) {
            currentRow--;
            matrix[currentRow][currentCol] = number++;
        }

        currentCol++;
        round += 2;
    }

    // print matrix:
    console.log(matrix.map(row => row.join(' '))
        .join('\n'));
}

solve(5 ,5);