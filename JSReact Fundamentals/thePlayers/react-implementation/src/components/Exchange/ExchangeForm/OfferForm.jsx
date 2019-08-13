import React, { Component } from 'react';
import Select from './Select';
import Button from './Button';
import Popup from '../../common/Popup';

import { updatePlayer } from '../../../services/playersRemote';
import { updateUser } from '../../../services/userRemote';

export default class OfferForm extends Component {
    constructor(props) {
        super(props);

        this.state = {
            playerRequest: "",
            playerOffer: "",
            showPopup: false,
            popupMessage: "",
            offerMade: false
        };

        this.onMakeOffer = this.onMakeOffer.bind(this);
        this.onChangePlayerRequest = this.onChangePlayerRequest.bind(this);
        this.onChangePlayerOffer = this.onChangePlayerOffer.bind(this);
        this.togglePopup = this.togglePopup.bind(this);
    }

    onChangePlayerRequest(e) {
        this.setState({ playerRequest: e.target.value });
    }

    onChangePlayerOffer(e) {
        this.setState({ playerOffer: e.target.value });
    }

    async onMakeOffer() {
        const { players, loggedInUserPlayers, userInfo } = this.props;

        const playerRequest = players.filter(p => p.name === this.state.playerRequest)[0];
        const playerOffer = loggedInUserPlayers.filter(p => p.name === this.state.playerOffer)[0];

        const offer = {
            offerer: localStorage.getItem('username'),
            playerRequest: playerRequest,
            playerOffer: playerOffer
        };

        const playerRequestData = {
            name: playerRequest.name,
            image: playerRequest.image,
            age: playerRequest.age,
            position: playerRequest.position,
            prefFoot: playerRequest.prefFoot,
            owner: playerRequest.owner,
            ranking: playerRequest.ranking,
            price: playerRequest.price,
            available: false,
            forSale: playerRequest.forSale
        };

        await updatePlayer(playerRequest._id, playerRequestData);

        const playerOfferData = {
            name: playerOffer.name,
            image: playerOffer.image,
            age: playerOffer.age,
            position: playerOffer.position,
            prefFoot: playerOffer.prefFoot,
            owner: playerOffer.owner,
            ranking: playerOffer.ranking,
            price: playerOffer.price,
            available: false,
            forSale: playerOffer.forSale
        };

        await updatePlayer(playerOffer._id, playerOfferData);

        let userOffers = userInfo.offers;
        userOffers.push(offer);

        const userData = {
            username: userInfo.username,
            firstName: userInfo.firstName,
            lastName: userInfo.lastName,
            email: userInfo.email,
            money: userInfo.money,
            offers: userOffers
        };

        await updateUser(userInfo._id, userData);

        const msg = "You just made an offer to " + userInfo.username;
        this.setState({
            showPopup: true,
            popupMessage: msg,
            offerMade: true,
            playerRequest: "",
            playerOffer: ""
        });
    }

    togglePopup() {
        this.setState({ showPopup: !this.state.showPopup });

        if (this.state.offerMade) {
            window.location.reload();
        }
    }

    render(){
        const {players, loggedInUserPlayers, userInfo} = this.props;

        if (players === undefined || loggedInUserPlayers === undefined || userInfo.username === localStorage.getItem('username')) {
            return null;
        }

        const playersAvailable = players.filter(p => p.available === true);
        const loggedInPlayersAvailable = loggedInUserPlayers.filter(p => p.available === true);

        const btnEnabled = (!(playersAvailable.length === 0 || loggedInPlayersAvailable.length === 0));

        return (
            <div className="offerForm">
                <b>Make an offer</b><br/>
                <div className="exchangeForm">
                    <div>
                        Player to request
                        <Select players={playersAvailable} handleChange={this.onChangePlayerRequest}/>
                    </div>
                    <div>
                        Player to offer
                        <Select players={loggedInPlayersAvailable} handleChange={this.onChangePlayerOffer}/>
                    </div>
                    <Button handleSubmit={() => this.onMakeOffer()} btnEnabled={btnEnabled}/>
                </div>
                { this.state.showPopup ? <Popup handleClose={() => this.togglePopup()} message={this.state.popupMessage}/> : null}
            </div>
        );
    }
}

