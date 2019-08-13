import React from 'react';

const Button = ({btnEnabled, handleSubmit}) => {

    if (btnEnabled) {
        return (
            <button  onClick={handleSubmit}>Make an offer</button>
        );
    }

    return (
        <button disabled="true">Make an offer</button>
    );

};

export default Button;