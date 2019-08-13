// associative arrays:
// maps:
function solve(arrStr) {
    let bottlesStock = new Map();
    let storage = {};

    for (let current of arrStr) {
        let [juiceName,quantity] = current.split(' => ');
        let juiceQuantity = Number(quantity);

        if (juiceQuantity < 1000) {
            if (!storage.hasOwnProperty(juiceName)) {
                storage[juiceName] = juiceQuantity;
            } else {
                storage[juiceName] = storage[juiceName] + juiceQuantity;
                if (storage[juiceName] >= 1000) {
                    if (!bottlesStock.has(juiceName)) {
                        bottlesStock.set(juiceName, Math.floor(storage[juiceName] / 1000));
                    } else {
                        let oldBottlesQuantity = bottlesStock.get(juiceName);
                        bottlesStock.set(juiceName, oldBottlesQuantity + Math.floor(storage[juiceName] / 1000));
                    }
                    storage[juiceName] = storage[juiceName]%1000;
                }
            }
        } else {
            if (!bottlesStock.has(juiceName)) {
                bottlesStock.set(juiceName, Math.floor(juiceQuantity / 1000));
            } else {
                let oldBottlesQuantity = bottlesStock.get(juiceName);
                bottlesStock.set(juiceName, oldBottlesQuantity + Math.floor(juiceQuantity / 1000));
            }

            if (!storage.hasOwnProperty(juiceName)) {
                storage[juiceName] = juiceQuantity%1000;
            } else {
                storage[juiceName] = storage[juiceName] + juiceQuantity%1000;
                if (storage[juiceName] >= 1000) {
                    if (!bottlesStock.has(juiceName)) {
                        bottlesStock.set(juiceName, Math.floor(storage[juiceName] / 1000));
                    } else {
                        let oldBottlesQuantity = bottlesStock.get(juiceName);
                        bottlesStock.set(juiceName, oldBottlesQuantity + Math.floor(storage[juiceName] / 1000));
                    }
                    storage[juiceName] = storage[juiceName]%1000;
                }
            }
        }
    }

    for (let [key, value] of bottlesStock) {
        console.log(key + ' => ' + value);
    }
}

solve(['Kiwi => 234' ,
'Pear => 2345' ,
'Watermelon => 3456' ,
'Kiwi => 4567' ,
'Pear => 5678' ,
'Watermelon => 6789']);