function solve(commands) {
    let commandProcessor = (function () {
        let result = '';
        return {
            append: (newText) => result += newText,
            removeStart: (n) => result = result.slice(n),
            removeEnd: (n) => result = result.slice(0, result.length - n),
            print: () => console.log(result)
        }
    })();


    for (let cmd of commands) {
        let [command, arg] = cmd.split(' ');
        commandProcessor[command](arg);
    }
}

solve(['append 123', 'append 45', 'removeStart 2', 'removeEnd 1', 'print']); // 34
