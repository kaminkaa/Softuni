import React from 'react';

const Offer = ({offerer, playerRequest, playerOffer, handleAccept, handleDecline}) => {
    return (
        <div className="offer">
            <h3>Offer from {offerer}</h3>
            <p><b>Player requested:</b> {playerRequest.name}</p>
            <p><b>Player offered:</b> {playerOffer.name}</p>
            <span onClick={handleAccept} className="emojis">&#10004;</span>
            <span onClick={handleDecline} className="emojis">&#10006;</span>
        </div>
    );
};

export default Offer;