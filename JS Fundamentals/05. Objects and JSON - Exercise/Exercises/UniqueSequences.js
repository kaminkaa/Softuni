// sorting sets:
function solve(arrStr) {
    let record = new Set();

    // sort every input array in descending order
    for (let json of arrStr) {
        let array = JSON.parse(json).sort((a, b) => {
            if (a < b) return 1;
            if (a > b) return -1;
        });

        let toString = JSON.stringify(array);

        record.add(toString);
    }

    // sort arrays by length in ascending order, then by order of being received:
    record = [...record].sort((a, b) => {
        let arr1 = JSON.parse(a);
        let arr2 = JSON.parse(b);
        if (arr1.length < arr2.length) return -1;
        if (arr1.length > arr2.length) return 1;
    });

    for (let array of record) {
        let toNumbers = JSON.parse(array);

        console.log('[' + toNumbers.join(', ') + ']');
    }
}

solve([
    '[-3, -2, -1, 0, 1, 2, 3, 4]',
    '[10, 1, -17, 0, 2, 13]',
    '[4, -3, 3, -2, 2, -1, 1, 0]'
]);