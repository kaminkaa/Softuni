function solve(input) {

    let number = input;
    let digitsAverage = getDigitsAverage(number);

    while (digitsAverage <= 5) {
        let numberStr = number + '9';
        number = Number(numberStr);
        digitsAverage = getDigitsAverage(number);
    }

    console.log(number);

    function getDigitsAverage(number) {
        let sum = 0;
        let count = 0;

        while (Math.floor(number) > 0) {
            sum += Math.floor(number) % 10;
            number /= 10;
            count++;
        }

        return sum/count;
    }
}

solve(55);