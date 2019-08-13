// sorting arrays
function solve(input) {

    input.sort(((a, b) => a-b));

    // take elements at indexes 0 and 1:
    let result = input.slice(0,2);

    return result.join(' ');
}

console.log(solve([30,15,50,5]));