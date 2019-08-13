function solve(func) {
    let types = {};
    for (let i = 0; i < arguments.length; i++) {
        let obj = arguments[i];
        let type = typeof obj;
        console.log(type + ': ' + obj);

        if (!types[type]) {
            types[type] = 1;
        } else {
            types[type]++;
        }
    }

    let sortedTypes = [];
    for (let t in types) {
        sortedTypes.push([t, types[t]]);
    }

    let comparator = function (a, b) {
        return b[1] - a[1];
    };

    sortedTypes.sort(comparator);

    for (let current of sortedTypes) {
        console.log(current[0] + ' = ' + current[1]);
    }
}

solve('cat', 42, function () { console.log('Hello world!'); });