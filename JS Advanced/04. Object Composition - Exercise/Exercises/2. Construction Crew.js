function solve(obj) {
    if (obj.handsShaking) {
        obj.bloodAlcoholLevel += 0.1 * obj.weight * obj.experience;
        obj.handsShaking = false;
        return obj;
    } else {
        return obj;
    }
}

let obj = {weight: 80,
    experience: 1,
    bloodAlcoholLevel: 0,
    handsShaking: true
};

console.log(solve(obj));