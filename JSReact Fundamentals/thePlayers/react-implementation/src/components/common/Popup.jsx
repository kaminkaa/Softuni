import React from 'react';

const Popup = ({handleClose, message}) => (
    <div className="popup">
        <div className="popupInner">
            <div onClick={handleClose}><span className="close" role="img" aria-label="close">&#10062;</span></div>
            <h3 className="popupMsg">{message}.</h3>
        </div>
    </div>
);

export default Popup;