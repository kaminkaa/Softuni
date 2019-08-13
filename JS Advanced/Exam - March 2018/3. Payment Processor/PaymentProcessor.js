class PaymentProcessor {
    constructor(options) {
        this.options = {types: ['service', 'product', 'other'],
                            precision: 2};
        if (options !== undefined) {
            this.setOptions(options);
        }
        this.payments = [];
    }

    checkID (value) {
        if (typeof value !== 'string') {
            throw new Error('invalid ID');
        }
        if (value.length === 0) {
            throw new Error('invalid ID');
        }
    }

    checkName (value) {
        if (typeof value !== 'string') {
            throw new Error('invalid name');
        }
        if (value.length === 0) {
            throw new Error('invalid name');
        }
    }

    checkType (value) {
        if (!this.options.types.includes(value)) {
            throw new Error('invalid type');
        }
    }

    checkValue (value) {
        if (typeof value !== 'number') {
            throw new Error('invalid value');
        }
    }

    idExists (id) {
        let idExists = false;
        for (let payment of this.payments) {
            if (payment.id === id) {
                idExists = true;
            }
        }
        return idExists;
    }

    registerPayment (id, name, type, value) {
        this.checkID(id);
        this.checkName(name);
        this.checkType(type);
        this.checkValue(value);
        if (this.idExists(id)) {
            throw new Error('ID exists');
        }
        let roundedValue = Number(value).toFixed(this.options.precision);
        let newPayment = {id: id, name: name, type: type, value: roundedValue};
        this.payments.push(newPayment);
    }

    deletePayment (id) {
        if(!this.idExists(id)) {
            throw new Error('ID not found');
        }
        this.payments = this.payments.filter(function (p) {
            return p.id !== id;
        });
    }

    get (id) {
        if(!this.idExists(id)) {
            throw new Error('ID not found');
        }

        let payment = this.payments.filter(function (p) {
            return p.id === id;
        })[0];
        
        return 'Details about payment ID: ' + id + '\n- Name: ' + payment.name + '\n- Type: ' + payment.type + '\n- Value: ' + payment.value;
    }
    
    setOptions (options) {
        for (let option of Object.keys(options)) {
            this.options[option] = options[option];
        }
    }

    toString () {
        let balance = 0;
        for (let payment of this.payments) {
            balance += Number(payment.value);
        }

        return 'Summary:' + '\n- Payments: ' + this.payments.length + '\n- Balance: ' + balance.toFixed(this.options.precision);
    }
}

// Should throw an error (invalid type)
const generalPayments = new PaymentProcessor();
generalPayments.registerPayment('0001', 'Microchips', 'product', 15000);
generalPayments.registerPayment('01A3', 'Biopolymer', 'product', 23000);
console.log(generalPayments.toString());
generalPayments.setOptions({types: ['product', 'material']});
generalPayments.registerPayment('E028', 'Rare-earth elements', 'material', 8000);
console.log(generalPayments.get('E028'));
generalPayments.registerPayment('CF15', 'Enzymes', 'material', 55000);
generalPayments.deletePayment('E028');
console.log(generalPayments.toString());

// Initialize processor with custom types
const servicePyaments = new PaymentProcessor({types: ['service']});
servicePyaments.registerPayment('01', 'HR Consultation', 'service', 3000);
servicePyaments.registerPayment('02', 'Discount', 'service', -1500);
console.log(servicePyaments.toString());

// Initialize processor with custom precision
const transactionLog = new PaymentProcessor({precision: 5});
transactionLog.registerPayment('b5af2d02-327e-4cbf', 'Interest', 'other', 0.00153);
console.log(transactionLog.toString());




