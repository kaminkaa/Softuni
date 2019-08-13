// ako logikata e vqrna no testovete ne minavat, da se proveri vseki vid input za prazen string, za prazen array, za number
// kogato se raboti s array-a predi vsqka operazia da se proverqva dali ima neshto v array-a, dali ima dostatuchno neshta v nego,
// da se proverqvat indexite
function solve(meals, commands) {
    let mealsEaten = 0;
    for (let command of commands) {
        let action = command.split(' ')[0].toLowerCase();
        switch (action) {
            case 'serve':
                if (meals.length > 0) {
                    let lastPortion = meals[meals.length - 1];
                    console.log(lastPortion + ' served!');
                    meals.pop();
                }
                break;

            case 'eat':
                if (meals.length >= 1) {
                    let firstPortion = meals[0];
                    console.log(firstPortion + ' eaten');
                    meals.shift();
                    mealsEaten++;
                }
                break;

            case 'add':
                let portion = command.split(' ')[1];
                if (portion !== undefined)
                meals.unshift(portion);
                break;

            case 'consume':
                let startindex = Number(command.split(' ')[1]);
                let endindex = Number(command.split(' ')[2]);
                let mealsCount = endindex - startindex + 1;
                if (startindex >= 0 && startindex <= meals.length-1 && endindex >= 0 && endindex <= meals.length-1) {
                    meals.splice(startindex,mealsCount);
                    console.log('Burp!');
                    mealsEaten += mealsCount;
                }
                break;

            case 'shift':
                let index1 = Number(command.split(' ')[1]);
                let index2 = Number(command.split(' ')[2]);
                if (index1 >= 0 && index1 <= meals.length-1 && index2 >= 0 && index2 <= meals.length-1) {
                    let reminder = meals[index1];
                    meals[index1] = meals[index2];
                    meals[index2] = reminder;
                }
                break;

            case 'end':
                console.log(meals.length === 0 ? 'The food is gone' : 'Meals left: ' + meals.join(', '));
                console.log('Meals eaten: ' + mealsEaten);
                return;

            default:
                break;
        }
    }

    console.log(meals.length === 0 ? 'The food is gone' : 'Meals left: ' + meals.join(', '));
    console.log('Meals eaten: ' + mealsEaten);
}

/*solve(['chicken', 'steak', 'eggs'],
    ['Serve',
        'Eat',
        'End',
        'Consume 0 1']);*/

/*solve(['fries', 'fish', 'beer', 'chicken', 'beer', 'eggs'],
    ['Add spaghetti',
        'Shift 0 1',
        'Consume 1 4',
        'End']);*/

solve(['bacon', 'veggies', 'chicken'],
['Add',
'End']);