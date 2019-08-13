// nested maps:
function solve(arrStr) {
    let ProductsWithPricesPerCity = new Map();

    for (let currentLine of arrStr) {
        let [town,product,price] = currentLine
            .split('|')
            .filter(x => x !== '')
            .map(x => x.trim());

        price = Number(price);

        if (!ProductsWithPricesPerCity.has(product)) {
            ProductsWithPricesPerCity.set(product, new Map());
        }

        ProductsWithPricesPerCity.get(product).set(town,price);
    }

    for (let [name, towns] of ProductsWithPricesPerCity) {
        let result = name + ' -> ';
        let townName = '';
        let lowestPrice = +Infinity;
        for (let [town, price] of towns) {
            if (price < lowestPrice){
                lowestPrice = price;
                townName = town;
            }
        }
        result += lowestPrice.toString() + ` (${townName})`;
        console.log(result);
    }

 /*   let output = '';
    let townName = '';
    let lowestPrice = +Infinity;
    for (let [product, townsPrices] of ProductsWithPricesPerCity) {
        output += product + ' -> ';
        for (let [town, price] of townsPrices) {
            if (price < lowestPrice) {
                lowestPrice = price;
                townName = town;
            }
        }
        output += lowestPrice + ' (' + townName + ')\n';
    }

    console.log(output);*/
}

solve(['Sample Town | Sample Product | 1000',
'Sample Town | Orange | 2',
'Sample Town | Peach | 1',
'Sofia | Orange | 3',
'Sofia | Peach | 2',
'New York | Sample Product | 1000.1',
'New York | Burger | 10']);