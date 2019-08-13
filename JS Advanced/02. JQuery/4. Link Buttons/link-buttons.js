function attachEvents() {
    // vsichkite a-ta s class button:
    $('a.button').on('click', buttonClicked);

    function buttonClicked() {
        // vsichki koito imat class selected da im se mahne:
        $('.selected').removeClass('selected');
        // da se sloji class selected samo na clicknatoto:
        $(this).addClass('selected');
    }
}
