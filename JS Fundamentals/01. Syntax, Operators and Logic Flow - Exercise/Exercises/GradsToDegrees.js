function solve(grads) {
    let degrees = (0.9 * grads) % 360;

    if (degrees < 0 ) {
        degrees = 360 + degrees;
    }

    console.log(degrees);
}

solve(-50);