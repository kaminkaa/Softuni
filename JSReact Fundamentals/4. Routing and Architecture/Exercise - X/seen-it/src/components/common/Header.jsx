import React, {Component} from 'react';
import '../../styles/header.css';
import observer from "../../infrastructure/observer";

export default class Header extends Component {
    constructor(props) {
        super(props);
        this.state = { username: null };

        observer.subscribe(observer.events.loginUser, this.userLoggedIn );
    }

    userLoggedIn = username => {
        this.setState({ username });
    };

    render = () => {
        const loggedInDiv = <div id="profile"><span id="username">Hello, {this.state.username}!</span>|<a href="#" id="linkMenuLogout">logout</a></div>;

        return (
            <header>
                <span className="logo">&#9731;</span><span className="header">SeenIt</span>
                {this.state.username ? loggedInDiv : null}
            </header>
        )
    }
}