function attachEvents() {
    $('#location').val('New York');
    $('#submit').on('click', getWeather);

    function getWeather() {
        let url = 'https://judgetests.firebaseio.com/locations.json';
        $.get(url)
            .then(getForecast)
            .catch(displayError);
    }

    function displayError(error) {
        console.log(error);
    }

    function getForecast(locations) {
        let location = locations.find(l => l.name === $('#location').val());
        let urlCurrCond = `https://judgetests.firebaseio.com/forecast/today/${location.code}.json`;
        let url3DayForecast = `https://judgetests.firebaseio.com/forecast/upcoming/${location.code}.json`;
        
        let forecastToday = {};
        
        $.get(urlCurrCond)
            .then((obj) => {
                forecastToday['city'] = obj.name;
                forecastToday['condition'] = obj.forecast.condition;
                forecastToday['high'] = obj.forecast.high;
                forecastToday['low'] = obj.forecast.low;
                displayTodayForecast(forecastToday);
            })
            .catch(displayError);
        
        $.get(url3DayForecast)
            .then((obj) => displayUpcomingForecast(obj.forecast))
            .catch(displayError);

        $('#forecast').css('display', 'block');
    }

    function displayTodayForecast(data) {
       $('#current')
           .append($(`<span class="condition symbol">${getSymbol(data.condition)}</span>`))
           .append($('<span class="condition">')
               .append($(`<span class="forecast-data">${data.city}</span>`))
               .append($(`<span class="forecast-data">${data.low}&#176;/${data.high}&#176;</span>`))
               .append($(`<span class="forecast-data">${data.condition}</span>`)));
    }

    function displayUpcomingForecast(data) {
        for (let curr of data) {
            $('#upcoming')
                .append($('<span class="upcoming">')
                    .append($(`<span class="symbol">${getSymbol(curr.condition)}</span>`))
                    .append($(`<span class="forecast-data">${curr.low}&#176;/${curr.high}&#176;</span>`))
                    .append($(`<span class="forecast-data">${curr.condition}</span>`)));
        }
    }

    function getSymbol(condition) {
        let symbol = '';

        switch (condition) {
            case 'Sunny': symbol = '&#x1f31e;';
                break;
            case 'Partly sunny': symbol = '&#x26C5;';
                break;
            case 'Overcast': symbol = '&#x2601;';
                break;
            case 'Rain': symbol = '&#x2614;';
                break;
        }

        return symbol;
    }
}