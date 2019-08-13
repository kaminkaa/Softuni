function attachGradientEvents() {
    let gradient = document.getElementById('gradient-box');

    gradient.addEventListener('mousemove', function (event) {
        let result = event.offsetX / (event.target.clientWidth - 1);
        result = Math.trunc(result * 100);
        document.getElementById('result').textContent = result + '%';
    });

    gradient.addEventListener('mouseleave', function (event) {
        document.getElementById('result').textContent = '';
    });
}
