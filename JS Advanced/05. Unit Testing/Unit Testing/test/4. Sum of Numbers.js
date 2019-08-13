let expect = require('chai').expect;

    function sum(arr) {
        let sum = 0;
        for (num of arr) {
            sum += Number(num);
        }
        return sum;
    }

    describe("Sum tests", function() {
        it("Should return 3 for [1, 2]", function () {
            expect(sum([1, 2])).to.be.equal(3);
        });

        it("Should return 1 for [1]", function () {
            expect(sum([1])).to.be.equal(1);
        });

        it("Should return 0 for []", function () {
            expect(sum([])).to.be.equal(0);
        });

        it("Should return 3 for [1.5, 2.5, -1]", function () {
            expect(sum([1.5, 2.5, -1])).to.be.equal(3);
        });

        it("Should return NaN for invalid data", function () {
            expect(sum(['cats'])).to.be.NaN;
        });
    });
