function evenPositions(arr) {
    let result = [];

    // for ... in -> goes through array indices
    for (let i in arr)
        if (i % 2 === 0)
            result.push(arr[i]);
    return result.join(' ');
}

console.log(evenPositions([20,30,40]));