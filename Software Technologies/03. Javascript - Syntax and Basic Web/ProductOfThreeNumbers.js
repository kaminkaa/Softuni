function isPositive(nums) {
    let countNegative = 0

    for (let i = 0; i < 3; i++) {
        if (Number(nums[i]) < 0) {
            countNegative ++;
        }
    }

    if (countNegative%2 === 0) {
        console.log('Positive')
    } else {
        console.log('Negative')
    }
}