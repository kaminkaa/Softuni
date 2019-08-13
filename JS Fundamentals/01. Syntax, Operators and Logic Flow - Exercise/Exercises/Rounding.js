function solve(input) {
    let number = input[0];
    let precision = (input[1] > 15) ? 15 : input[1];

    console.log(parseFloat(number.toFixed(precision)));
}

solve([10.5, 3]);