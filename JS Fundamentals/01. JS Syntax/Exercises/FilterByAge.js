function filterByAge(minAge, name1, age1, name2, age2) {
    if (age1 >= minAge && age2 >= minAge){
        if (age1 > age2) {
            console.log('{ name: \'' + name1 + '\', age: ' + age1 + ' }');
            console.log('{ name: \'' + name2 + '\', age: ' + age2 + ' }');
        } else {
            console.log('{ name: \'' + name2 + '\', age: ' + age2 + ' }');
            console.log('{ name: \'' + name1 + '\', age: ' + age1 + ' }');
        }
    } else if (age1 >= minAge) {
        console.log('{ name: \'' + name1 + '\', age: ' + age1 + ' }');
    } else if (age2 >= minAge) {
        console.log('{ name: \'' + name2 + '\', age: ' + age2 + ' }');
    }
}

filterByAge(12, 'Ivan', 15, 'Asen', 9);