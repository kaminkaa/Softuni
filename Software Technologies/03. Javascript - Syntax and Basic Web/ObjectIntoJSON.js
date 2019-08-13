function ObjectIntoJSON(input) {
    let object = {};

    for (let line of input) {
        let tokens = line.split(' -> ');
        let key = tokens[0];
        let value = tokens[1];

        if(Number(value) == value) {
            value = Number(value);
        }

        object[key] = value;
    }

    console.log(JSON.stringify(object));
}

let input = ["name -> Angel", "surname -> Georgiev", "age -> 20", "grade -> 6.00",
    "date -> 23/05/1995", "town -> Sofia"];
ObjectIntoJSON(input);