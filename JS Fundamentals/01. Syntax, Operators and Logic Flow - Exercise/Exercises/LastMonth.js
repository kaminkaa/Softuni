function solve(input) {
    let month = input[1];
    let year = input[2];

    let prevMonth = (month-1 === 0) ? 12 : month-1;

    switch (prevMonth) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            console.log(31);
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            console.log(30);
            break;
        case 2:
            let leap = (year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0);
            console.log(leap ? 29 : 28);
    }
}

solve([13, 12, 2004]);