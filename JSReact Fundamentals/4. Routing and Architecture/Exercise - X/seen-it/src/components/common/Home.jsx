import React, {Component} from 'react';
import LoginForm from "../user/LoginForm";
import RegisterForm from "../user/RegisterForm";

export default class Home extends Component {
    render = () => {
        return (
            <div>
                <LoginForm />
                <RegisterForm />
            </div>
        )
    }
}