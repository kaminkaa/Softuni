function calculateTriangleArea(a, b, c) {
    let area = 0.25*Math.sqrt((a+b+c)*(-a+b+c)*(a-b+c)*(a+b-c));

    console.log(area);
}

calculateTriangleArea(2,3.5,4);