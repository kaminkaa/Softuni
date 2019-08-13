function calculateDateOfNextDay(year, month, day) {
    let date = new Date(year, month-1, day);

    let oneDayMillisec = 24 * 60 * 60 * 1000;

    let nextDate = new Date(date.getTime() + oneDayMillisec);

    return nextDate.getFullYear() + '-' + (nextDate.getMonth()+1) + '-' + nextDate.getDate();
}

console.log(calculateDateOfNextDay(2016,9,30));