function printOneToN(num) {
    let n = Number(num);

    let output = '';

    for (let i = 1; i <= n; i++) {
        output = output + i;
    }

    console.log(output);
}

printOneToN(11);