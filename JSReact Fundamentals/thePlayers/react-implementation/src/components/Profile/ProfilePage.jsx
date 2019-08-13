import React, { Component } from 'react';
import '../../style/profile.css';
import PersonalInfo from './PersonalInfo';
import Offers from './Offers';
import Players from './Players';

import { fetchUserInfoAction } from '../../actions/usersActions';
import { connect } from 'react-redux';
import {fetchLoggedInPlayersAction} from "../../actions/playersActions";

class ProfilePage extends Component {
    componentWillMount() {
        this.props.fetchUserInfo();
        this.props.fetchLoggedInPlayers();
    }

    render() {
        const { userInfo, userPlayers } = this.props;
        return (
            <div className="container">
                <h1>Hello, {localStorage.getItem("username")} :)</h1>
                <div className="profileWrapper">
                    <PersonalInfo
                        username={userInfo.username}
                        firstName={userInfo.firstName}
                        lastName={userInfo.lastName}
                        email={userInfo.email}
                        money={userInfo.money}
                        playersOwned={userPlayers === undefined ? 0 : userPlayers.length}
                    />
                    <Offers userInfo={userInfo} />
                    <Players players={userPlayers} />
                </div>
            </div>
        );
    }
}

function mapStateToProps(state) {
    const { userInfo } = state.users;
    const { loggedInUserPlayers } = state.players;

    return {
        userInfo: userInfo,
        userPlayers: loggedInUserPlayers
    };
}

function mapDispatchToProps(dispatch) {
    return {
        fetchUserInfo: () => dispatch(fetchUserInfoAction(localStorage.getItem("username"))),
        fetchLoggedInPlayers: () => dispatch(fetchLoggedInPlayersAction())
    };
}

export default connect(mapStateToProps, mapDispatchToProps)(ProfilePage);