let receipts = (() => {
    function getActiveReceipt (userId) {
        const endpoint = `receipts?query={"_acl.creator":"${userId}","active":"true"}`;

        return remote.get('appdata', endpoint, 'kinvey');
    }

    function createReceipt () {
        let data = {active: true};

        return remote.post('appdata', 'receipts', 'kinvey', data);
    }

    function getMyReceipts (userId) {
        const endpoint = `receipts?query={"_acl.creator":"${userId}","active":"false"}`;

        return remote.get('appdata', endpoint, 'kinvey');
    }

    function receiptDetails (receiptId) {
        const endpoint = `receipts/${receiptId}`;

        return remote.get('appdata', endpoint, 'kinvey');
    }

    function commitReceipt (receiptId, userId, creationDate, itemsCount, totalAmount) {
        const endpoint = `receipts/${receiptId}`;
        let data = {active: false, userId, creationDate, itemsCount, totalAmount};

        return remote.update('appdata', endpoint, 'kinvey', data);
    }

    return {
        getActiveReceipt,
        createReceipt,
        getMyReceipts,
        receiptDetails,
        commitReceipt
    };
})();