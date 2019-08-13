import React from 'react';
import '../../style/regSuccess.css';

const RegSuccess = () => {
        return (
            <div className="container">
                <h3>Thank you for your registration!</h3>
                <div className="regSuccess">
                    <p>You can now visit our <a className="regSuccessLink" href={'/buy'}><b>Players Catalogue</b></a>.</p>
                </div>
                <img className="regSuccessImg" src={require('../../images/6.jpg')} alt=""/>
            </div>
        );
};

export default RegSuccess;