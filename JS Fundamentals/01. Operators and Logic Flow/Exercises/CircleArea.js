function calculateCircleArea(r) {
    let area = Math.PI * r * r;

    console.log(area);

    // rounded to two decimal places
    console.log(Math.round(area*100)/100);
}

calculateCircleArea(5);