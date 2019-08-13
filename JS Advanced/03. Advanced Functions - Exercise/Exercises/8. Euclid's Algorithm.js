function solve(num1,num2) {
    if (num2 === 0) {
        return num1;
    } else {
        let reminder = num1 % num2;
        return solve(num2, reminder);
    }
}

console.log(solve(252, 105));