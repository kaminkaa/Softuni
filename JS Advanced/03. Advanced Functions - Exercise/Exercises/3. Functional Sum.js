// IIFE:
let add = (function () {
    let sum = 0;

    function add(number) {
        sum += number;
        return add;
    }

    add.toString = function () {
        return sum;
    };

    return add;
})();

console.log(add(1)(20)+'');

