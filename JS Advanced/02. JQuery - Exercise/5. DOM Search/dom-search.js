function domSearch(selector, isCaseSensitive) {
    let container = $(selector);

    // 'add' controls:
    let divAddControls = $('<div>').addClass('add-controls');
    let labelAC = $('<label>Enter text:</label>');
    let inputAC = $('<input>').attr('id', 'inputText');
    inputAC.appendTo(labelAC);
    labelAC.appendTo(divAddControls);
    let anchor = $('<a>Add</a>').addClass('button').css('display', 'inline-block');
    anchor.on('click', addItem);
    anchor.appendTo(divAddControls);
    container.append(divAddControls);

    // 'search' controls:
    let divSearchControls = $('<div>').addClass('search-controls');
    let labelSC = $('<label>Search:</label>');
    let inputSC = $('<input>').attr('id', 'searchText');
    inputSC.appendTo(labelSC);
    labelSC.appendTo(divSearchControls);

    // 'result' controls:
    let divResultControls = $('<div>');
    divResultControls.addClass('result-controls');
    let list = $('<ul>');
    list.addClass('items-list');
    list.appendTo(divResultControls);

    container.append(divSearchControls);
    container.append(divResultControls);

    function addItem() {
        let item = $('<li>');
        item.addClass('list-item');
        let x = $('<a>X</a>');
        x.addClass('button');
        x.on('click', removeItem);
        let content = $(`<strong>${inputAC.val()}</strong>`);
        x.appendTo(item);
        content.appendTo(item);
        list.append(item);
        inputAC.val('');
    }

    function removeItem() {
        $(this).parent().remove();
    }
    //inputSC.on('keyup', function () {
    inputSC.on('input', function () {
        $('li').css('display', 'none');
        let searchText = inputSC.val();
      /*  for (let item of items) {
            if(item.childNodes[1].textContent.includes(searchText)) {
                console.log(item);
                item.css('display', '');
            }
        }*/

        if (isCaseSensitive) {
            $(`li:contains(${searchText})`).css('display', '');
        } else {
            $('li').each((i, li) => {
                if (li.textContent.toLowerCase().includes(searchText.toLowerCase())) {
                    $(li).css('display', '')
                }
            })
        }
    });
}
