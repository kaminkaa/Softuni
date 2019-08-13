function solve(arrStr) {
    let sum = 0, list = [];
    for (let line of arrStr) {
        // split vzima ot lqvo i ot dqsno na |
        let townData = line.split('|');
        let townName = townData[1].trim();
        let income = Number(townData[2].trim());

        list.push(townName);
        sum += income;
    }

    console.log(list.join(', '));
    console.log(sum);
}

solve([ 'k | Sofia           | 300',
        '| Veliko Tarnovo  | 500',
        '| Yambol          | 275']
);