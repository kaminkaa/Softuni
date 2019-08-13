function calculateDistanceBetweenTwoPoints(x1, y1, x2, y2) {
    let distance = Math.sqrt(Math.pow(Math.abs(y1 - y2),2) + Math.pow(Math.abs(x1 - x2),2));

    return distance;
}

console.log(calculateDistanceBetweenTwoPoints(2.34, 15.66, -13.55, -2.9985));