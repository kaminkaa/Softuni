function solve() {
    let obj = {
        extend: function (template) {
            for (let property in template) {
                if (typeof template[property] === 'function') {
                    Object.getPrototypeOf(obj)[property] = template[property];
                } else {
                    obj[property] = template[property];
                }
            }
        }
    };

    return obj;
}

let extensibleObj = solve();
extensibleObj.extend({
        extensionMethod: function () {return 'testing'},
        extensionProperty: 'someString'
    }
);

console.log(extensibleObj);