function KeyValue(args) {
    let dict = new Map();
    for (let i = 0; i < args.length - 1; i++) {
        let input = args[i].split(' ');
        if (dict.get(input[0]) === undefined) {
            dict.set(input[0], []);
        }
        dict.get(input[0]).push(input[1]);
    }

    let key = args[args.length-1];
    if (dict.get(key) !== undefined) {
        for (let value of dict.get(key))
        console.log(value);
    } else {
        console.log('None');
    }
}

var dict = ['key value', 'key eulav', 'test read','key'];

KeyValue(dict);