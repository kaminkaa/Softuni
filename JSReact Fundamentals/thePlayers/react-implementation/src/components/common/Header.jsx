import React, { Component } from 'react';
import { NavLink, Link } from 'react-router-dom';
import '../../style/navbar.css';
import { withRouter } from 'react-router-dom';
import { logout } from '../../services/authRemote';

class Header extends Component {
    constructor(props) {
        super(props);

        this.handleLogout = this.handleLogout.bind(this);
    }

    handleLogout() {
        logout();
        this.props.history.push('/');
    }

    render() {
        const loggedIn = localStorage.getItem('authToken') != null;
        const admin = localStorage.getItem('username') === 'admin';

        return (
            <header>
                <nav className="navbar">
                    <div className="container">
                        <ul className="navbarUL">
                            <li className="navbarLI"><Link to="/" className="navLink">The Players</Link></li>
                            <li className="navbarLI"><NavLink to="/" exact className="navLink" activeClassName="activeNavbar">Home</NavLink></li>
                            {loggedIn && <li className="navbarLI"><NavLink to="/buy" className="navLink" activeClassName="activeNavbar">Buy</NavLink></li>}
                            {loggedIn && <li className="navbarLI"><NavLink to="/exchange" className="navLink" activeClassName="activeNavbar">Exchange</NavLink></li>}
                            {admin && <li className="navbarLI"><NavLink to="/players" className="navLink" activeClassName="activeNavbar">Players</NavLink></li>}
                            {admin && <li className="navbarLI"><NavLink to="/users" className="navLink" activeClassName="activeNavbar">Users</NavLink></li>}
                            {loggedIn && <li className="navbarLI rightSide"><Link to="" onClick={this.handleLogout} className="navLink" >Logout</Link></li>}
                            {!loggedIn && <li className="navbarLI rightSide"><NavLink to="/login" className="navLink" activeClassName="activeNavbar">Login</NavLink></li>}
                            {!loggedIn && <li className="navbarLI rightSide"><NavLink to="/register" className="navLink" activeClassName="activeNavbar">Register</NavLink></li>}
                            {loggedIn && <li className="navbarLI rightSide"><NavLink to="/profile" className="navLink" activeClassName="activeNavbar">Profile</NavLink></li>}
                        </ul>
                    </div>
                </nav>
            </header>
        )
    }
}

export default withRouter(Header);