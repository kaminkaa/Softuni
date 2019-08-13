// variables holding functions & functions as parameters:
function calculate(a, b, op) {

    // variables holding functions:
    let calc = function(a, b, op) { return op(a, b) };
    let add = function(a, b) { return a + b }; // --> == function add(a, b) { return a + b; }, but as a variable can be passed to another function as a parameter
    let subtract = function(a, b) { return a - b };
    let multiply = function(a, b) { return a * b };
    let divide = function(a, b) { return a / b };

    switch (op) {
        case '+': return calc(a, b, add);
        case '-': return calc(a, b, subtract);
        case '*': return calc(a, b, multiply);
        case '/': return calc(a, b, divide);
    }
}

console.log(calculate(2, 4, '+'));
