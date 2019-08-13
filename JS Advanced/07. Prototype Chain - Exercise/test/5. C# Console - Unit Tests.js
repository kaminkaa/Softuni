let expect = require('chai').expect;
const Console = require('../Exercises/5. C# Console');

describe('Console tests', function () {
    it('writeLine test with string ', function () {
        expect(Console.writeLine('cats')).to.be.equal('cats');
    });

    it('writeLine test with object ', function () {
        expect(Console.writeLine({cat: 'Shushu'})).to.be.equal(JSON.stringify({cat: 'Shushu'}));
    });

    it('writeLine test with string and placeholders ', function () {
        expect(Console.writeLine('{0}, {1}, {2}', 1, 2, 3)).to.be.equal('1, 2, 3');
    });

    it('writeLine test with too many placeholders ', function () {
        expect(() => {Console.writeLine('{0}, {1}', 0)}).to.throw(RangeError);
    });

    it('writeLine test with too many placeholders ', function () {
        expect(() => {Console.writeLine('{13}', 1, 2, 3, 4, 5)}).to.throw(RangeError);
    });

    it('writeLine test with number and placeholders ', function () {
        expect(() => {Console.writeLine(1, 2, 4)}).to.throw(TypeError);
    });
});