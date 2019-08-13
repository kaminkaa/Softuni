// namespace:
let solution = {
    add: function (vec1, vec2) {
        let result = [];
        result[0] = vec1[0] + vec2[0];
        result[1] = vec1[1] + vec2[1];
        return(result);
    },
    multiply: function (vec1, scalar) {
        let result = [];
        result[0] = vec1[0] * scalar;
        result[1] = vec1[1] * scalar;
        return(result);
    },
    length: function (vec1) {
        return(Math.sqrt(Math.pow(vec1[0], 2) + Math.pow(vec1[1], 2)));
    },
    dot: function (vec1, vec2) {
        return(vec1[0]*vec2[0] + vec1[1]*vec2[1]);
    },
    cross: function (vec1, vec2) {
        return(vec1[0]*vec2[1] - vec1[1]*vec2[0]);
    }
};

console.log(solution.add([1, 1], [1, 0]));
console.log(solution.multiply([3.5, -2], 2));
console.log(solution.length([3, -4]));
console.log(solution.dot([1, 0], [0, -1]));
console.log(solution.cross([3, 7], [1, 0]));