function attachEvents() {
    $('#btnLoad').on('click', loadPhonenumbers);
    $('#btnCreate').on('click', createPhonenumberEntry);

    let url = 'https://phonebook-nakov.firebaseio.com/phonebook';

    function loadPhonenumbers() {
        $('#phonebook').empty();
        $.get(url + '.json')
            .then((res) => {
                for (let key in res) {
                    console.log(res[key]);
                let name = res[key].person;
                let phone = res[key].phone;

                let li = $(`<li>${name}: ${phone} </li>`)
                    .append($('<button>[Delete]</button>')
                        .on('click', function () {
                            $.ajax({
                                method: 'DELETE',
                                url: url + '/' + key + '.json' })
                                .then(() => $(li).remove())
                        }));
                $('#phonebook').append(li);
            }
        })
    }

    function createPhonenumberEntry() {
        let name = $('#person').val();
        let phoneVal = $('#phone').val();
        let phonenumberEntry = JSON.stringify({'person': name, 'phone': phoneVal});

        $.post(url + '.json', phonenumberEntry)
            .then(loadPhonenumbers);

        $('#person').val('');
        $('#phone').val('');
    }
}