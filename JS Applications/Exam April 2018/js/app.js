$(() => {
    const app = Sammy('#container', function () {
        this.use('Handlebars', 'hbs');

        this.get('index.html', displaySignInPage);
        this.get('#/home', displaySignInPage);

        function displaySignInPage(ctx) {
            if(auth.isAuth()) {
                ctx.redirect('#/homeScreen');
            } else {
                ctx.loadPartials({
                    footer: './templates/common/footer.hbs',
                    loginForm: './templates/forms/loginForm.hbs',
                    registerForm: './templates/forms/registerForm.hbs'
                }).then(function() {
                    this.partial('./templates/welcome-anonymous.hbs')
                })
            }
        }

        this.post('#/register', (ctx) => {
            let username = ctx.params.usernameRegister;
            let password = ctx.params.passwordRegister;
            let passwordCheck = ctx.params.passwordRegisterCheck;

            if (typeof(username) !== 'string' || username.length < 5) {
                notify.showError('Username should be a string with at least 5 characters long.');
            } else if (password === '' || passwordCheck === '') {
                notify.showError('Password fields should not be empty.');
            } else if (password !== passwordCheck) {
                notify.showError('Passwords do not match.');
            } else {
                auth.register(username, password)
                    .then((userInfo) => {
                        auth.saveSession(userInfo);
                        notify.showInfo('User registration successful.');
                        ctx.redirect('#/homeScreen');
                    })
                    .catch(notify.handleError);
            }
        });

        this.post('#/login', (ctx) => {
            let username = ctx.params.usernameLogin;
            let password = ctx.params.passwordLogin;

            if (typeof(username) !== 'string' || username.length < 5 || username === '') {
                notify.showError('Username should be a string with at least 5 characters long.');
            } else if (password === '') {
                notify.showError('Password field should not be empty.');
            } else {
                auth.login(username, password)
                    .then((userInfo) => {
                        auth.saveSession(userInfo);
                        notify.showInfo('Login successful.');
                        ctx.redirect('#/homeScreen');
                    })
                    .catch(notify.handleError);
            }
        });

        this.get('#/logout', (ctx) => {
            auth.logout()
                .then(() => {
                    sessionStorage.clear();
                    notify.showInfo('Logout successful.');
                    ctx.redirect('#/home');
                })
                .catch(notify.handleError);
        });

        this.get('#/homeScreen', (ctx) => {
            if (!auth.isAuth()) {
                ctx.redirect('#/home');
                return;
            }

            receipts.getActiveReceipt(sessionStorage.getItem('userId'))
                .then((receipt) => {
                    if (receipt.length === 0) {
                        receipts.createReceipt()
                            .then((rcpt) => {
                                ctx.username = sessionStorage.getItem('username');
                                ctx.receiptId = rcpt._id;

                                ctx.loadPartials({
                                    entry: './templates/entries/entry.hbs',
                                    header: './templates/common/header.hbs',
                                    footer: './templates/common/footer.hbs'
                                }).then(function () {
                                    this.partial('./templates/receipts/createReceiptView.hbs')
                                })
                            })
                            .catch(notify.handleError)
                    } else {
                        entries.getEntriesByReceiptID(receipt[0]._id)
                            .then((entries) => {
                                ctx.username = sessionStorage.getItem('username');
                                ctx.receiptId = receipt[0]._id;
                                ctx.entries = entries;

                                ctx.loadPartials({
                                    entry: './templates/entries/entry.hbs',
                                    header: './templates/common/header.hbs',
                                    footer: './templates/common/footer.hbs'
                                }).then(function () {
                                    this.partial('./templates/receipts/createReceiptView.hbs')
                                })
                            })
                            .catch(notify.handleError)
                    }
                })
                .catch(notify.handleError);
        });

        this.post('#/addEntry', (ctx) => {
            let type = ctx.params.type;
            let qty = ctx.params.qty;
            let price = ctx.params.price;
            let receiptId = ctx.params.receiptId;
            let subTotal = qty * price;

            if (typeof(type) !== 'string' || type === '') {
                notify.showError('Product name must be a non-empty string');
                return;
            }

            if (!/^-?\d+\.?\d*$/.test(qty)) {
                notify.showError('Quantity must be a number');
                return;
            }

            if (!/^-?\d+\.?\d*$/.test(price)) {
                notify.showError('Price must be a number');
                return;
            }

            entries.addEntry(type, qty, price, subTotal, receiptId)
                .then(() => {
                    entries.getEntriesByReceiptID(receiptId)
                        .then((entries) => {
                            ctx.username = sessionStorage.getItem('username');
                            ctx.receiptId = receiptId;
                            ctx.entries = entries;

                            ctx.loadPartials({
                                entry: './templates/entries/entry.hbs',
                                header: './templates/common/header.hbs',
                                footer: './templates/common/footer.hbs'
                            }).then(function () {
                                this.partial('./templates/receipts/createReceiptView.hbs')
                            })
                        })
                        .catch(notify.handleError)
                })
                .catch(notify.handleError)
        });

        this.post('#/checkOut', (ctx) => {
            receipts.getActiveReceipt(sessionStorage.getItem('userId'))
                .then((rcpts) => {
                    let rcpt = rcpts[0];
                    let receiptId = rcpt._id;
                    let itemsCount = 0;
                    let totalAmount = 0;
                    let creationDate = getDate();

                    entries.getEntriesByReceiptID(receiptId)
                        .then((entries) => {
                            itemsCount = (entries.length);

                            entries.forEach((e,i) => {
                                totalAmount += e.qty * e.price;
                            });

                            receipts.commitReceipt(receiptId, sessionStorage.getItem('userId'), creationDate, itemsCount, totalAmount)
                                .then(() => {
                                    receipts.createReceipt()
                                        .then((rcpt) => {
                                            ctx.username = sessionStorage.getItem('username');
                                            ctx.receiptId = rcpt._id;

                                            ctx.loadPartials({
                                                entry: './templates/entries/entry.hbs',
                                                header: './templates/common/header.hbs',
                                                footer: './templates/common/footer.hbs'
                                            }).then(function () {
                                                this.partial('./templates/receipts/createReceiptView.hbs')
                                            })
                                        })
                                        .catch(notify.handleError)
                                })
                                .catch(notify.handleError)
                        });
                })
        });

        function getDate () {
            let today = new Date();
            let dd = today.getDate();
            let mm = today.getMonth()+1; //January is 0!
            let yyyy = today.getFullYear();
            let h = today.getHours();
            let m = today.getMinutes();

            if(dd<10) {
                dd = '0'+ dd
            }

            if(mm<10) {
                mm = '0'+ mm
            }

            if(h<10) {
                h = '0'+ h
            }

            if(m<10) {
                m = '0'+ m
            }

            today = yyyy + '-' + mm + '-' + dd + ' ' + h + ':' + m;

            return today;
        }

        this.get('#/overview', (ctx) => {
            receipts.getMyReceipts(sessionStorage.getItem('userId'))
                .then((myReceipts) => {
                    ctx.username = sessionStorage.getItem('username');
                    ctx.receipts = myReceipts;

                    ctx.loadPartials({
                        receipt: './templates/receipts/receipt.hbs',
                        header: './templates/common/header.hbs',
                        footer: './templates/common/footer.hbs'
                    }).then(function () {
                        this.partial('./templates/receipts/allReceipts.hbs')
                    })
                })
        });

        this.get('#/archive', (ctx) => {
            receipts.getMyReceipts(sessionStorage.getItem('userId'))
                .then((myReceipts) => {
                    ctx.username = sessionStorage.getItem('username');
                    ctx.receipts = myReceipts;

                    ctx.loadPartials({
                        receipt: './templates/receipts/receipt.hbs',
                        header: './templates/common/header.hbs',
                        footer: './templates/common/footer.hbs'
                    }).then(function () {
                        this.partial('./templates/receipts/allReceipts.hbs')
                    })
                })
        });

        this.get('#/displayDetails/:receiptId', (ctx) => {
            let receiptId = ctx.params.receiptId;
            console.log(receiptId);

            entries.getEntriesByReceiptID(receiptId)
                .then((entries) => {
                    ctx.username = sessionStorage.getItem('username');
                    ctx.entries = entries;

                    ctx.loadPartials({
                        detailsEntry: './templates/entries/detailsEntry.hbs',
                        header: './templates/common/header.hbs',
                        footer: './templates/common/footer.hbs'
                    }).then(function () {
                        this.partial('./templates/receipts/receiptDetails.hbs')
                    })
                })
                .catch(notify.handleError)
        });

        this.get('#/deleteEntry/:entryId', (ctx) => {
            let entryId = ctx.params.entryId;

            entries.deleteEntry(entryId)
                .then(() => {
                    ctx.redirect('#/homeScreen')
                })
                .catch(notify.handleError)
        })

    });

    app.run();
});