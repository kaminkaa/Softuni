function solve(input) {
    let n1 = input[0];
    let n2 = input[1];
    let n3 = input[2];

    console.log(Math.max(Math.max(n1,n2),n3));
}

solve([-10,-20,-30]);