// slicing arrays:
function firstLastKElements(arr) {
    // .shift() takes the element at index 0:
    let k = arr.shift();

    console.log(arr.slice(0, k).join(' '));
    console.log(arr.slice(arr.length-k,
        arr.length).join(' '));
}

firstLastKElements([2, 7, 8, 9]);