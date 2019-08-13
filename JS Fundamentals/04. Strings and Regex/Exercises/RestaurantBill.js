function solve(arrStr) {
    // getting the list of items:
    let items = arrStr.filter((value, index) => index%2 === 0);
    // summing up the prices:
    let sum = arrStr.filter((value, index) => index%2 === 1)
        .map(Number)
        .reduce((a,b) => a + b);

    console.log(`You purchased ${items.join(', ')} for a total sum of ${sum}`);
}

solve(['Beer Zagorka', '2.65', 'Tripe soup', '7.80','Lasagna', '5.69']);