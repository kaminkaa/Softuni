function solution(input) {
    let x1 = input[0];
    let y1 = input[1];
    let x2 = input[2];
    let y2 = input[3];
    let x3 = input[4];
    let y3 = input[5];

    let distance1to2 = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    let distance1to3 = Math.sqrt(Math.pow(x3-x1, 2) + Math.pow(y3-y1, 2));
    let distance2to3 = Math.sqrt(Math.pow(x3-x2, 2) + Math.pow(y3-y2, 2));

    let distance123 = distance1to2 + distance2to3;
    let distance132 = distance1to3 + distance2to3;
    let distance213 = distance1to3 + distance1to2;

    let shortestSegments = Math.min(distance123,Math.min(distance132, distance213));

    if (shortestSegments === distance123) {
        console.log('1->2->3: ' + distance123);
    } else if (shortestSegments === distance132) {
        console.log('1->3->2: ' + distance132);
    } else  if (shortestSegments === distance213) {
        console.log('2->1->3: ' + distance213);
    }
}

solution([-1, -2, 3.5, 0, 0, 2]);