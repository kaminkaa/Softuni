// nested maps:
function solve(arrStr) {
    let brandsWithModels = new Map();

    for (let current of arrStr) {
        let [brand,model,cars] = current.split(' | ');

        if (!brandsWithModels.has(brand)){
            brandsWithModels.set(brand, new Map());
        }

        let quantityCars = Number(cars);
        let oldQuantityCars = brandsWithModels.get(brand).get(model);
        if (oldQuantityCars) quantityCars += oldQuantityCars;

        brandsWithModels.get(brand).set(model,quantityCars);
    }

    for (let [key,value] of brandsWithModels) {
        console.log(key);
        for (let [key2,value2] of value) {
            console.log('###' + key2 + ' -> ' + value2);
        }
    }
}

solve(['Audi | Q7 | 1000' ,
'Audi | Q6 | 100' ,
'BMW | X5 | 1000' ,
'BMW | X6 | 100' ,
'Citroen | C4 | 123' ,
'Volga | GAZ-24 | 1000000' ,
'Lada | Niva | 1000000' ,
'Lada | Jigula | 1000000' ,
'Citroen | C4 | 22' ,
'Citroen | C5 | 10']);