// regex:
// String.replace overload with a callback:
function solve(text) {
    let pattern = /(-?\d+)\s*\*\s*(-?\d+(\.\d+)?)/g;
    text = text.replace(pattern, (match, num1, num2) => Number(num1) * Number(num2));
    console.log(text);
}

solve('My bill: 2*2.50 (beer); 2* 1.20 (kepab); -2  * 0.5 (deposit).');

