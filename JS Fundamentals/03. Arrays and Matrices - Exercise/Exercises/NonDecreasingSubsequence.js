function solve(input) {
    let max = input[0];
    let i =1;
   while(i < input.length) {
        if (input[i] >= max) {
            max = input[i];
            i++;
        } else {
            input.splice(i,1);
        }
    }

    for (let number of input) {
        console.log(number);
    }
}

solve([1,3,8,4,10,12,3,12,24]);