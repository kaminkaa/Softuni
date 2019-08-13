// sorting:
// map:
// set:
function solve(arrStr) {
    let products = new Map();

    for (let current of arrStr) {
        let [name,price] = current.split(' : ');
        products.set(name,price);
    }

    let sortedProductsNames = Array.from(products.keys()).sort();
    let letters = new Set();
    sortedProductsNames.forEach(productName => letters.add(productName[0]));

    for (let letter of letters) {
        console.log(letter);
        for (let current of sortedProductsNames) {
            if (letter === current[0]) {
                console.log(' ' + current + ': ' + products.get(current));
            }
        }
    }
}

solve(['Appricot : 20.4' ,
'Fridge : 1500' ,
'TV : 1499' ,
'Deodorant : 10' ,
'Boiler : 300' ,
'Apple : 1.25' ,
'Anti-Bug Spray : 15' ,
'T-Shirt : 10']);