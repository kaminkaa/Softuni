import React from 'react';

const PlayersOwned = ({players, username}) => {

    if (username === undefined || players === undefined || username === localStorage.getItem('username')) {
        return null;
    }

    const availablePlayers = players.filter((p) => p.available === true);

    if (availablePlayers.length === 0) {
        return (
            <div className="playersOwned">
                <p>The user doesn't own any players or doesn't have any available ones at the moment.</p>
            </div>
        );
    } else {
        return (
            <div className="playersOwned">
                <b>Available Players Owned by {username}</b><br/>
                {availablePlayers.map(p => {
                    return (
                        <a key={p._id} href={'/player/' + p._id}>
                            <p className="players"><span role="img" aria-label="football">&#9917;</span> <i>{p.name}</i></p>
                        </a>
                    )
                })}
            </div>
        );
    }
};

export default PlayersOwned;