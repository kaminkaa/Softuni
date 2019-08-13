function PrintLines (args) {
    for (let i = 0; i < args.length; i++) {
        if(args[i] == 'Stop') {
            return
        } else {
            console.log(args[i])
        }
    }
}