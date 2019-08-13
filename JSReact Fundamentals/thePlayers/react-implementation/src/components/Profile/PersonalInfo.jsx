import React from 'react';

const PersonalInfo = ({username, firstName, lastName, email, money, playersOwned}) => {
    return (
        <div className="section">
            <h2>Personal Information</h2>
            <table className="infoTable">
                <tbody>
                    <tr>
                        <td><b>Username:</b>&emsp;{username}</td>
                        <td><b>First name:</b>&emsp;{firstName}</td>
                        <td><b>Last name:</b>&emsp;{lastName}</td>
                    </tr>
                    <tr>
                        <td><b>Email:</b>&emsp;{email}</td>
                        <td><b>Money:</b>&emsp;{money}</td>
                        <td><b>Players owned:</b>&emsp;{playersOwned}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
};

export default PersonalInfo;