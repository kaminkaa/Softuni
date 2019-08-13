function toggle() {
    let div = document.getElementById('extra');
    let button = document.querySelector('.button');

    if (button.textContent === 'More') {
        div.style.display = 'block';
        button.textContent = 'Less';
    } else if (button.textContent === 'Less') {
        div.style.display = 'none';
        button.textContent = 'More';
    }
}