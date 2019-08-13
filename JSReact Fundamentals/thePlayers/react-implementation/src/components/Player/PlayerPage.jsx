import React, { Component } from 'react';
import '../../style/player.css';
import Popup from '../common/Popup';
import { updateUser } from '../../services/userRemote';
import { updatePlayer } from '../../services/playersRemote';

import { fetchPlayerInfoAction } from '../../actions/playersActions';
import { fetchUserInfoAction } from '../../actions/usersActions';
import { connect } from 'react-redux';

class PlayerPage extends Component {
    constructor(props) {
        super(props);

        this.state = {
            showPopup: false,
            popupMessage: "",
            playerBought: false
        };

        this.onBuy = this.onBuy.bind(this);
        this.togglePopup = this.togglePopup.bind(this);
    }

    componentWillMount() {
        this.props.fetchPlayerInfo(this.props.match.params.id);
        this.props.fetchUserInfo();
    }

    togglePopup() {
        this.setState({ showPopup: !this.state.showPopup });

        if (this.state.playerBought) {
            window.location.reload();
        }
    }

    async onBuy() {
        // validate if user can afford it
        const { userInfo, player } = this.props;
        let userMoney = Number(userInfo.money);
        let playerPrice = Number(player.price);

        if (playerPrice > userMoney) {
            const msg = "You do not have enough credit to buy " + player.name;
            this.setState({
                showPopup: true,
                popupMessage: msg,
                playerBought: false
            });

            return;
        }

        // update user -> reduce money
        userMoney -= playerPrice;

        const userData = {
            username: userInfo.username,
            firstName: userInfo.firstName,
            lastName: userInfo.lastName,
            email: userInfo.email,
            money: userMoney,
            offers: userInfo.offers
        };

        await updateUser(userInfo._id, userData);

        // update player -> change owner, forSale: false
        const playerData = {
            name: player.name,
            image: player.image,
            age: player.age,
            position: player.position,
            prefFoot: player.prefFoot,
            owner: userInfo.username,
            ranking: player.ranking,
            price: player.price,
            available: true,
            forSale: false
        };

        await updatePlayer(player._id, playerData);

        const msg = "Congratulations! You successfully bought " + player.name;
        this.setState({
            showPopup: true,
            popupMessage: msg,
            playerBought: true
        });
    }

    render() {
        const { player } = this.props;
        return (
            <div className="container">
                <h1>{player.name}</h1>
                <div className="playerField">
                    <div className="playerImage">
                        <img className="playerImg" src={player.image} alt="" />
                    </div>
                    <div className="playerInfo">
                        <div className="infoText">
                            <p><b>Age:</b>&ensp; {player.age}</p>
                            <p><b>Position:</b>&ensp; {player.position}</p>
                            <p><b>Preferred Foot:</b>&ensp; {player.prefFoot}</p>
                            <p><b>Current Owner:</b>&ensp; {player.owner}</p>
                            <p><b>Ranking:</b>&ensp; {player.ranking}</p>
                            <p><b>Price:</b>&ensp; {player.price}</p>
                            { player.forSale ? <button onClick={this.onBuy}>Buy</button> : null}
                        </div>
                    </div>
                    { this.state.showPopup ? <Popup handleClose={() => this.togglePopup()} message={this.state.popupMessage}/> : null}
                </div>
            </div>
        );
    }
}


function mapStateToProps(state) {
    const { playerInfo } = state.players;
    const { userInfo } = state.users;

    return {
        player: playerInfo,
        userInfo: userInfo
    };
}

function mapDispatchToProps(dispatch) {
    return {
        fetchPlayerInfo: (id) => dispatch(fetchPlayerInfoAction(id)),
        fetchUserInfo: () => dispatch(fetchUserInfoAction(localStorage.getItem("username")))
    };
}

export default connect(mapStateToProps, mapDispatchToProps)(PlayerPage);