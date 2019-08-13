import React from 'react';

const UserInfo = ({username, firstName, lastName, playersOwned}) => {

    if(username === undefined || username === localStorage.getItem('username')) {
        return  (<p className="exchangeP">Select a user.</p>);
    }

    return (
        <div className="userInfo">
            <p><b>User info</b><br/>
            <b>Username:</b> {username}
            <b>&emsp; First name:</b> {firstName}
            <b>&emsp; Last name:</b> {lastName}<br/>
            <b>Players owned:</b> {playersOwned}</p>
        </div>
    );
};

export default UserInfo;