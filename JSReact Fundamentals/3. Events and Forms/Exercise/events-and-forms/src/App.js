import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import './App.css';
import SignUpForm from './components/SignUpForm';
import LoginForm from './components/LoginForm';
import LoggedInScreen from './components/logged-in/LoggedInScreen';

class App extends Component {
  constructor() {
    super();
    let route = '';
    if(localStorage.getItem('token')) {
      route = 'loggedIn'
    }
    this.state = {
      route: route
    };

    this.showAppropriateComponent = this.showAppropriateComponent.bind(this);
    this.switchLoginSignup = this.switchLoginSignup.bind(this);
    this.setLoggedIn = this.setLoggedIn.bind(this);
  }

  // funkzia za rout-vane:
  showAppropriateComponent() {
    if (this.state.route === 'login') {
      return <LoginForm setLoggedIn = {this.setLoggedIn} />;
    } else if (this.state.route === 'loggedIn') {
      return <LoggedInScreen />;
    }
    return <SignUpForm />
  }

  setLoggedIn() {
    this.setState({route: 'loggedIn'})
  }

    switchLoginSignup() {
        if (this.state.route === 'login') {
            this.setState({route: ''});
        } else {
            this.setState({route: 'login'});
        }
    }

  render() {
    return (
      <div className="App">
        <button onClick={this.switchLoginSignup} className="btn btn-link">Toggle Forms</button>
          {this.showAppropriateComponent()}
      </div>
    );
  }
}

export default App;
