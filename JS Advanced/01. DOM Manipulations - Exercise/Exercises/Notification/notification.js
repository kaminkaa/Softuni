// If you want a function to execute 1 time then use .setTimeout(),
// if you want to execute a function unlimited times then use .setInterval().
function notify(message) {
    let div = document.getElementById('notification');
    div.textContent = message;
    div.style.display = 'block';
    setTimeout(hideMessage, 2000);

    function hideMessage() {
      div.style.display = 'none';
    }
}