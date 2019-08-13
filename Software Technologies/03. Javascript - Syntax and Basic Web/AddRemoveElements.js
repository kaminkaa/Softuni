function AddRemove(args) {
    let array = [];

    for (let i = 0; i < args.length; i++) {
        let input = args[i].split(' ');
        let command = input[0];
        let value = Number(input[1]);

        switch (command){
            case 'add':
                array.push(value);
                break;

            case 'remove':
                if (value >= 0 && value <= array.length-1) {
                    array.splice(value,1);
                }
                break;
        }
    }

    for (let i = 0; i < array.length; i++) {
        console.log(array[i]);
    }
}

let arr;
arr = ['add 3', 'add 5', 'add 7', 'remove 1'];
console.log(AddRemove(arr));