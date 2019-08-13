import React, { Component } from 'react';
import '../../style/buy.css';
import Player from './Player';
import Popup from '../common/Popup';

export default class PlayersForSale extends Component {
    constructor(props) {
        super(props);

        this.state = {
            showPopup: false,
            popupMessage: "",
            playerBought: false
        };

        this.togglePopup = this.togglePopup.bind(this);
        this.changeState = this.changeState.bind(this);
    }

    togglePopup() {
        this.setState({ showPopup: !this.state.showPopup });

        if (this.state.playerBought) {
            window.location.reload();
        }
    }

    changeState(showPopup, popupMessage, playerBought) {
        this.setState({
            showPopup: showPopup,
            popupMessage: popupMessage,
            playerBought: playerBought
        });
    }

    render() {
        const { players, userInfo } = this.props;

        if (players === undefined) {
            return null;
        }

        return (
            <div>
                {players.map(p => {
                    return (
                        <Player
                            key={p._id}
                            id={p._id}
                            name={p.name}
                            image={p.image}
                            age={p.age}
                            position={p.position}
                            prefFoot={p.prefFoot}
                            owner={p.owner}
                            ranking={p.ranking}
                            price={p.price}
                            available={p.available}
                            forSale={p.forSale}
                            userInfo={userInfo}
                            callPopup={this.changeState}
                        />
                    );
                })}
                { this.state.showPopup ? <Popup handleClose={() => this.togglePopup()} message={this.state.popupMessage}/> : null}
            </div>
        );
    }
}