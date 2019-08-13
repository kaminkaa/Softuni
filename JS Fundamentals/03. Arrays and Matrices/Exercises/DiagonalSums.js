// matrix diagonals:
function solve(matrix) {
    let mainDiagonalSum = 0, secondaryDiagonalSum = 0;

    for (let row = 0; row < matrix.length; row++) {
        mainDiagonalSum += matrix[row][row];
        secondaryDiagonalSum += matrix[row][matrix.length-row-1];
    }

    console.log(mainDiagonalSum + ' ' + secondaryDiagonalSum);
}

solve([[3, 5, 17],
    [-1, 7, 14],
    [1, -8, 89]]
);