import React from 'react';
import Offer from './Offer';

import { updateUser } from '../../services/userRemote';
import { updatePlayer } from "../../services/playersRemote";

 async function handleOffer(type, offer, userInfo) {

    let userOffers = userInfo.offers;
    let currentOfferIndex = userOffers.indexOf(offer);

    userOffers.splice(currentOfferIndex, 1);

    const userData = {
        username: userInfo.username,
        firstName: userInfo.firstName,
        lastName: userInfo.lastName,
        email: userInfo.email,
        money: userInfo.money,
        offers: userOffers
    };

    await updateUser(userInfo._id, userData);

    let playerRequestOwner, playerOfferOwner;

    if (type === "accept") {
         playerRequestOwner = offer.offerer;
         playerOfferOwner = userInfo.username;
    } else if (type === "decline") {
         playerRequestOwner = userInfo.username;
         playerOfferOwner = offer.offerer;
    }

     const playerRequestData = {
         name: offer.playerRequest.name,
         image: offer.playerRequest.image,
         age: offer.playerRequest.age,
         position: offer.playerRequest.position,
         prefFoot: offer.playerRequest.prefFoot,
         owner: playerRequestOwner,
         ranking: offer.playerRequest.ranking,
         price: offer.playerRequest.price,
         available: true,
         forSale: offer.playerRequest.forSale
     };

     const playerOfferData = {
         name: offer.playerOffer.name,
         image: offer.playerOffer.image,
         age: offer.playerOffer.age,
         position: offer.playerOffer.position,
         prefFoot: offer.playerOffer.prefFoot,
         owner: playerOfferOwner,
         ranking: offer.playerOffer.ranking,
         price: offer.playerOffer.price,
         available: true,
         forSale: offer.playerOffer.forSale
     };

     await updatePlayer(offer.playerRequest._id, playerRequestData);

     await updatePlayer(offer.playerOffer._id, playerOfferData);

     window.location.reload();
}

const Offers = ({userInfo}) => {

    if (userInfo.offers === undefined) {
        return null;
    }

    if (userInfo.offers.length === 0) {
        return (
            <div className="section">
                <h2>Offers</h2>
                <p>There are no offers right now.</p>
            </div>
        );
    }

    return (
        <div className="section">
            <h2>Offers</h2>
            {userInfo.offers.map(o =>
                <Offer
                    key={o.playerRequest._id}
                    offerer={o.offerer}
                    playerRequest={o.playerRequest}
                    playerOffer={o.playerOffer}
                    handleAccept={() => handleOffer("accept", o, userInfo)}
                    handleDecline={() => handleOffer("decline", o, userInfo)}
                />
            )}
        </div>
    );
};

export default Offers;