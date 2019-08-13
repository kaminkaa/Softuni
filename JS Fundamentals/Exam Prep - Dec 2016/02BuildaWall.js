function solve(sections) {
    sections.map(h => Number(h));
    let concretePerDay = 0;
    let concrete = [];
    let wallFinished = false;

    while (!wallFinished) {
        concretePerDay = 0;
        for (let i = 0; i < sections.length; i++) {
            if (sections[i] < 30) {
                concretePerDay += 195;
                sections[i]++;
            }
        }

        if (concretePerDay > 0 ) {
            concrete.push(concretePerDay);
        } else {
            wallFinished = true;
        }
    }

    let totalConcrete = concrete.reduce((a,b) => a+b);
    let cost = totalConcrete * 1900;

    console.log(concrete.join(', '));
    console.log(cost + ' pesos');
}

solve([21, 25, 28]);
solve([17]);