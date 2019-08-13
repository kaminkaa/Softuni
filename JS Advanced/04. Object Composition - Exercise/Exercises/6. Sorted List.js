function collection () {
    let list  = [];

        let obj = {
            add: function (element) {
                list.push(element);
                list.sort((a, b) => a - b);
                this.size ++;
                return list;
            },
            remove: function (index) {
                if (index >= 0 && index < list.length) {
                    list.splice(index,1);
                    this.size --;
                }
                list.sort((a, b) => a - b);
                return list;
            },
            get: function (index) {
                if (index >= 0 && index < list.length) {
                    return list[index];
                }
            },
            size: 0
        };
        return obj;
}

let list = collection();
console.log(list.add(1));
console.log(list.add(2));
console.log(list.add(3));
console.log(list.add(4));
console.log(list.add(5));
console.log(list.add(3));
console.log(list.remove(0));
console.log(list.get(0));
console.log(list.size);