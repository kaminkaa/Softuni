function MultiplyDivide(nums) {
    let n = Number(nums[0])
    let x = Number(nums[1])

    if (x < n) {
        return n / x;
    } else if (x >= n) {
        return n * x;
    }
}