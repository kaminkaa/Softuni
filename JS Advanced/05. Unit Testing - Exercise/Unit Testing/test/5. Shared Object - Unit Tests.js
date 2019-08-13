let expect = require('chai').expect;
let jsdom = require('jsdom-global')();
let $ = require('jquery');

const sharedObject = require('../5. Shared Object');

describe("sharedObject tests", function() {
    let obj;
    beforeEach(function () {
        obj = Object.create(sharedObject);
    });

    it("Should return null for initial state", function () {
        expect(obj.name).to.be.equal(null);
    });

    it("Should return null for initial state", function () {
        expect(obj.income).to.be.equal(null);
    });

    it("Should return null for name", function () {
        obj.changeName('');
        expect(obj.name).to.be.equal(null);
    });

    it("Should return Kami for name", function () {
        obj.changeName('Vesi');
        obj.changeName('Kami');
        expect(obj.name).to.be.equal('Kami');
    });

    it("Should return Vesi for name", function () {
        obj.changeName('Vesi');
        let nameField = $('#name') ;
        expect(nameField.val()).to.be.equal('Vesi');
    });

    it("Should return null for income", function () {
        obj.changeIncome(-2);
        expect(obj.income).to.be.equal(null);
    });

    it("Should return null for income", function () {
        obj.changeIncome(0);
        expect(obj.income).to.be.equal(null);
    });

    it("Should return null for income", function () {
        obj.changeIncome(2.22);
        expect(obj.income).to.be.equal(null);
    });

    it("Should return 2 for income", function () {
        obj.changeIncome(2);
        expect(obj.income).to.be.equal(2);
    });

    it("Should return 33 for income", function () {
        obj.changeIncome(33);
        let incomeField = $('#income');
        expect(incomeField.val()).to.be.equal(33);
    });

    it("Should return 33 for income", function () {
        obj.changeIncome(2);
        obj.changeIncome(33);
        expect(obj.income).to.be.equal(33);
    });

    it("Should return Petar for income", function () {
        let nameField = $('#name').val('Petar');
        obj.updateName();
        expect(obj.name).to.be.equal('Petar');
    });

    it("Should return Gosho for income", function () {
        obj.changeName('Gosho');
        let nameField = $('#name').val('');
        obj.updateName();
        expect(obj.name).to.be.equal('Gosho');
    });

    it('Should return 6 for income', function () {
        let incomeField = $('#income').val('6');
        sharedObject.updateIncome();
        expect(sharedObject.income).to.be.equal(6);
    });

    it('Should return 99 for income', function () {
        sharedObject.changeIncome(99);
        let incomeField = $('#income').val('-9');
        sharedObject.updateIncome();
        expect(sharedObject.income).to.be.equal(99);
    });

    it('Should return 99 for income', function () {
        sharedObject.changeIncome(99);
        let incomeField = $('#income').val(0);
        sharedObject.updateIncome();
        expect(sharedObject.income).to.be.equal(99);
    });

    it('Test updateIncome() with floating point', function () {
        sharedObject.changeIncome(99);
        let incomeField = $('#income').val("99.5");
        sharedObject.updateIncome();
        expect(sharedObject.income).to.be.equal(99);
    });

    it('Test updateIncome() with a string', function () {
        sharedObject.changeIncome(99);
        let incomeField = $('#income').val("az");
        sharedObject.updateIncome();
        expect(sharedObject.income).to.be.equal(3);
    });
});