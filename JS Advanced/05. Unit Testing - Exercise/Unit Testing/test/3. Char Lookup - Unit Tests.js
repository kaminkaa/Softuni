let expect = require('chai').expect;
const lookupChar = require('../3. Char Lookup');

describe("lookupChar tests", function() {
    it("Should return undefined for 1,1", function () {
        expect(lookupChar(1,1)).to.be.equal(undefined);
    });

    it("Should return undefined for '1','1'", function () {
        expect(lookupChar('1','1')).to.be.equal(undefined);
    });

    it("Should return undefined for '1',1.32", function () {
        expect(lookupChar('1',1.32)).to.be.equal(undefined);
    });

    it("Should return undefined for ,0", function () {
        expect(lookupChar('',0)).to.be.equal('Incorrect index');
    });

    it("Should return Incorrect index for cat,5", function () {
        expect(lookupChar('cat',5)).to.be.equal('Incorrect index');
    });

    it("Should return Incorrect index for cat,-5", function () {
        expect(lookupChar('cat',-5)).to.be.equal('Incorrect index');
    });

    it("Should return Incorrect index for cat,3", function () {
        expect(lookupChar('cat',3)).to.be.equal('Incorrect index');
    });

    it("Should return c index for cat,0", function () {
        expect(lookupChar('cat',0)).to.be.equal('c');
    });

    it("Should return c index for cat,1", function () {
        expect(lookupChar('cat',1)).to.be.equal('a');
    });
});