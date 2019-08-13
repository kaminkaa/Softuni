function solve(input) {
    let output = input[0];
    for (let i = 1; i < input.length - 1; i++) {
        output += input[input.length-1] + input[i];
    }
    console.log(output);
}

solve(['How about no?', 'I', 'will', 'not', 'do', 'it!', '_']);