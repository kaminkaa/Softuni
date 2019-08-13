import React, { Component } from 'react';
import '../../style/buy.css';
import '../../style/popup.css';
import { updateUser } from '../../services/userRemote';
import { updatePlayer } from '../../services/playersRemote';

export default class Player extends Component {
    constructor(props) {
        super(props);

        this.onBuy = this.onBuy.bind(this);
    }

    async onBuy() {
        // validate if user can afford it
        const { callPopup, userInfo, id, name, image, age, position, prefFoot, ranking, price } = this.props;
        let userMoney = Number(userInfo.money);
        let playerPrice = Number(price);

        if (playerPrice > userMoney) {
            const msg = "You do not have enough credit to buy " + name;
            callPopup(true, msg, false);

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
            name: name,
            image: image,
            age: age,
            position: position,
            prefFoot: prefFoot,
            owner: userInfo.username,
            ranking: ranking,
            price: price,
            available: true,
            forSale: false
        };

        await updatePlayer(id, playerData);

        const msg = "Congratulations! You successfully bought " + name;
        callPopup(true, msg, true);
    }

    render() {
        const { id, image, name, owner, ranking, price} = this.props;
        return (
            <div className="player">
                <a href={'/player/' + id}><img src={image} alt=""/></a>
                <p><b>Name:</b>{name}</p>
                <p><b>Current Owner:</b>{owner}</p>
                <p><b>Ranking:</b>{ranking}</p>
                <p><b>Price:</b>{price}</p>
                <button onClick={this.onBuy}>Buy</button>
            </div>
        );
    }
}