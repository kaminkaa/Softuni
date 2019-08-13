class Dialog {
    constructor (textMessage, callback) {
        this.textMessage = textMessage;
        this.callback = callback;
        this.element = this.createElement();
    }

    addInput (label, name, type) {

    }

    render() {
        $(document.body).append(this.element);
    }

    createElement() {
        let overlayDiv = $('<div>').addClass('overlay');
        let dialogDiv = $('<div>').addClass('dialog');
        let paragr = $('<p>').text(this.textMessage).appendTo(dialogDiv);
        let label = $('<label>').text('Name').appendTo(dialogDiv);
        let input = $('<input>').attr('name','name').attr('type','text').appendTo(dialogDiv);
        let okBtn = $('<button>').text('OK').appendTo(dialogDiv).on('click', this.submit);
        let cancelBtn = $('<button>').text('Cancel').appendTo(dialogDiv).on('click', this.cancel.bind(this));
        overlayDiv.append(dialogDiv);
        return overlayDiv;
    }

    submit() {

    }

    cancel() {
        this.element.remove();
    }
}