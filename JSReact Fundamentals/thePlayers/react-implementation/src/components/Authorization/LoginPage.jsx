import React, { Component } from 'react';
import Input from '../common/Input';
import { login } from '../../services/authRemote';
import { Redirect } from 'react-router-dom';
import ErrorMsg from '../common/ErrorMsg';

export default class LoginPage extends Component {
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
    }

    async handleSubmit() {
        const data = {
            username: this.state.username,
            password:  this.state.password
        };

        const dataOk = this.validateData(data);

        if (dataOk) {
            await login(data)
                .then(response => {
                    this.setState({
                        redirect: response.success,
                        msg: response.msg
                    });
                });
        }
    }

    validateData(data) {
        if (data.username.length === 0) {
            this.setState({
                msg: 'Please fill in your username'
            });
            return false;
        }

        if (data.password.length === 0) {
            this.setState({
                msg: 'Please fill in your password'
            });
            return false;
        }

        return true;
    }

    render() {
        if (this.state.redirect) {
            return (
                <Redirect to="/" />
            );
        }

        return (
            <div className="container">
                <h1>Login</h1>
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
                    name="password"
                    type="password"
                    value={this.state.password}
                    onChange={this.handleChange}
                    label="Password"
                    className="form"
                />
                <button onClick={this.handleSubmit}>Submit</button>
            </div>
        );
    }
}