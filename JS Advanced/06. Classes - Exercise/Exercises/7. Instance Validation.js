class CheckingAccount {
    constructor(clientId, email, firstName, lastName) {
        this.clientId = clientId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    set clientId (value) {
        let numberCheck = /^[\d]{6}$/;
        if (!numberCheck.test(value)) {
            throw new TypeError('Client ID must be a 6-digit number');
        }
        this._clientId = value;
    }

    set email (value) {
        let emailCheck = /[\w]+@[a-zA-Z/.]+/;
        if (!emailCheck.test(value)) {
            throw new TypeError('Invalid e-mail');
        }
        this._email = value;
    }

    set firstName (value) {
        let nameCheck = /^[a-zA-Z]{3,20}$/;
        if (!nameCheck.test(value)) {
            if (value.length < 3 || value.length > 20) {
                throw new TypeError('First name must be between 3 and 20 characters long');
            }
            throw new TypeError('First name must contain only Latin characters');
        }
        this._firstName = value;
    }

    set lastName (value) {
        let nameCheck = /^[a-zA-Z]{3,20}$/;
        if (!nameCheck.test(value)) {
            if (value.length < 3 || value.length > 20) {
                throw new TypeError('Last name must be between 3 and 20 characters long');
            }
            throw new TypeError('Last name must contain only Latin characters');
        }
        this._lastName = value;
    }
}