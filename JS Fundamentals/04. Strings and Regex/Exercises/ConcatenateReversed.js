function solve(arrStr) {
    let allStrings = arrStr.join('');
    let chars = Array.from(allStrings);
    let revChars = chars.reverse();
    let revStr = revChars.join('');
    console.log(revStr);
}

solve(['I', 'am', 'student']);