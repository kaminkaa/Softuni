(function formCreation() {

    class Textbox {

        constructor (selector,regex){
            this._elements = $(selector);
            this._invalidSymbols = regex;

            let _that = this;

            this._elements.each(function (index,elem) {
                $(elem).on('input',function () {
                    _that.value = elem.value
                })
            })
        }

        get value(){
            return this._value
        }

        set value (value){
            this._value = value;
            this.changeValues()
        }

        get elements (){
            return this._elements
        }

        changeValues(){
            let _that = this;
            this._elements.each(function (index,elem) {
                elem.value = _that.value;
            })
        }

        isValid () {
            return !this._invalidSymbols.test(this._value);
        }
    }

    class Form {
        constructor(){
            this._elemnt = '<div class="form">';
            this._textboxes = [];
            for (let i = 0; i < arguments.length; i++) {
                if(arguments[i].constructor === Textbox.constructor){
                    for (let obj in arguments) {
                        this._elemnt.append(arguments[obj]);
                    }
                    this._textboxes.push(arguments)
                } else {
                    throw new Error;
                }
            }
        }

        submit(){
            let invalid = 0;
            for (let i = 0; i < this._textboxes.length; i++) {
                if(this._textboxes[i].isValid()){
                    this._textboxes[i].css("2px solid green" );
                } else {
                    this._textboxes[i].css("2px solid red" );
                    invalid++;
                }
                if(invalid > 0){
                    return false;
                } else {
                    return true;
                }
            }
        }

        attach(selector){
            $(selector).addClass(this);
        }
    }

    return {
        Textbox: Textbox,
        Form: Form
    };

}());