$(() => {
    renderCatTemplate();

    async function renderCatTemplate() {
        let cats = window.cats;

        let source = await $.get('./cat-template.hbs');
        let compile = Handlebars.compile(source);
        let template = compile({
            cats
        });
        $('body').append(template);

        $('button').on('click', function (event) {
            let buttonClicked = $(event.target);
            let infoDiv = buttonClicked.next();
            if (buttonClicked.text().includes('Show')) {
                infoDiv.show();
                buttonClicked.text('Hide status code');
            } else {
                infoDiv.hide();
                buttonClicked.text('Show status code');
            }

        });
    }

});
