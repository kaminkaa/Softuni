let expect = require('chai').expect;
const isOddOrEven = require('../2. Even or Odd');

describe("isOddOrEven tests", function() {
    it("Should return undefined for 1", function () {
        expect(isOddOrEven(1)).to.be.equal(undefined);
    });

    it("Should return undefined for {}", function () {
        expect(isOddOrEven({})).to.be.equal(undefined);
    });

    it("Should return even for meaw", function () {
        expect(isOddOrEven('meaw')).to.be.equal('even');
    });

    it("Should return odd for cat", function () {
        expect(isOddOrEven('cat')).to.be.equal('odd');
    });

    it("Should return odd for cat says meaw", function () {
        expect(isOddOrEven('cat says meaw')).to.be.equal('odd');
    });
});