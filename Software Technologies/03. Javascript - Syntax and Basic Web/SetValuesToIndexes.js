function SetValues(args) {
    var array = []
    let n = Number(args[0])

    for (let i = 0; i < n; i++) {
        array[i] = 0
    }

    for (let i = 1; i < args.length; i++) {
        let input = args[i].split(' - ').map(Number)
        array[input[0]] = input[1]
    }

    for (let i = 0; i < n; i++) {
        console.log(array[i])
    }
}