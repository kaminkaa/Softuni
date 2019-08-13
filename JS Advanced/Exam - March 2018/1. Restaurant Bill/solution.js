function addProduct() {
    let product = $('input[type=text]');
    let productValue = product.val();
    let price = $('input[type=number]');
    let priceValue = price.val();

    if (productValue !== '' && priceValue !== '') {
        addToTable(productValue, priceValue);
    }

    product.val('');
    price.val('');

    function addToTable(product, price) {
        let tableBody = $('#product-list');
        let newRow = $('<tr>');
        let productColumn = $('<td>').text(product).appendTo(newRow);
        let priceColumn = $('<td>').text(price).appendTo(newRow);
        sumTotal(price);
        tableBody.append(newRow);
    }

    function sumTotal(price) {
        let sumColumn = $('td')[$('td').length-1];
        let sumValue = Number(sumColumn.innerHTML);
        sumValue += Number(price);
        sumColumn.innerHTML = sumValue;
    }
    console.log(productValue + ' ' + priceValue)
}