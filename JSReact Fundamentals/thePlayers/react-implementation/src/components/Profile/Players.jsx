import React from 'react';

const Players = ({players}) => {

    if (players === undefined) {
        return null;
    }

    if (players.length === 0) {
        return (
            <div className="section">
                <h2>Players</h2>
                <p>No players are bought yet.</p>
            </div>
        );
    }

    let rows = [];

    for (let i = 0; i < players.length; i+=4) {
        let col = [];
        col.push(players[i]);
        col.push(players[i+1]);
        col.push(players[i+2]);
        col.push(players[i+3]);

        rows.push(col);
    }
    return (
        <div className="section">
            <h2>Players</h2>
            <table className="playersTable">
                <tbody>
                    {rows.map( (r, index) => {
                        return (
                            <tr key={index}>
                                {r.map(c => {
                                    if (c === undefined) {
                                        return null;
                                    }

                                    return (
                                        <td key={c._id}><span role="img" aria-label="football">&#9917;</span> {c.name}</td>
                                    );
                                })}
                            </tr>
                        );
                    })}
                </tbody>
            </table>
        </div>
    );
};

export default Players;