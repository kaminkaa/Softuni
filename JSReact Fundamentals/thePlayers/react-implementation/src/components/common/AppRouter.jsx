import React from 'react';
import { Switch, Route } from 'react-router-dom';
import HomePage from '../Home/HomePage';
import BuyPage from '../Buy/BuyPage';
import ExchangePage from '../Exchange/ExchangePage';
import ProfilePage from '../Profile/ProfilePage';
import PlayersPage from '../Players/PlayersPage';
import UsersPage from '../Users/UsersPage';
import RegisterPage from '../Authorization/RegisterPage';
import LoginPage from '../Authorization/LoginPage';
import PlayerPage from '../Player/PlayerPage';
import RegSuccess from '../Authorization/RegSuccess';
import NotFound from './NotFound';

const AppRouter = () => {
        return (
            <div>
                <Switch>
                    <Route exact path="/" component={HomePage} />
                    <Route exact path="/buy" component={BuyPage} />
                    <Route path="/exchange" component={ExchangePage} />
                    <Route path="/players" component={PlayersPage} />
                    <Route path="/users" component={UsersPage} />
                    <Route path="/profile" component={ProfilePage} />
                    <Route path="/register" component={RegisterPage} />
                    <Route path="/login" component={LoginPage} />
                    <Route path="/player/:id" component={PlayerPage} />
                    <Route exact path="/regSuccess" component={RegSuccess} />
                    <Route component={NotFound} />
                </Switch>
            </div>
            );
};

export default AppRouter;
