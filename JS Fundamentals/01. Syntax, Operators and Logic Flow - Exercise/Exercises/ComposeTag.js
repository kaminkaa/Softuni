function solve(input) {
    let fileLocation = input[0];
    let alternateText = input[1];

    console.log('<img src=\"' + fileLocation + '\" alt=\"' + alternateText + '\">');
}

solve(['smiley.gif', 'Smiley Face']);