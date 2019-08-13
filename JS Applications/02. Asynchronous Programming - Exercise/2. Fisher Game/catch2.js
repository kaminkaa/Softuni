function attachEvents() {
    const appKey = 'kid_HJxlIXtqf';
    const username = 'peter';
    const password = 'p';
    const authHeaders = 'Basic ' + btoa(username + ':' + password);
    const baseUrl = `https://baas.kinvey.com/appdata/${appKey}/biggestCatches`;

    $(':button.load').on('click', loadData);
    $(':button.add').on('click', addCatch);

    function loadData() {
        $.ajax({
            method: 'GET',
            url: baseUrl,
            headers: {
                Authorization: authHeaders
            }
        }).then(displayCatches);
    }

    function displayCatches(catches) {
        $('#catches').empty();
        for (let catchObj of catches) {
            let catchDiv = $('<div class="catch">').attr('data-id', catchObj._id);
            catchDiv
                .append($('<label>Angler</label>'))
                .append($(`<input type="text" class="angler" value="${catchObj.angler}"/>`))
                .append($('<label>Weight</label>'))
                .append($(`<input type="number" class="weight" value="${catchObj.weight}">`))
                .append($('<label>Species</label>'))
                .append($(`<input type="text" class="species" value="${catchObj.species}"/>`))
                .append($('<label>Location</label>'))
                .append($(`<input type="text" class="location" value="${catchObj.location}"/>`))
                .append($('<label>Bait</label>'))
                .append($(`<input type="text" class="bait" value="${catchObj.bait}"/>`))
                .append($('<label>Capture Time</label>'))
                .append($(`<input type="number" class="captureTime" value="${catchObj.captureTime}"/>`))
                .append($('<button class="update">Update</button>').on('click', updateCatch))
                .append($('<button class="delete">Delete</button>').on('click', deleteCatch));
            $('#catches').append(catchDiv);
        }
    }

    function addCatch() {
        let angler = $('#addForm .angler').val();
        let weight = Number($('#addForm .weight').val());
        let species = $('#addForm .species').val();
        let location = $('#addForm .location').val();
        let bait = $('#addForm .bait').val();
        let captureTime = Number($('#addForm .captureTime').val());

        let catchObj = {
            angler: angler,
            weight: weight,
            species: species,
            location: location,
            bait: bait,
            captureTime: captureTime
        };

        $.ajax({
            method: 'POST',
            url: baseUrl,
            data: JSON.stringify(catchObj),
            headers: {
                'Authorization': authHeaders,
                'Content-type': 'application/json'
            }
        }).then(loadData);

        $('#addForm .angler').val('');
        $('#addForm .weight').val('');
        $('#addForm .species').val('');
        $('#addForm .location').val('');
        $('#addForm .bait').val('');
        $('#addForm .captureTime').val('');
    }

    function updateCatch() {
        let id = $(this.parentNode).attr('data-id');
        let angler = $(this.parentNode).find('.angler').val();
        let weight = Number($(this.parentNode).find('.weight').val());
        let species = $(this.parentNode).find('.species').val();
        let location = $(this.parentNode).find('.location').val();
        let bait = $(this.parentNode).find('.bait').val();
        let captureTime = Number($(this.parentNode).find('.captureTime').val());

        let catchObj = {
            angler: angler,
            weight: weight,
            species: species,
            location: location,
            bait: bait,
            captureTime: captureTime
        };

        $.ajax({
            method: 'PUT',
            url: baseUrl + '/' + id,
            data: JSON.stringify(catchObj),
            headers: {
                'Authorization': authHeaders,
                'Content-type': 'application/json'
            }
        }).then(loadData);
    }

    function deleteCatch() {
        let id = $(this.parentNode).attr('data-id');
        $.ajax({
            method: 'DELETE',
            url: baseUrl + '/' + id,
            headers: {
                'Authorization': authHeaders,
                'Content-type': 'application/json'
            }
        }).then(loadData);
    }
}