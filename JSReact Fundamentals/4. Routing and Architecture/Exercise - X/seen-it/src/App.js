import React, { Component } from 'react';
import {Route} from 'react-router-dom';
import Header from "./components/common/Header";
import Home from "./components/common/Home";
import './styles/site.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Header />
          <Route path='/' exact component={Home}/>
      </div>
    );
  }
}

export default App;
