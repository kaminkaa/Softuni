class Stringer {
    constructor(innerString, innerLength) {
        this.innerString = innerString;
        this.innerLength = Number(innerLength);
    }

    increase(length) {
        this.innerLength += Number(length);
    }

    decrease(length) {
        this.innerLength -= Number(length);
        if (this.innerLength < 0) {
            this.innerLength = 0;
        }
    }
    
    toString() {
        if (this.innerLength === 0) {
            return '...';
        }

        if (this.innerString.length > this.innerLength) {
            let difference = this.innerString.length - this.innerLength;
            return this.innerString.substring(0,this.innerString.length - difference) + '...';
        }

        return this.innerString;
    }
}