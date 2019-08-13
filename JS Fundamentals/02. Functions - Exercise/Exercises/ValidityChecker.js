function solve(input) {
    let x1 = input[0];
    let y1 = input[1];
    let x2 = input[2];
    let y2 = input[3];

    let point1to0status = validityChecker(x1,y1,0,0);
    console.log('{' + x1 + ', ' + y1 + '} to {0, 0} is ' + point1to0status);
    let point2to0status = validityChecker(x2,y2,0,0);
    console.log('{' + x2 + ', ' + y2 + '} to {0, 0} is ' + point2to0status);
    let point1topoint2status = validityChecker(x1,y1,x2,y2);
    console.log('{' + x1 + ', ' + y1 + '} to {' + x2 + ', ' + y2 + '} is ' + point1topoint2status);


    function validityChecker(x1, y1, x2, y2) {
        let distance = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
        if (Number.isInteger(distance)) {
            return 'valid';
        } else {
            return 'invalid';
        }
    }
}

solve([2, 1, 1, 1]);