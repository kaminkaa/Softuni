// regex:
function solve(email) {
    let pattern = /^[a-zA-Z0-9]+@[a-z]+(\.[a-z]+)+$/g;
    // .test() returns true if the email matches the pattern
    let result = pattern.test(email);

    if (result) {
        console.log('Valid');
    } else {
        console.log('Invalid');
    }
}

solve('invalid@emai1.bg');