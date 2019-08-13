let expect = require('chai').expect;
const Sumator = require('../sumator');

describe('Sumator tests', function () {
    let testObj;
    
    beforeEach(function () {
        testObj = new Sumator();
    });

    it('has functions attached to prototype', function () {
        expect(Object.getPrototypeOf(testObj).hasOwnProperty('add')).to.equal(true, "Missing add function");
        expect(Object.getPrototypeOf(testObj).hasOwnProperty('sumNums')).to.equal(true, "Missing sumNums function");
        expect(Object.getPrototypeOf(testObj).hasOwnProperty('removeByFilter')).to.equal(true, "Missing removeByFilter function");
        expect(Object.getPrototypeOf(testObj).hasOwnProperty('toString')).to.equal(true, "Missing toString function");
    });

    /* Initialization tests */
    it('Empty array at initialization', function () {
        expect(testObj.data).to.be.an('array').that.is.empty;
    });

    /* Add tests */
    it('Data to be 5', function () {
        testObj.add(5);
        expect(testObj.data).to.include.members([5]);
    });

    /* sumNums tests */
    it('sum to be 0 at initialization', function () {
        expect(testObj.sumNums()).to.be.equal(0);
    });
    it('sum to be 0 with no numbers in the data', function () {
        testObj.add({});
        testObj.add('cats');
        testObj.add([]);
        expect(testObj.sumNums()).to.be.equal(0);
    });
    it('sum to be 10.5', function () {
        testObj.add(5);
        testObj.add('cat');
        testObj.add(5.5);
        expect(testObj.sumNums()).to.be.equal(10.5);
    });

    /* removeByFilter tests */
    it('Data to be 1,3,5,7', function () {
        testObj.add(1);
        testObj.add(2);
        testObj.add(3);
        testObj.add(4);
        testObj.add(5);
        testObj.add(6);
        testObj.add(7);
        testObj.removeByFilter(x => x % 2 === 0);
        expect(testObj.data).to.include.members([1,3,5,7]);
    });
    it('Empty array', function () {
        testObj.add(1);
        testObj.removeByFilter(x => x === 1);
        expect(testObj.data).to.be.an('array').that.is.empty;
    });

    /* toString tests */
    it('(empty)', function () {
        expect(testObj.toString()).to.be.equal('(empty)');
    });
    it('1, 2, 3, 4, 5', function () {
        testObj.add(1);
        testObj.add(2);
        testObj.add(3);
        testObj.add(4);
        testObj.add(5);
        expect(testObj.toString()).to.be.equal('1, 2, 3, 4, 5');
    });
    it('5, [object Object], text1,text2,8.7', function () {
        testObj.add(5);
        testObj.add({cat: "Az", dog: "Ti"});
        testObj.add(["text1","text2", 8.7]);
        expect(testObj.toString()).to.be.equal('5, [object Object], text1,text2,8.7');
    });
});