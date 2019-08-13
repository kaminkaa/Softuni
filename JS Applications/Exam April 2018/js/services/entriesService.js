let entries = (() => {
    function getEntriesByReceiptID (receiptId) {
        const endpoint = `entries?query={"receiptId":"${receiptId}"}`;

        return remote.get('appdata', endpoint, 'kinvey');
    }

    function addEntry (type, qty, price, subTotal, receiptId) {
        let data = {type, qty, price, subTotal, receiptId};

        return remote.post('appdata', 'entries', 'kinvey', data);
    }

    function deleteEntry (entryId) {
        const endpoint = `entries/${entryId}`;

        return remote.remove('appdata', endpoint, 'kinvey');
    }

    return {
        getEntriesByReceiptID,
        addEntry,
        deleteEntry
    };
})();