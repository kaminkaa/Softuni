function oddEven(num) {
    let rem = num % 2;
    let remRounded = Math.round(rem);

    if (rem === 0) {
        console.log("even");
    }
    else if (rem === remRounded) {
        console.log("odd");
    }
    else {
        console.log("invalid");
    }
}

oddEven(3);