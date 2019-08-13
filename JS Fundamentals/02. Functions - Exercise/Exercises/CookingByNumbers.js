function solve(input) {

    let chop = function (number) { console.log(number / 2); return (number / 2);};
    let dice = function (number) { console.log(Math.sqrt(number)); return (Math.sqrt(number));};
    let spice = function (number) { console.log(number + 1); return (number + 1);};
    let bake = function (number) { console.log(number * 3); return (number * 3);};
    let fillet = function (number) { console.log(number - 0.2 * number); return (number - 0.2 * number);};

    let value = input[0];

    for (let i = 1; i < input.length; i++) {

        switch (input[i]) {
            case 'chop': value = chop(value);
            break;
            case 'dice': value = dice(value);
                break;
            case 'spice': value = spice(value);
                break;
            case 'bake': value = bake(value);
                break;
            case 'fillet': value = fillet(value);
                break;
        }
    }
}

solve([9,'dice','spice','chop','bake','fillet']);