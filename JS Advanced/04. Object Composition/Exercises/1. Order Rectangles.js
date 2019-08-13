// object composition:
function solve(input) {
    let rectangles = [];

    function createRectangle(width, height) {
        let rectangle = {
            width: width,
            height: height,
            area: () => rectangle.width * rectangle.height,
            compareTo: function(other) {
                // sorted by their area in descending order as a first criteria
                // and by their width in descending order as a second criteria
                let result = other.area() - rectangle.area();
                return result || (other.width - rectangle.width);
            }
        };
        return rectangle;
    }

    for (let current of input) {
        rectangles.push(createRectangle(current[0],current[1]));
    }

    rectangles.sort((a,b) => a.compareTo(b)).forEach(r => console.log(r));

    // The output must consist the array of rectangles !!!!!
    return rectangles;
}

solve([[10,5],[5,12]]);