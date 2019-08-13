function move(command) {
    let availableTowns = document.getElementById('available-towns');
    let selectedTowns = document.getElementById('selected-towns');

    switch (command) {
        case 'right':
            let availableTown = availableTowns.options[availableTowns.selectedIndex].text;
            availableTowns.remove(availableTowns.selectedIndex);
            let newSelectedTown = document.createElement('option');
            newSelectedTown.text = availableTown;
            selectedTowns.add(newSelectedTown);
            break;
        case 'left':
            let selectedTown = selectedTowns.options[selectedTowns.selectedIndex].text;
            selectedTowns.remove(selectedTowns.selectedIndex);
            let newAvailableTown = document.createElement('option');
            newAvailableTown.text = selectedTown;
            availableTowns.add(newAvailableTown);
            break;
        case 'print':
            let selectedOptions = [];
            $('#selected-towns option').each(function () {
                selectedOptions.push($(this).text());
            });
            $('#output').text(selectedOptions.join('; '));
            break;
    }
}