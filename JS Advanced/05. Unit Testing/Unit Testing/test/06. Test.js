let expect = require('chai').expect;
const rgbToHexColor = require('../6. RGB to Hex');

describe("RGB to Hex tests", function() {
    it("Should return #FF9EAA for 255,158,170", function () {
        expect(rgbToHexColor(255,158,170)).to.be.equal('#FF9EAA');
    });

    it("Should return #0C0D0E for 12,13,14", function () {
        expect(rgbToHexColor(12,13,14)).to.be.equal('#0C0D0E');
    });

    it("Should return #000000 for 0,0,0", function () {
        expect(rgbToHexColor(0,0,0)).to.be.equal('#000000');
    });

    it("Should return #FFFFFF for 255,255,255", function () {
        expect(rgbToHexColor(255,255,255)).to.be.equal('#FFFFFF');
    });

    it("Should return undefined for -1,0,0", function () {
        expect(rgbToHexColor(-1,0,0)).to.be.equal(undefined);
    });

    it("Should return undefined for 0,256,0", function () {
        expect(rgbToHexColor(0,256,0)).to.be.equal(undefined);
    });

    it("Should return undefined for 0,0,3.14", function () {
        expect(rgbToHexColor(0,0,3.14)).to.be.equal(undefined);
    });

    it("Should return undefined for ", function () {
        expect(rgbToHexColor()).to.be.equal(undefined);
    });

    it("Should return undefined for '5', [3], {8:9}", function () {
        expect(rgbToHexColor("5", [3], {8:9})).to.be.equal(undefined);
    });
});