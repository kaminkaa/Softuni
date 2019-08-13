function solve(input) {
    let principalSum = input[0];
    let interestRatePercent = input[1];
    let compoundingPeriodMonths = input[2];
    let totalTimespanYears = input[3];

    let P = principalSum;
    let i = interestRatePercent / 100 ;
    let n = 12 / compoundingPeriodMonths;
    let t = totalTimespanYears;

    let F = P * Math.pow((1 + i / n), n*t);

    console.log(F.toFixed(2));
}

solve([100000, 5, 12, 25]);