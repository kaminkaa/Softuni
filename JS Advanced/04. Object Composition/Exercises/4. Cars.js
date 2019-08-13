// closure:
// object inheritance:
// create, inherit and modify objects
// revealing module pattern:
function solve(commands) {
    let commandExecutor = (function() {
        let store = {};

        function create (arr) {
            if (arr.length > 2) {
                let name = arr[0];
                let parentName = arr[2];
                store[name] = Object.create(store[parentName]);
            } else {
                let name = arr[0];
                store[name] = {};
            }
        }

        function set (arr) {
            let name = arr[0];
            let key = arr[1];
            let value = arr[2];
            store[name][key] = value;
        }

        function print (arr) {
            let name = arr[0];
            let result = [];
            let obj = store[name];
            for (let key in obj) {
                result.push(key + ':' + obj[key]);
            }
            console.log(result.join(', '));
        }

        return {create, set, print};
    })();

    for (let command of commands) {
        let commandParameters = command.split(' ');
        let action = commandParameters.shift();
        commandExecutor[action](commandParameters);
    }
}

solve(['create c1',
    'create c2 inherit c1',
    'set c1 color red',
    'set c2 model new',
    'print c1',
    'print c2']
);