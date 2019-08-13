function attachEventsListeners() {
    // TODO: attach click events to all buttons

    let daysBtn = document.getElementById('daysBtn');
    let hoursBtn = document.getElementById('hoursBtn');
    let minutesBtn = document.getElementById('minutesBtn');
    let secondsBtn = document.getElementById('secondsBtn');

    daysBtn.addEventListener('click', function () {
        let days = Number(document.getElementById('days').value);
        document.getElementById('hours').value = days * 24;
        document.getElementById('minutes').value = days*24*60;
        document.getElementById('seconds').value = days*24*60*60;
    });

    hoursBtn.addEventListener('click', function () {
        let hours = Number(document.getElementById('hours').value);
        document.getElementById('days').value = hours / 24;
        document.getElementById('minutes').value = hours*60;
        document.getElementById('seconds').value = hours*60*60;
    });

    minutesBtn.addEventListener('click', function () {
        let minutes = Number(document.getElementById('minutes').value);
        document.getElementById('days').value = (minutes/60) / 24;
        document.getElementById('hours').value = minutes/60;
        document.getElementById('seconds').value = minutes*60;
    });

    secondsBtn.addEventListener('click', function () {
        let seconds = Number(document.getElementById('seconds').value);
        document.getElementById('hours').value = seconds / 60 / 60;
        document.getElementById('minutes').value = seconds / 60;
        document.getElementById('days').value = seconds / 60 / 60 / 24;
    });
}
