// matrices:
function solve(matrix) {
    let biggestNumber = Number.NEGATIVE_INFINITY;
    matrix.forEach(
        r => r.forEach(
            c => biggestNumber = Math.max(biggestNumber, c)
        )
    );
    return biggestNumber;
}

console.log(solve([[20, 50, 10], [8, 33, 145]]));

///////////////////////////////////////////////////////////////////////////////

function solve2(matrix) {
    let biggestNumber = Number.NEGATIVE_INFINITY;

    for (let r = 0; r < matrix.length; r++) {
        for (let c = 0; c < matrix[r].length; c++) {
            if (matrix[r][c] > biggestNumber) {
                biggestNumber = matrix[r][c];
            }
        }
    }

    return biggestNumber;
}

console.log(solve2([[20, 50, 10], [8, 33, 145]]));
