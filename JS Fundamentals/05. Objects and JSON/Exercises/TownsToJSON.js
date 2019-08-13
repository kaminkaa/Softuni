// objects
// input comes as an array of strings:
function solve(input) {
    let result = [];
    // get the keys from the input:
    let keys = input[0].split(/\s*\|\s*/)
        .filter(st => st !== '');

    for (let i = 1; i < input.length; i++) {
        // create the object:
        let obj = {};
        // get the values per keys for each row:
        let [town, lat, long] = input[i].split(/\s*\|\s*/)
            .filter(st => st !== '');
        // fill in the object's properties:
        obj[keys[0]] = town;
        obj[keys[1]] = Number(lat);
        obj[keys[2]] = Number(long);

        // push the object to the result array:
        result.push(obj);
    }

    console.log(JSON.stringify(result));
}

solve(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']
);