import React, { Component } from 'react';
import Input from '../common/Input';
import { register } from '../../services/authRemote';
import { Redirect } from 'react-router-dom';
import ErrorMsg from '../common/ErrorMsg';

export default class RegisterPage extends Component {
    constructor(props) {
        super(props);

        this.state = {
            username: '',
            firstName: '',
            lastName: '',
            email: '',
            money: '',
            password: '',
            repeatPass: '',
            redirect: false,
            msg: ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.validateData = this.validateData.bind(this);
    }

    handleChange(event) {
        event.preventDefault();
        this.setState({
            [event.target.name]: event.target.value,
            msg: ''
        });

       /* const target = event.target;
        const prop = target.name;
        const value = target.value;
        const newState = {};
        newState[prop] = value;
        this.setState(newState); */
    }

    async handleSubmit() {
        const data = {
            username: this.state.username,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            email: this.state.email,
            money: this.state.money,
            password: this.state.password,
            "offers": []
        };

        const dataOk = this.validateData(data);

        if (dataOk) {
            await register(data)
                .then(response => {
                    this.setState({
                        redirect: response.success,
                        msg: response.msg
                    });
                });
        }
    }

    validateData(data) {
        if (data.username.length < 4) {
            this.setState({
                msg: 'Username must be at least 4 characters long'
            });
            return false;
        }

        if (data.firstName.length === 0 || data.lastName.length === 0 ) {
            this.setState({
                msg: 'You must fill your first name and last name'
            });
            return false;
        }

        if (data.money.length === 0) {
            this.setState({
                msg: 'You should enter the amount of money you will deposit'
            });
            return false;
        }

        if (data.password.length === 0) {
            this.setState({
                msg: 'Password field cannot be empty'
            });
            return false;
        }

        if (data.password !== this.state.repeatPass) {
            this.setState({
                msg: 'Passwords do not match'
            });
            return false;
        }

        return true;
    }

    render() {
        if (this.state.redirect) {
            return (
                <Redirect to="/regSuccess" />
            );
        }

        return (
            <div className="container">
                <h1>Register</h1>
                <h3>Please fill in the following form:</h3>
                <ErrorMsg errorMsg={this.state.msg}/>
                <Input
                    name="username"
                    type="text"
                    value={this.state.username}
                    onChange={this.handleChange}
                    label="Username"
                    className="form"
                />
                <Input
                    name="firstName"
                    type="text"
                    value={this.state.firstName}
                    onChange={this.handleChange}
                    label="First Name"
                    className="form"
                />
                <Input
                    name="lastName"
                    type="text"
                    value={this.state.lastName}
                    onChange={this.handleChange}
                    label="Last Name"
                    className="form"
                />
                <Input
                    name="email"
                    type="text"
                    value={this.state.email}
                    onChange={this.handleChange}
                    label="E-mail"
                    className="form"
                />
                <Input
                    name="money"
                    type="number"
                    value={this.state.money}
                    onChange={this.handleChange}
                    label="Money"
                    className="form"
                />
                <Input
                    name="password"
                    type="password"
                    value={this.state.password}
                    onChange={this.handleChange}
                    label="Password"
                    className="form"
                />
                <Input
                    name="repeatPass"
                    type="password"
                    value={this.state.repeatPass}
                    onChange={this.handleChange}
                    label="Repeat Pass"
                    className="form"
                />
                <button onClick={this.handleSubmit}>Submit</button>
            </div>
        );
    }
}