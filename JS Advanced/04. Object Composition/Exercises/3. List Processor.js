// closure:
// module patterns:
// module pattern:
function solve(input) {
    let processor = (function () {
        let collection = [];
        return {
            add: function (str) {
                collection.push(str);
            },
            remove: function (str) {
                collection = collection.filter(x => x !== str);
            },
            print: function () {
                console.log(collection.join(','));
            }
        }
    })();

    for (let current of input) {
        let [command,atr] = current.split(' ');
        processor[command](atr);
    }
}

solve(['add hello', 'add again', 'remove hello', 'add again', 'print']);