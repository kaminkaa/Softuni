// associative arrays
function solve(arrStr) {

    let result = {};

    for (let i = 0; i < arrStr.length; i+=2) {

        let [town,income] = [arrStr[i], Number(arrStr[i+1])];

        if (result[town] === undefined) {
            result[town] = income;
        } else {
            result[town] += income;
        }
    }

    return JSON.stringify(result);
}

console.log(solve(['Sofia','20', 'Varna','10', 'Sofia','5']));
