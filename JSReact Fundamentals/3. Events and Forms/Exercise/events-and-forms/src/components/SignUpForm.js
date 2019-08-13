import React, { Component } from 'react';

class SignUpForm extends Component {
    constructor() {
        super();

        this.state = {
            form: {}
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    // insert change into form model
    handleChange(event) {
        event.preventDefault(); // da ne se prezarejda cqlata straniza, za da stigne do submit-a
        const name = event.target.dataset.name;
        const value = event.target.value;
        const formInput = {};
        /* vmesto Object.assign:
            const formInput = {
            email: this.state.form.email,
            name: this.state.form.name,
            password: this.state.form.password
            };
        */
        formInput[name] = value;
        console.log(name, value);

        this.setState({
            form: Object.assign(this.state.form, formInput)
            // vmesto Object.assign -> form: formInput
        });
    }

    // send post to appropriate API handle:
    // do sth on success:
    handleSubmit() {
        fetch('http://localhost:5000/auth/signup', {
            method: 'POST',
            body: JSON.stringify(this.state.form),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(data => data.json())
            .then(response => console.log(response))
    }

    render() {
        return (
            <form>
                <h1>Sign Up</h1>
                <div className="form-group">
                    <label>Email address</label>
                    <input data-name="email" type="email" onChange={this.handleChange} className="form-control" id="input-email" aria-describedby="emailHelp" placeholder="Enter email"/>
                </div>
                <div className="form-group">
                    <label>Username</label>
                    <input data-name="name" type="text" onChange={this.handleChange} className="form-control" id="input-username" placeholder="Username"/>
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

export default SignUpForm;