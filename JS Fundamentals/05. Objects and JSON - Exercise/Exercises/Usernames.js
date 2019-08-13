// sorting sets:
function solve(arrStr) {
    let usernames = new Set();

    for (let input of arrStr) {
        usernames.add(input);
    }

    // sort by length in ascending order, then by alphabetical order
    usernames = new Set([...usernames].sort((x,y) => {
        if ([...x].length === [...y].length) {
            if (x > y) {
                return 1
            }
            if (x < y) {
                return -1
            }
            return 0
        }

        return [...x].length < [...y].length ? -1 : 1;
    }));

    for (let username of usernames) {
        console.log(username);
    }
}

solve(['Ashton' ,
'Kutcher' ,
'Ariel' ,
'Lilly' ,
'Keyden' ,
'Aizen' ,
'Billy' ,
'Braston']);