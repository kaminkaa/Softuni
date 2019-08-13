function ParseJSON(input) {
    let objects = [];

    for (let line of input) {
        let object = JSON.parse(line);
        objects.push(object);
    }

    for (let object of objects) {
        console.log('Name:', object.name);
        console.log('Age:', object.age);
        console.log('Date:', object.date);
    }
}

let input = ["{\"name\":\"Gosho\",\"age\":10,\"date\":\"19/06/2005\"}",
    "{\"name\":\"Tosho\",\"age\":11,\"date\":\"04/04/2005\"}"];
ParseJSON(input);