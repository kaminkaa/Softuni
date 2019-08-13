function calculateFigureArea(w, h, W, H) {
    let Area = W * H;
    let area = w * h;
    let commonArea = Math.min(w,W) * Math.min(h,H);

    let figureArea = Area + area - commonArea;

    return figureArea;
}

console.log(calculateFigureArea(13, 2, 5, 8));