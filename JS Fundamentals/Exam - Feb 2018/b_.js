function solve(mapSofia, forces) {
    // create map:
    let map = [
        [0,0,0,0,0],
        [0,0,0,0,0],
        [0,0,0,0,0],
        [0,0,0,0,0],
        [0,0,0,0,0]
    ];

    // fill-in map:
    for (let r = 0; r < 5; r++) {
        let numbers = mapSofia[r].split(' ').map(x => Number(x));
        for (let c = 0; c < 5; c++) {
            map[r][c] = numbers[c];
        }
    }

    // do modifications on map:
    for (let force of forces) {
        let tokens = force.split(' ');
        let forceName = tokens[0].toLowerCase();
        let indexValue = Number(tokens[1]);

        switch (forceName) {
            case 'breeze':
                for (let c = 0; c < 5; c++) {
                    map[indexValue][c] -= 15;
                    if (map[indexValue][c] < 0) { map[indexValue][c] = 0; }
                }
                break;
            case 'gale':
                for (let r = 0; r < 5; r++) {
                    map[r][indexValue] -= 20;
                    if (map[r][indexValue] < 0) { map[r][indexValue] = 0; }
                }
                break;
            case 'smog':
                for (let r = 0; r < 5; r++) {
                    for (let c = 0; c < 5; c++) {
                        map[r][c] += indexValue;
                    }
                }
                break;
            default:
                break;

        }
    }

    // show the result:
    let thereArePollutedAreas = false;
    let result = [];
    for (let r = 0; r < 5; r++) {
        for (let c = 0; c < 5; c++) {
            if (map[r][c] >= 50) {
                let pollutedBlock = '[' + r + '-' + c + ']';
                result.push(pollutedBlock);
                thereArePollutedAreas = true;
            }
        }
    }

    if (thereArePollutedAreas) {
        console.log('Polluted areas: ' + result.join(', '));
    } else {
        console.log('No polluted areas');
    }
}

/*solve([
        "5 7 72 14 4",
        "41 35 37 27 33",
        "23 16 27 42 12",
        "2 20 28 39 14",
        "16 34 31 10 24",
    ],
    ["breeze 1", "gale 2", "smog 25"]);*/

solve([
        "5 7 3 28 32",
        "41 12 49 30 33",
        "3 16 20 42 12",
        "2 20 10 39 14",
        "7 34 4 27 24",
    ],
    ["smog 11", "gale 3", "breeze 1", "smog 2"]);