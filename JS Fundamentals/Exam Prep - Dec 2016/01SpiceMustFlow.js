function solve(source) {
    let yieldSize = Number(source);
    let spice = 0;
    let daysOfOperation = 0;

    while (yieldSize >= 100) {
        spice += yieldSize;
        yieldSize -= 10;
        spice -= 26;
        daysOfOperation ++;
    }

    if (spice >= 26) {
        spice -= 26;
    }

    console.log(daysOfOperation);
    console.log(spice);

}

solve(450);