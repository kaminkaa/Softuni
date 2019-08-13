let expect = require('chai').expect;
let PaymentPackage = require('../PaymentPackage');

describe('PaymentPackage tests', function () {
    it('has functions attached to prototype', function () {
        let ppackage = new  PaymentPackage('string',1);
        expect(Object.getPrototypeOf(ppackage).hasOwnProperty('name')).to.equal(true, "Missing name function");
        expect(PaymentPackage.hasOwnProperty('name')).to.equal(true, "Missing name function");
        expect(Object.getPrototypeOf(ppackage).hasOwnProperty('value')).to.equal(true, "Missing value function");
       // expect(PaymentPackage.hasOwnProperty('_value')).to.equal(true, "Missing value function");
        expect(Object.getPrototypeOf(ppackage).hasOwnProperty('VAT')).to.equal(true, "Missing VAT function");
       // expect(PaymentPackage.hasOwnProperty('VAT')).to.equal(true, "Missing VAT function");
        expect(Object.getPrototypeOf(ppackage).hasOwnProperty('active')).to.equal(true, "Missing active function");
       // expect(PaymentPackage.hasOwnProperty('active')).to.equal(true, "Missing active function");
        expect(Object.getPrototypeOf(ppackage).hasOwnProperty('toString')).to.equal(true, "Missing toString function");
    });

    /* Initialization name tests */
    it('error for no string parameter passed', function () {
        expect(() => {let ppackage = new  PaymentPackage(1);}).to.throw(Error);
    });
    it('error for not a string', function () {
        expect(() => {let ppackage = new  PaymentPackage(1,1);}).to.throw(Error);
    });
    it('error for an empty string', function () {
        expect(() => {let ppackage = new  PaymentPackage('',1);}).to.throw(Error);
    });

    /* Initialization value tests */
    it('error for no number parameter passed', function () {
        expect(() => {let ppackage = new  PaymentPackage('string');}).to.throw(Error);
    });
    it('error for not a number', function () {
        expect(() => {let ppackage = new  PaymentPackage('string','string');}).to.throw(Error);
    });
    it('error for a negative number', function () {
        expect(() => {let ppackage = new  PaymentPackage('string',-1);}).to.throw(Error);
    });
    it('value is 0', function () {
        let ppackage = new  PaymentPackage('string',1);
        ppackage.value = 0;
        expect(ppackage._value).to.be.equal(0);
    });

    /* Initialization VAT tests */
    it('default VAT value is 20', function () {
        let ppackage = new  PaymentPackage('string',1);
        expect(ppackage._VAT).to.be.equal(20);
    });
    it('VAT is 30', function () {
        let ppackage = new  PaymentPackage('string',1);
        ppackage.VAT = 30;
        expect(ppackage._VAT).to.be.equal(30);
    });
    it('VAT is 0', function () {
        let ppackage = new  PaymentPackage('string',1);
        ppackage.VAT = 0;
        expect(ppackage._VAT).to.be.equal(0);
    });
    it('error for not a VAT number', function () {
        let ppackage = new  PaymentPackage('string',1);
        expect(() => {ppackage.VAT = 'string';}).to.throw(Error);
    });
    it('error for a negative VAT number', function () {
        let ppackage = new  PaymentPackage('string',1);
        expect(() => {ppackage.VAT = -1;}).to.throw(Error);
    });

    /* active tests */
    it('default active value is true', function () {
        let ppackage = new  PaymentPackage('string',1);
        expect(ppackage._active).to.be.equal(true);
    });
    it('error for not a boolean active value ', function () {
        let ppackage = new  PaymentPackage('string',1);
        expect(() => {ppackage.active = null;}).to.throw(Error);
    });
    it('active is false ', function () {
        let ppackage = new  PaymentPackage('string',1);
        ppackage.active = false;
        expect(ppackage._active).to.be.equal(false);
    });

    /* toString tests */
    it('toString with active object ', function () {
        let ppackage = new  PaymentPackage('string',1);
        expect(ppackage.toString()).to.be.equal('Package: string\n- Value (excl. VAT): 1\n- Value (VAT 20%): 1.2');
    });
    it('toString with inactive object ', function () {
        let ppackage = new  PaymentPackage('string',1);
        ppackage.active = false;
        expect(ppackage.toString()).to.be.equal('Package: string (inactive)\n- Value (excl. VAT): 1\n- Value (VAT 20%): 1.2');
    });
});