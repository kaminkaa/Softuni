import React, { Component } from 'react';

class LoginForm extends Component {
    constructor() {
        super();

        this.state = {
            form: {}
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        event.preventDefault();
        const name = event.target.dataset.name;
        const value = event.target.value;
        const formInput = {};

        formInput[name] = value;
        console.log(name, value);

        this.setState({
            form: Object.assign(this.state.form, formInput)
        });
    }

    handleSubmit() {
        fetch('http://localhost:5000/auth/login', {
            method: 'POST',
            body: JSON.stringify(this.state.form),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(data => data.json())
            .then(response => {
                if (response.success && response.token) {
                    localStorage.setItem('token', response.token);
                    this.props.setLoggedIn();
                }
            })
            .catch(err => console.log(err))
    }

    render() {
        return (
            <form>
                <h1>Login</h1>
                <div className="form-group">
                    <label>Email address</label>
                    <input data-name="email" type="email" onChange={this.handleChange} className="form-control" id="input-email" aria-describedby="emailHelp" placeholder="Enter email"/>
                </div>
                <div className="form-group">
                    <label>Password</label>
                    <input data-name="password" type="password" onChange={this.handleChange} className="form-control" id="input-password" placeholder="Password"/>
                </div>
                <button type="button" onClick={this.handleSubmit} className="btn btn-primary">Submit</button>
            </form>
        )
    }
}

export default LoginForm;