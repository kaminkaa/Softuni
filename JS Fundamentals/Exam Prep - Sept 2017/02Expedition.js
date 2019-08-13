// obhozhdane na matriza:
function solve(primaryMatrix, secondaryMatrix, overlayCoordinates, startingCoordinates) {
    // overlaying the maps:
    for (let overlayCoordinate of overlayCoordinates) {
        let rowIndex = overlayCoordinate[0];
        let colIndex = overlayCoordinate[1];

        for (let r = 0; r < secondaryMatrix.length; r++) {
            colIndex = overlayCoordinate[1];
            for (let c = 0; c < secondaryMatrix[r].length; c++) {
                if (secondaryMatrix[r][c] === 1) {
                    primaryMatrix[rowIndex][colIndex] = (primaryMatrix[rowIndex][colIndex] === 1 ? 0 : 1);
                }
                colIndex++;
                if (colIndex > primaryMatrix[r].length-1) { break;}
            }
            rowIndex++;
            if (rowIndex > primaryMatrix.length-1) { break;}
        }
    }

    // searching for a way back:
    let primaryMatrixRows = primaryMatrix.length;
    let primaryMatrixCols = primaryMatrix[0].length;

    let steps = 1;
    let currentPosition = [startingCoordinates[0], startingCoordinates[1]];
    let previousDirection;


    while (true) {
        // otivane nadolu ako sledvashtia red e vutre v matrizata, ako v kletkata nadolu stoinostta e 0, ako predishnata pozicia e nagore:
        if (currentPosition[0] + 1 < primaryMatrixRows && primaryMatrix[currentPosition[0] + 1][currentPosition[1]] === 0 && previousDirection !== "up") {
            currentPosition = [currentPosition[0] + 1, currentPosition[1]];
            previousDirection = "down";
        } else if (currentPosition[1] + 1 < primaryMatrixCols && primaryMatrix[currentPosition[0]][currentPosition[1] + 1] === 0 && previousDirection !== "left") {
            currentPosition = [currentPosition[0], currentPosition[1] + 1];
            previousDirection = "right";
        } else if (currentPosition[0] > 0 && primaryMatrix[currentPosition[0] - 1][currentPosition[1]] === 0 && previousDirection !== "down") {
            currentPosition = [currentPosition[0] - 1, currentPosition[1]];
            previousDirection = "up";
        } else if (currentPosition[1] > 0 && primaryMatrix[currentPosition[0]][currentPosition[1] - 1] === 0 && previousDirection !== "right") {
            currentPosition = [currentPosition[0], currentPosition[1] - 1];
            previousDirection = "left";
        } else {
            break;
        }
        steps++;
    }

    console.log(steps);
    let currentRow = currentPosition[0];
    let currentCol = currentPosition[1];
    if (currentRow === 0) {
        console.log("Top");
    } else if (currentRow === primaryMatrixRows - 1) {
        console.log("Bottom");
    } else if (currentCol === 0) {
        console.log("Left");
    } else if (currentCol === primaryMatrixCols - 1) {
        console.log("Right");
    } else if (currentRow < primaryMatrixRows / 2 && currentCol >= primaryMatrixCols / 2) {
        console.log("Dead end 1");
    } else if (currentRow < primaryMatrixRows / 2 && currentCol < primaryMatrixCols / 2) {
        console.log("Dead end 2");
    } else if (currentRow >= primaryMatrixRows / 2 && currentCol < primaryMatrixCols / 2) {
        console.log("Dead end 3");
    } else if (currentRow >= primaryMatrixRows / 2 && currentCol >= primaryMatrixCols / 2) {
        console.log("Dead end 4");
    }
}

solve([[1, 1, 0, 1, 1, 1, 1, 0],
        [0, 1, 1, 1, 0, 0, 0, 1],
        [1, 0, 0, 1, 0, 0, 0, 1],
        [0, 0, 0, 1, 1, 0, 0, 1],
        [1, 0, 0, 1, 1, 1, 1, 1],
        [1, 0, 1, 1, 0, 1, 0, 0]],
    [[0, 1, 1],
        [0, 1, 0],
        [1, 1, 0]],
    [[1, 1],
        [2, 3],
        [5, 3]],
    [0, 2]);