let expect = require('chai').expect;
let jsdom = require('jsdom-global')();
let $ = require('jquery');
const nuke = require('../6. ArmageDom');

describe("Nuke tests", function () {

    let initialHTML;
    beforeEach(function () {
        document.body.innerHTML =
            `<body>
                <div id="target">
                        <div class="nested target">
                            <p>This is some text</p>
                        </div>
                    <div class="target">
                        <p>Empty div</p>
                    </div>
                    <div class="inside">
                        <span class="nested">Some more text</span>
                        <span class="target">Some more text</span>
                    </div>
                </div>
            </body>`;
        initialHTML = $('body').html();
    });

    it('Valid and invalid selectors', function () {
        let selector1 = $('.inside');
        let selector2 = 175;
        nuke(selector1, selector2);
        let modifiedHTML = $('body').html();
        expect(modifiedHTML).to.be.equal(initialHTML);
    });

    it('Omitted selector', function () {
        let selector1 = $('.inside');
        nuke(selector1);
        let modifiedHTML = $('body').html();
        expect(modifiedHTML).to.be.equal(initialHTML);
    });

    it('Selectors are the same', function () {
        let selector1 = $('.inside');
        nuke(selector1, selector1);
        let modifiedHTML = $('body').html();
        expect(modifiedHTML).to.be.equal(initialHTML);
    });

    it('Valid selectors', function () {
        let selector1 = $('.nested');
        let selector2 = $('.target');
        nuke(selector1, selector2);
        let modifiedHTML = $('body').html();
        expect(modifiedHTML).to.be.not.equal(initialHTML);
    });

    it('Valid selectors', function () {
        let selector1 = $('.inside');
        let selector2 = $('.target');
        nuke(selector1, selector2);
        let modifiedHTML = $('body').html();
        expect(modifiedHTML).to.be.equal(initialHTML);
    });
});