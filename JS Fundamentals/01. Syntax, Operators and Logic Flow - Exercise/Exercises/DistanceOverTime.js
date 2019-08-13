function solve(input) {
    let v1kmh = input[0];
    let v2kmh = input[1];
    let tsec = input[2];

    let v1ms = v1kmh / 3.6;
    let v2ms = v2kmh / 3.6;

    let s1meters = v1ms * tsec;
    let s2meters = v2ms * tsec;

    console.log(Math.abs(s1meters-s2meters));
}

solve(5, -5, 40);