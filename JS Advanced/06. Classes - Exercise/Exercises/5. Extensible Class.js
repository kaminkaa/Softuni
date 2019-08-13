let solve = (function() {

    let id = 0;

    return  class  Extensible {
        constructor(){
            this.id = id++;
        }
        extend(template){
            for (let a in template) {
                if (typeof template[a] === 'function') {
                    Object.getPrototypeOf(this)[a] = template[a];
                } else {
                    this[a] = template[a];
                }
            }
        }
    }
}());