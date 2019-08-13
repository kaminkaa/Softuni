function solve(input) {
    let arr = input.slice(0,input.length-1);
    let rotations = (Number(input[input.length-1])) % arr.length;

    for (let i = 0; i < rotations; i++) {
        // store last element:
        let reminder = arr[arr.length-1];
        // shift all elements one position ahead:
        for (let j = arr.length-1; j > 0; j--) {
            arr[j] = arr[j-1];
        }
        // replace first element with reminder:
        arr[0] = reminder;
    }

    console.log(arr.join(' '));
}

solve([1,2,3,4,2]);
solve(['Banana','Orange','Coconut','Apple',15]);
