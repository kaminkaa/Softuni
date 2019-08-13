let expect = require('chai').expect;
const createCalculator = require('../7. Add Subtract');

describe("Add/Subtract tests", function() {
    let calc;
    beforeEach(function () {
        calc = createCalculator();
    });

    it("Should return 0", function () {
        expect(calc.get()).to.be.equal(0);
    });

    it("Should return 5", function () {
        calc.add(2);
        calc.add(3);
        expect(calc.get()).to.be.equal(5);
    });

    it("Should return 4.2", function () {
        calc.add(5.3);
        calc.subtract(1.1);
        expect(calc.get()).to.be.equal(4.2);
    });

    it("Should return 2", function () {
        calc.add(10);
        calc.subtract(7);
        calc.add(-2);
        calc.subtract(-1);
        expect(calc.get()).to.be.equal(2);
    });

    it("Should return -5", function () {
        calc.subtract(2);
        calc.subtract(3);
        expect(calc.get()).to.be.equal(-5);
    });

    it("Should return NaN", function () {
        calc.add('hello');
        expect(calc.get()).to.be.NaN;
    });

    it("Should return NaN", function () {
        calc.subtract('hello');
        expect(calc.get()).to.be.NaN;
    });
});