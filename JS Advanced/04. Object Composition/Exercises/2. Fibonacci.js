// closure:
function solve() {
    let first =0;
    let second = 1;
    return function () {
        let next = first + second;
        first = second;
        second = next;
        return first;
    };
}

let fibonacci = solve();
console.log(fibonacci());
console.log(fibonacci());
console.log(fibonacci());
console.log(fibonacci());
console.log(fibonacci());