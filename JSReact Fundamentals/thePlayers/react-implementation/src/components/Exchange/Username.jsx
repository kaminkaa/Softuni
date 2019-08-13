import React from 'react';

const Username = ({ username, selected, onClick }) => {
    let className = 'usernameBox';
    if (selected) {
        className += ' activeUsername';
    }

    return (
        <div className={className} onClick={onClick}>
            <span className="usernameText">{username}</span>
        </div>
    );
};

export default Username;