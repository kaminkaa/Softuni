let solution = ( function () {
    let microelements = {protein: 0, carbohydrate: 0, fat: 0, flavour: 0};

    let inStock = function (element, quantity) {
        if (microelements[element] >= quantity) {
            microelements[element] -= quantity;
            return true;
        } else {
            return false;
        }
    };

    let operations = {
        restock: function (element, quantity) {
            // Достъпвай го така - microelements[element] а не със точка, защото го
            // достъпваш чрез стринг. Като го достъпваш със точка то буквално очаква да
            // има пропърти 'element'
            microelements[element] += quantity;
            return 'Success';
        },
        prepare: function (recipe,quantity) {
            let carbsQuantity, flavourQuantity, proteinQuantity, fatQuantity;
            switch (recipe) {
                case 'apple':
                    carbsQuantity = 1 * quantity;
                    if (!inStock('carbohydrate', carbsQuantity)) { return 'Error: not enough carbohydrate in stock'; }
                    flavourQuantity = 2 * quantity;
                    if (!inStock('flavour', flavourQuantity)) { return 'Error: not enough flavour in stock'; }
                    break;

                case 'coke':
                    carbsQuantity = 10 * quantity;
                    if (!inStock('carbohydrate', carbsQuantity)) { return 'Error: not enough carbohydrate in stock'; }
                    flavourQuantity = 20 * quantity;
                    if (!inStock('flavour', flavourQuantity)) { return 'Error: not enough flavour in stock'; }
                    break;

                case 'burger':
                    carbsQuantity = 5 * quantity;
                    if (!inStock('carbohydrate', carbsQuantity)) { return 'Error: not enough carbohydrate in stock'; }
                    fatQuantity = 7 * quantity;
                    if (!inStock('fat', fatQuantity)) { return 'Error: not enough fat in stock'; }
                    flavourQuantity = 3 * quantity;
                    if (!inStock('flavour', flavourQuantity)) { return 'Error: not enough flavour in stock'; }
                    break;

                case 'omelet':
                    proteinQuantity = 5 * quantity;
                    if (!inStock('protein', proteinQuantity)) { return 'Error: not enough protein in stock'; }
                    fatQuantity = 1 * quantity;
                    if (!inStock('fat', fatQuantity)) { return 'Error: not enough fat in stock'; }
                    flavourQuantity = 1 * quantity;
                    if (!inStock('flavour', flavourQuantity)) { return 'Error: not enough flavour in stock'; }
                    break;

                case 'cheverme':
                    proteinQuantity = 10 * quantity;
                    if (!inStock('protein', proteinQuantity)) { return 'Error: not enough protein in stock'; }
                    carbsQuantity = 10 * quantity;
                    if (!inStock('carbohydrate', carbsQuantity)) { return 'Error: not enough carbohydrate in stock'; }
                    fatQuantity = 10 * quantity;
                    if (!inStock('fat', fatQuantity)) { return 'Error: not enough fat in stock'; }
                    flavourQuantity = 10 * quantity;
                    if (!inStock('flavour', flavourQuantity)) { return 'Error: not enough flavour in stock'; }
                    break;
            }
            return 'Success';
        },
        report: function () {
            return 'protein=' + microelements.protein + ' carbohydrate=' + microelements.carbohydrate
            + ' fat=' + microelements.fat + ' flavour=' + microelements.flavour;
        }
    };

    function solution (command) {
        let [operation, arg1, arg2] = command.split(' ');
        if (operation === 'restock') { return operations.restock(arg1, Number(arg2))}
        if (operation === 'prepare') { return operations.prepare(arg1, Number(arg2))}
        if (operation === 'report') { return operations.report()}
    }
    return solution;
})();

let manager = solution;
console.log(manager("restock carbohydrate 10"));
console.log(manager("restock flavour 50"));
console.log(manager("prepare coke 4"));
console.log(manager("restock fat 10"));
console.log(manager("prepare burger 1"));
console.log(manager("report"));