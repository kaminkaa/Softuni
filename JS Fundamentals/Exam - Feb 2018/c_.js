function solve(text) {
    let surveyDataPattern = /<svg>[^]+<\/svg>/g;
    let surveyDataCheck = surveyDataPattern.exec(text);

    let surveyLabelPattern = /<cat><text>[^]*(\[([a-zA-Z]+ - [a-zA-Z]+)\])[^]*<\/text><\/cat>[\s\n]*<cat>(<g><val>(\d+)<\/val>(\d+)<\/g>)+<\/cat>/g;
    let raitingsRegex = /<g><val>(\d+)<\/val>(\d+)<\/g>/g;

    let valuesSum = 0;
    let valuesCount = 0;

    if (surveyDataCheck === null) {
        console.log('No survey found');
    } else {
        let surveyData = text.match(surveyLabelPattern)+'';
        let surveyLabelCheck = surveyLabelPattern.exec(surveyData);
        if (surveyLabelCheck === null) {
            console.log('Invalid format');
        } else {
            let surveyLabel = surveyLabelCheck[2];
            let raitings = raitingsRegex.exec(surveyData);
            while (raitings) {
                if(raitings[1] >= 1 && raitings[1] <= 10 && raitings[2] >= 0) {
                    valuesSum += Number(raitings[1]) * Number(raitings[2]);
                    valuesCount += Number(raitings[2]);
                }
                raitings = raitingsRegex.exec(surveyData);
            }
            console.log(surveyLabel + ': ' + parseFloat((valuesSum/valuesCount).toFixed(2)));
        }
    }
}

/*
solve('<p>Some random text</p><svg><cat><text>How do you rate our food? [Food - General]</text></cat><cat><g><val>1</val>0</g><g><val>\n' +
    '\n' +
    '2</val>1</g><g><val>3</val>3</g><g><val>4</val>10</g><g><val>5</val>7</g></cat></svg><p>Some more random text</p>')*/


solve('<p>How do you suggest we improve our service?</p><p>More tacos.</p><p>It\'s great, don\'t mess with it!</p><p>I\'d like to have the option for delivery</p>')

solve('<p>Some random text</p><svg><cat><text>How do you rate our food? [Food - General]</text></cat><cat><g><val>1</val>0</g><g><val>2</val>1</g><g><val>3</val>3</g><g><val>4</val>10</g><g><val>5</val>7</g></cat></svg><p>Some more random text</p>')

solve('<svg><cat><text>Which is your favourite meal from our selection?</text></cat><cat><g><val>Fish</val>15</g><g><val>Prawns</val>31</g><g><val>Crab Langoon</val>12</g><g><val>Calamari</val>17</g></cat></svg>')