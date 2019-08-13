function KeyValue(args) {
    let dict = new Map();
    for (let i = 0; i < args.length - 1; i++) {
        let input = args[i].split(' ');
        dict.set(input[0],input[1]);
    }

    let value = dict.get(args[args.length-1]);
    if (value !== undefined) {
        console.log(value);
    } else {
        console.log('None');
    }
}

var dict = ['key value', 'key eulav', 'test read','key'];

KeyValue(dict);