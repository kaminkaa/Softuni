let expect = require('chai').expect;
let StringBuilder = require('../string-builder');

describe('String Builder tests', function () {

    it('has functions attached to prototype', function () {
        let strBuilder = new  StringBuilder();
        expect(Object.getPrototypeOf(strBuilder).hasOwnProperty('append')).to.equal(true, "Missing append function");
        expect(Object.getPrototypeOf(strBuilder).hasOwnProperty('prepend')).to.equal(true, "Missing prepend function");
        expect(Object.getPrototypeOf(strBuilder).hasOwnProperty('insertAt')).to.equal(true, "Missing insertAt function");
        expect(Object.getPrototypeOf(strBuilder).hasOwnProperty('remove')).to.equal(true, "Missing remove function");
        expect(StringBuilder.hasOwnProperty('_vrfyParam')).to.equal(true, "Missing _vrfyParam function");
        expect(Object.getPrototypeOf(strBuilder).hasOwnProperty('toString')).to.equal(true, "Missing toString function");
    });

    /* Initialization tests */
    it('An array', function () {
        let strBuilder = new  StringBuilder();
        expect(strBuilder._stringArray).to.be.an('array');
    });
    it('Empty array at initialization', function () {
        let strBuilder = new  StringBuilder();
        expect(strBuilder._stringArray).to.be.an('array').that.is.empty;
    });
    it('[s,t,r,i,n,g] at initialization', function () {
        let strBuilder = new  StringBuilder('string');
        expect(strBuilder._stringArray).to.include.members(['s','t','r','i','n','g']);
    });
    it('Not a string at initialization', function () {
        expect(() => {let strBuilder = new  StringBuilder(29);}).to.throw(TypeError);
    });

    /* append tests */
    it('Not a string at append', function () {
        let strBuilder = new  StringBuilder('string');
        expect(() => {strBuilder.append(29)}).to.throw(TypeError);
    });
    it('[s,t,r,i,n,g,t,w,o] at append', function () {
        let strBuilder = new  StringBuilder('string');
        strBuilder.append('two');
        expect(strBuilder._stringArray).to.include.members(['s','t','r','i','n','g','t','w','o']);
    });

    /* prepend tests */
    it('Not a string at prepend', function () {
        let strBuilder = new  StringBuilder('string');
        expect(() => {strBuilder.prepend(29)}).to.throw(TypeError);
    });
    it('[o,n,e,s,t,r,i,n,g] at prepend', function () {
        let strBuilder = new  StringBuilder('string');
        strBuilder.prepend('one');
        expect(strBuilder._stringArray).to.include.members(['o','n','e','s','t','r','i','n','g']);
    });

    /* insertAt tests */
    it('Not a string at insertAt', function () {
        let strBuilder = new  StringBuilder('string');
        expect(() => {strBuilder.insertAt(29,3)}).to.throw(TypeError);
    });
    it('[o,n,e,c,a,t,s,t,r,i,n,g] at insertAt', function () {
        let strBuilder = new  StringBuilder('onestring');
        strBuilder.insertAt('cat',3);
        expect(strBuilder._stringArray).to.include.members(['o','n','e','c','a','t','s','t','r','i','n','g']);
    });

    /* remove tests */
    it('ring at remove', function () {
        let strBuilder = new  StringBuilder('string');
        strBuilder.remove(0,2);
        expect(strBuilder._stringArray).to.include.members(['r','i','n','g']);
    });

    /* _vrfyParam */
    it('throw Error', function () {
        expect(() => {StringBuilder._vrfyParam(29)}).to.throw(TypeError);
    });
    it('no error', function () {
        expect(() => {StringBuilder._vrfyParam('string')}).to.not.throw(TypeError);
    });

    /* toString() */
    it('one two cat at toString', function () {
        let strBuilder = new  StringBuilder();
        strBuilder.append('one ');
        strBuilder.append('two ');
        strBuilder.append('cat');
        expect(strBuilder.toString()).to.be.equal('one two cat');
    });
    it('nothing at toString', function () {
        let strBuilder = new  StringBuilder();
        expect(strBuilder.toString()).to.be.equal('');
    });
});
