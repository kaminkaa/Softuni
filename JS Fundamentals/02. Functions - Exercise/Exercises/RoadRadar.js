function solve(input) {
    let speed = input[0];
    let zone = input[1];

    let limit = getLimit(zone);
    console.log(getInfraction(speed,limit));

    function getLimit(zone) {
        switch (zone) {
            case 'motorway': return 130;
            case 'interstate': return 90;
            case 'city': return 50;
            case 'residential': return 20;
        }
    }

    function getInfraction(speed, limit) {
        if (speed > limit) {
            let infraction = speed - limit;
            if (infraction <= 20) { return 'speeding';}
            if (infraction > 20 && infraction <= 40) { return 'excessive speeding';}
            if (infraction > 40) {return 'reckless driving';}
        } else {
            return '';
        }
    }
}

solve([200, 'motorway']);