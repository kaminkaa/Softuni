function solve(arrStr) {
    let goldPerDay = arrStr.map(x => Number(x));
    let bitcoins = 0, leva = 0, day, firstDay = 0;

    for (let i = 0; i < goldPerDay.length; i++) {
        day = i + 1;
        if (day%3 === 0) {
            leva += (goldPerDay[i] - goldPerDay[i]*0.3) * 67.51;
        } else {
            leva += goldPerDay[i] * 67.51;
        }

        while (leva >= 11949.16) {
            bitcoins += Math.floor(leva/11949.16);
            leva = leva%11949.16;
            if (firstDay === 0) {
                firstDay = day;
            }
        }
    }

    console.log('Bought bitcoins: ' + bitcoins);
    if (bitcoins !== 0) {
        console.log('Day of the first purchased bitcoin: ' + firstDay);
    }
    console.log('Left money: ' + leva.toFixed(2) + ' lv.');
}

solve(['100', '200', '300']);