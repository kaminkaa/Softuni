function solve(arrStr) {

    let towns = new Map();

    for (let str of arrStr) {
        let[name,value] = str.split(/\s*<->\s*/).filter(a => a!== ' ');
        if(towns.has(name)) {
            towns.set(name, towns.get(name) + Number(value));
        } else {
            towns.set(name,Number(value));
        }
    }

    for (let [name, value] of towns) {
        console.log(name + ' : ' + value);
    }
}

solve(
    ['Istanbul <-> 100000',
    'Honk Kong <-> 2100004',
    'Jerusalem <-> 2352344',
    'Mexico City <-> 23401925',
    'Istanbul <-> 1000']
);