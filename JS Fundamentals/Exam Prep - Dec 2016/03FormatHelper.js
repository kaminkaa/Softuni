// editing a string : izpolzvai regex i .replace()
function solve(str) {

    let string = str + '';

    console.log(string
        // Having a single space (" ") only after every one of those symbols: ".,!?:;" is obligatory.
        // Having one or more spaces (" ") before every one of those symbols: ".,!?:;" is forbidden.
        .replace(/[ ]*([.,!?:;])[ ]*/g, (match, g1) => `${g1} `)
        // If there is a dot (".") followed by spaces, then by any digit(s) this means that the text
        // might be a number or a date – make sure that there are no following spaces after the dot.
        .replace(/\. (?=[0-9])/g, (match) => `.`)
        // A text inside of quotes should be trimmed (e.g. " text "  "text")
        .replace(/" *(.+?) *"/g, (match, g1) => `"${g1}"`)
        // Sequences like ". . . !" should be displayed as "...!"
        .replace(/([.,!?:;]) (?=[.,!?:;])/g, (match, g1) => g1));
}

solve('Terribly;  formatted text      .  With chaotic spacings.\"  Terrible quoting \"!  Also this date is pretty,   confusing : 20  .  12. 16 .');