function solve(arr) {
    arr.map(element => Number(element));
    let sum = reduce(arr, (a,b) => a + b);
    let min = reduce(arr, (a,b) =>Math.min(a,b));
    let max = reduce(arr, (a,b) =>Math.max(a,b));
    let product = reduce(arr, (a,b) => a * b);
    let join = reduce(arr, (a,b) => a + '' + b);

    console.log('Sum = ' + sum);
    console.log('Min = ' + min);
    console.log('Max = ' + max);
    console.log('Product = ' + product);
    console.log('Join = ' + join);

    function reduce(arr, func) {
        let result = arr[0];
        for (let nextElement of arr.slice(1))
            result = func(result, nextElement);
        return result;
    }
}

solve([5, -3, 20, 7, 0.5]);