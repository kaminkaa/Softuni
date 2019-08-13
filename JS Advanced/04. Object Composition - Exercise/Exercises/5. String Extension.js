(function () {
   String.prototype.ensureStart = function (str) {
       if (this.substring(0,str.length) !== str) {
           return str + this;
       } else {
           return this + '';
       }
    };

    String.prototype.ensureEnd = function (str) {
        if (this.substring(this.length - str.length) !== str) {
            return this + str;
        } else {
            return this + '';
        }
    };

    String.prototype.isEmpty = function () {
        if(this.length === 0) {
            return true;
        } else {
            return false;
        }
    };

    String.prototype.truncate = function (n) {
        if (this.length <= n) {
            return this + '';
        } else {
            let stringParts = this.split(' ');
            if (stringParts.length > 1) {
                let finalStr = stringParts[0];
                let i = 1;
                do {
                    finalStr += ' ' + stringParts[i];
                    i++;
                } while (finalStr.length + 3 <= n);

                if (finalStr.length + 3 > n) {
                    return finalStr.substring(0, finalStr.length - stringParts[i-1].length - 1) + '...';
                } else  {
                    return finalStr + '...';
                }
            } else {
                if (n < 4) {
                    return '.'.repeat(n);
                } else {
                    return this.substring(0, n - 3) + '...';
                }
            }
        }
    };

    String['format'] = function (str, ...params) {
        let indexPattern = /{([\d]*)}/g;
        let indexMatch, index, res;

        while ((indexMatch = indexPattern.exec(str)) !== null) {
            index = Number(indexMatch[1]) + 1;
            let match = indexMatch[0];
            if (index < arguments.length) {
                str = str.replace(match,arguments[index]);
            }
        }
        return str;
    };
})();

let str = 'my string';
str = str.ensureStart('my');
console.log(str);
str = str.ensureStart('hello ');
console.log(str);
str = str.ensureEnd(' Kami');
console.log(str);
str = str.ensureEnd(' Kami');
console.log(str);
str = '';
console.log(str.isEmpty());
str = 'Kami';
console.log(str.truncate(2));
str = 'Kami Krisi';
console.log(str.truncate(2));
str = 'hello my string';
console.log(str.truncate(14));
str = String.format('The {0} {1} fox',
    'quick', 'brown');
console.log(str);