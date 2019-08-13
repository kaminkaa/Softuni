import React, { Component } from 'react';
import '../../style/exchange.css';
import Usernames from './Usernames';
import UserInfo from './UserInfo';
import PlayersOwned from './PlayersOwned';
import OfferForm from './ExchangeForm/OfferForm';

import { fetchUserInfoAction, fetchUsersUsernamesAction } from '../../actions/usersActions';
import { fetchPlayersPerUserAction, fetchLoggedInPlayersAction } from '../../actions/playersActions';
import { connect } from 'react-redux';

class ExchangePage extends Component {
    constructor(props) {
        super(props);

        this.state = { selectedUsername: "" };

        this.onUserClick = this.onUserClick.bind(this);
    }

    onUserClick(selectedUsername) {
        this.setState({selectedUsername: selectedUsername});
        this.props.fetchUserInfo(selectedUsername);
        this.props.fetchPlayersPerUser(selectedUsername);
        this.props.fetchLoggedInPlayers();
    }

    componentWillMount() {
        this.props.fetchUsersUsernames();
    }


    render() {
        const { userInfo, usersUsernames, userPlayers, loggedInUserPlayers } = this.props;

        return (
            <div className="container">
                <h1>Players Exchange</h1>
                <div className="exchangeWrapper">
                    <h2>Users</h2>
                    <Usernames
                        usersUsernames={usersUsernames}
                        selectedUsername={this.state.selectedUsername}
                        setSelectedUsername={this.onUserClick}
                    />
                    <div className="exchangeField">
                        <UserInfo username={userInfo.username} firstName={userInfo.firstName} lastName={userInfo.lastName} playersOwned={userPlayers === undefined ? 0 : userPlayers.length} />
                        <PlayersOwned players={userPlayers} username={userInfo.username} />
                        <OfferForm players={userPlayers} loggedInUserPlayers={loggedInUserPlayers} userInfo={userInfo}/>
                    </div>
                </div>
            </div>
        );
    }
}

function mapStateToProps(state) {
    const { userInfo, usersUsernames } = state.users;
    const { userPlayers, loggedInUserPlayers } = state.players;
    return {
        userInfo: userInfo,
        usersUsernames: usersUsernames,
        userPlayers: userPlayers,
        loggedInUserPlayers: loggedInUserPlayers
    };
}

function mapDispatchToProps(dispatch) {
    return {
        fetchUserInfo: (username) => dispatch(fetchUserInfoAction(username)),
        fetchUsersUsernames: () => dispatch(fetchUsersUsernamesAction()),
        fetchPlayersPerUser: (username) => dispatch(fetchPlayersPerUserAction(username)),
        fetchLoggedInPlayers: () => dispatch(fetchLoggedInPlayersAction())
    };
}

export default connect(mapStateToProps, mapDispatchToProps)(ExchangePage);