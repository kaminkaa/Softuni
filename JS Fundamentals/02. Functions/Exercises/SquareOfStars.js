// functions with default parameter values:
function squareOfStars(n) {

    function printStars(count = n) {
        console.log("*" + " *".repeat(count-1));
    }

    // how many times to print the line of stars:
    for (let i=1; i<=n; i++) {
        printStars();
    }
}

squareOfStars(10);