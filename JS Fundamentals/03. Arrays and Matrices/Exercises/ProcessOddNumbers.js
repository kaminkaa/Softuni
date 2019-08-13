// filtering and transforming (mapping)
function solve(arr) {
    let result = arr
        .filter((num, i) => i % 2 === 1)
        .map(x => 2 * x)
        .reverse();

    console.log(result.join(' '));
}

solve([10, 15, 20, 25]);