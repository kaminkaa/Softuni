function solve(input) {

    let arr = [1];
        
    for (let i = 1; i <= input.length; i++) {
        switch (input[i]) {
            case 'add':
                arr.push(i+1);
                break;

            case 'remove':
                arr.pop();
                break;
        }
    }

    if (arr.length === 0) {
        console.log('Empty');
    } else {
        for (let element of arr) {
            console.log(element);
        }
    }
}

solve(['add', 'add', 'add', 'add']);