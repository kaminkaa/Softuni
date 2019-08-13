function StoreObjects(input) {
    let students = [];

    for (let line of input) {
        let tokens = line.split(' -> ');

        let name = tokens[0];
        let age = Number(tokens[1]);
        let grade = Number(tokens[2]).toFixed(2);

        let student = { name: name,
                        age: age,
                        grade: grade};

        students.push(student);
    }

    for (let student of students){
        console.log('Name: ' + student.name);
        console.log('Age: ' + student.age);
        console.log('Grade: ' + student.grade);
    }
}

let input = ["Pesho -> 13 -> 6.00", "Ivan -> 12 -> 5.57", "Toni -> 13 -> 4.90"];
StoreObjects(input);