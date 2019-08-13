class PaymentManager {
    constructor(title){
        this.title = title;
        this.table = this.createTable();
    }

    render(id) {
        let container = $('#' + id);
        container.append(this.table);
    }

    createTable() {
        let table = $('<table>');

        /* table header: */
        let caption = $('<caption>').text(this.title + ' Payment Manager').appendTo(table);
        let thead = $('<thead>');
        let theadRow = $('<tr>');
        let a1 = $('<a>&#x25B2;</a>');
        let a2 = $('<a>&#x25BC;</a>');
        let a3 = $('<a>&#x25B2;</a>');
        let a4 = $('<a>&#x25BC;</a>');
        let a5 = $('<a>&#x25B2;</a>');
        let a6 = $('<a>&#x25BC;</a>');
        let nameCol = $('<th>').attr('id','name').text('Name');
        nameCol.append(a1);
        nameCol.append(a2);
        let categoryCol = $('<th>').attr('id','category').text('Category');
        categoryCol.append(a3);
        categoryCol.append(a4);
        let priceCol = $('<th>').attr('id','price').text('Price');
        priceCol.append(a5);
        priceCol.append(a6);
        let actionsCol = $('<th>').text('Actions');
        theadRow.append(nameCol);
        theadRow.append(categoryCol);
        theadRow.append(priceCol);
        theadRow.append(actionsCol);
        thead.append(theadRow);
        table.append(thead);

        /* table body */
        let tbody = $('<tbody>').attr('id', 'payments');
        table.append(tbody);

        /* table footer: */
        let tfoot = $('<tfoot>').attr('id', 'input-data');
        let tfootRow = $('<tr>');
        let nameInputCol = $('<td>');
        let nameInput = $('<input>').attr('name','name').attr('type','text');
        nameInputCol.append(nameInput);
        let categoryInputCol = $('<td>');
        let categoryInput = $('<input>').attr('name','category').attr('type','text');
        categoryInputCol.append(categoryInput);
        let priceInputCol = $('<td>');
        let priceInput = $('<input>').attr('name','price').attr('type','number');
        priceInputCol.append(priceInput);
        let addBtnCol = $('<td>');
        let addBtn = $('<button>').text('Add').on('click', this.addProduct);
        addBtnCol.append(addBtn);
        tfootRow.append(nameInputCol);
        tfootRow.append(categoryInputCol);
        tfootRow.append(priceInputCol);
        tfootRow.append(addBtnCol);
        tfoot.append(tfootRow);
        table.append(tfoot);

        return table;
    }

    addProduct(){
        let id = this.parentNode.parentNode.parentNode.parentNode.parentNode.id;
        let newRow = $('<tr>');

        let name = $('#'+id).find('input[name=name]');
        let nameValue = name.val();
        let category = $('#'+id).find('input[name=category]');
        let categoryValue = category.val();
        let price = $('#'+id).find('input[name=price]');
        let priceValue = price.val();

        if (nameValue === '' || categoryValue === '' || priceValue === '') {
            return;
        }

        let nameCol = $('<td>').text(nameValue);
        let categoryCol = $('<td>').text(categoryValue);
        let priceCol = $('<td>').text(+priceValue);
        let deleteBtnCol = $('<td>');
        let deleteBtn = $('<button>').text('Delete').on('click', function(){
            $(this).parent().parent().remove();});
        deleteBtnCol.append(deleteBtn);

        newRow.append(nameCol);
        newRow.append(categoryCol);
        newRow.append(priceCol);
        newRow.append(deleteBtnCol);
        $('#'+id).find('#payments').append(newRow);

        name.val('');
        category.val('');
        price.val('');
    }
}