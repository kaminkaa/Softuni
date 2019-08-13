// regex:
function solve(arrStr) {
    // (1) - (2) - (3)
    // (only English alphabet letters and must start with a capital)
    // (a VALID number)
    // (English alphabet letters, digits, dashes, and can consist of several words)
    let regex = /^([A-Z][a-zA-Z]*) - ([1-9][0-9]*) - ([a-zA-Z0-9 -]+)$/;

    for (let current of arrStr) {
        let match = regex.exec(current);
        if (match) {
            console.log(`Name: ${match[1]}`);
            console.log(`Position: ${match[3]}`);
            console.log(`Salary: ${match[2]}`);
        }
    }
}

solve([ 'Isacc - 1000 - CEO',
        'Ivan - 500 - Employee',
        'Peter - 500 - Employee']);