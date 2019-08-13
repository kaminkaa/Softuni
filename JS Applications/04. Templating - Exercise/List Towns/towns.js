function attachEvents () {
    $('#btnLoadTowns').on('click', getTowns);

    function getTowns() {
        let townsInput = $('#towns').val();
        let towns = townsInput.split(/,[ *]+|,/g)
            .map(town => ({name: town}));
        listTowns(towns);
    }

    function listTowns(towns) {
        let source = $('#towns-template').html();
        let compiled = Handlebars.compile(source);
        let template = compiled({
            towns
        })
        $('#root').append(template);
    }
}