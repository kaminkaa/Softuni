function timer() {
    let timerInt;
    let startBtn = $('#start-timer');
    let stopBtn = $('#stop-timer');

    startBtn.on('click', function() {
        clearInterval(timerInt);
        startBtn.attr('disabled', true);
        timerInt = setInterval(step, 1000);
    });

    stopBtn.on('click', function() {
        clearInterval(timerInt);
        startBtn.attr('disabled', false);
    });

    function step() {
        let seconds = Number($('#seconds').text());
        let minutes = Number($('#minutes').text());
        let hours = Number($('#hours').text());

        if (seconds < 60) {
            seconds++;
            $('#seconds').text(('0' + seconds).toString().slice(-2));
        }

        if (seconds >= 60) {
            minutes++;
            seconds = 0;
            $('#seconds').text(('0' + seconds).toString().slice(-2));
            $('#minutes').text(('0' + minutes).toString().slice(-2));
        }

        if (minutes >= 60) {
            minutes = 0;
            seconds = 0;
            hours++;
            $('#seconds').text(('0' + seconds).toString().slice(-2));
            $('#minutes').text(('0' + minutes).toString().slice(-2));
            $('#hours').text(('0' + hours).toString().slice(-2));
        }
    }
}
