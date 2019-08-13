function solve(name, age, weight, height) {
    let info = {
        age: age,
        weight: weight,
        height: height
    };

    let bmi = weight / (Math.pow(height/100,2));
    let status = getStatus(bmi);

    function getStatus (bmi) {
        if (bmi < 18.5) { return 'underweight'}
        if (bmi >= 18.5 && bmi < 25) { return 'normal'}
        if (bmi >= 25 && bmi < 30) { return 'overweight'}
        if (bmi >= 30) { return 'obese'}
    }

    let patient = {
        name: name,
        personalInfo : info,
        BMI: Math.round(bmi),
        status: status,
    };

    if (status === 'obese') {
        patient['recommendation'] = 'admission required';
    }

    return patient;
}

console.log(solve('Peter', 29, 75, 182));
console.log(solve('Honey Boo Boo', 9, 57, 137));