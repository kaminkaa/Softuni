let expect = require('chai').expect;
const mathEnforcer = require('../4. Math Enforcer');

describe("mathEnforcer tests", function() {
    describe("addFive tests", function() {
        it("Should return undefined for 'text'", function () {
            expect(mathEnforcer.addFive('text')).to.be.equal(undefined);
        });
        it("Should return 10 for 5", function () {
            expect(mathEnforcer.addFive(5)).to.be.equal(10);
        });
        it("Should return 0 for -5", function () {
            expect(mathEnforcer.addFive(-5)).to.be.equal(0);
        });
        it("Should return 10.5 for 5.5", function () {
            expect(mathEnforcer.addFive(5.5)).to.be.closeTo(10.5,0.01);
        });
    });

    describe("subtractTen tests", function() {
        it("Should return undefined for 'text'", function () {
            expect(mathEnforcer.subtractTen('text')).to.be.equal(undefined);
        });
        it("Should return 10 for 20", function () {
            expect(mathEnforcer.subtractTen(20)).to.be.equal(10);
        });
        it("Should return 0 for 10", function () {
            expect(mathEnforcer.subtractTen(10)).to.be.equal(0);
        });
        it("Should return -20 for -10", function () {
            expect(mathEnforcer.subtractTen(-10)).to.be.equal(-20);
        });
        it("Should return 15.5 for 25.5", function () {
            expect(mathEnforcer.subtractTen(25.5)).to.be.closeTo(15.5,0.01);
        });
    });

    describe("sum tests", function() {
        it("Should return undefined for 'text'", function () {
            expect(mathEnforcer.sum('text',2)).to.be.equal(undefined);
        });
        it("Should return undefined for 'text'", function () {
            expect(mathEnforcer.sum(2,'text')).to.be.equal(undefined);
        });
        it("Should return 10 for 5", function () {
            expect(mathEnforcer.sum(5,5)).to.be.equal(10);
        });
        it("Should return 0 for 5,-5", function () {
            expect(mathEnforcer.sum(5,-5)).to.be.equal(0);
        });
        it("Should return -20 for -10,-10", function () {
            expect(mathEnforcer.sum(-10,-10)).to.be.equal(-20);
        });
        it("Should return 15.5 for 10,5.5", function () {
            expect(mathEnforcer.sum(10,5.5)).to.be.closeTo(15.5,0.01);
        });
        it("Should return 11 for 5.5,5.5", function () {
            expect(mathEnforcer.sum(5.5,5.5)).to.be.equal(11);
        });
    });
});