function sumAndVat(nums) {
    let sum = 0;

    for (var i = 0; i < nums.length; i++) {
        sum += nums[i];
    }

    let vat = sum * 0.2;

    let total = vat + sum;

    console.log('sum = ' + sum);
    console.log('VAT = ' + vat);
    console.log('total = ' + total);
}

let input = [1.2, 2.6, 3.5];
sumAndVat(input);