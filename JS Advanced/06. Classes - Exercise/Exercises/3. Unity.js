class Rat {
    constructor(name) {
        this.name = name;
        this.unitedRats = [];
    }

    unite(otherRat) {
        if (otherRat.constructor === this.constructor) {
            this.unitedRats.push(otherRat);
        }
    }

    getRats() {
        return this.unitedRats;
    }

    toString() {
        let str = this.name;
        if (this.unitedRats.length > 0) {
            for (let curr of this.unitedRats) {
                str += '\n##' + curr.name;
            }
        }
        return str;
    }
}