import React, { Component } from 'react';
//import { connect } from 'react-redux';
//import {  } from './actions/';
import AppRouter from './components/common/AppRouter';
import Header from './components/common/Header';
import Footer from './components/common/Footer';

import { players, users } from './data.json';

class App extends Component {
  render() {
    return (
      <div>
        <Header />
        <main>
          <AppRouter players={players} users={users} />
        </main>
        <Footer />
      </div>
    );
  }
}

export default App;
