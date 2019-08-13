// array of objects:
// to JSON:
function solve(arrStr) {
    // array that holds the data:
    let heroData = [];

    // loop over the whole input and process it
    for (let current of arrStr) {
        let currentHeroArgs = current.split(' / ');

        let currentName = currentHeroArgs[0];
        let currentLevel = Number(currentHeroArgs[1]);
        let currentItems = [];
        if (currentHeroArgs.length > 2) currentItems = currentHeroArgs[2].split(', ');

        // add the data into an object:
        let hero = {
            name: currentName,
            level: currentLevel,
            items: currentItems
        };

        // push the object into the array:
        heroData.push(hero);
    }

    // turn the array of objects into a JSON string:
    console.log(JSON.stringify(heroData));
}

solve(['Isacc / 25 / Apple, GravityGun\n' ,
'Derek / 12 / BarrelVest, DestructionSword\n' ,
'Hes / 1 / Desolator, Sentinel, Antara\n']);