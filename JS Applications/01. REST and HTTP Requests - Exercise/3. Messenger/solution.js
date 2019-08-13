function attachEvents() {
    $('#submit').on('click', sendMessage);
    $('#refresh').on('click', showMessages);
    showMessages();

    function showMessages() {
        $.get('https://my-messenger-64f5d.firebaseio.com/messenger.json')
            .then(displayMessages)
            //.catch((err) => console.log('error'));
    }

    function sendMessage() {
        let authorName = $('#author').val();
        let msgContent = $('#content').val();

        let newMsg = JSON.stringify({
            author: authorName,
            content: msgContent,
            timestamp: Date.now()
        });

        $.post('https://my-messenger-64f5d.firebaseio.com/messenger.json', newMsg)
            .then(() => {
                showMessages();
                $('#author').val('');
                $('#content').val('');
            })
            //.catch(() => console.log('Error'));
    }

    function displayMessages(messages) {
        let textArea = '';
        let messagesArr = [];
        for (let id in messages) {
            messagesArr.push(messages[id]);
        }
        messagesArr.sort(function(m1,m2){return m1.timestamp - m2.timestamp});

        for (let msg of messagesArr) {
            textArea += msg.author + ': ' + msg.content + '\n';
        }

        $('#messages').text(textArea);
    }
}