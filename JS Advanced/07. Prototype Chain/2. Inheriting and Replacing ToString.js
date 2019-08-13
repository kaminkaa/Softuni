function personAndTeacher() {
    class Person {
        constructor(name, email) {
            this.name = name;
            this.email = email;
        }

        toString(){
            let className = this.constructor.name;
            return `${className} (name: ${this.name}, email: ${this.email})`;
        }
    }

    class Teacher extends Person {
        constructor(name, email, subject) {
            super(name, email);
            this.subject = subject;
        }

        toString() {
            let parentStr = super.toString().slice(0,-1);
            return parentStr + `, subject: ${this.subject})`;
        }
    }

    class Student extends Person {
        constructor(name, email, course) {
            super(name, email);
            this.course = course;
        }

        toString() {
            let parentStr = super.toString().slice(0,-1);
            return parentStr + `, course: ${this.course})`;
        }
    }
    return {Person, Teacher, Student};
}

let obj = personAndTeacher();

let p = new obj.Person("Maria", "maria@gmail.com");
console.log('' + p);
let t = new obj.Teacher("Ivan", "iv@yahoo.com", "PHP");
console.log('' + t);
let s = new obj.Student("Ana", "ana@mail.ru", 3);
console.log('' + s);
