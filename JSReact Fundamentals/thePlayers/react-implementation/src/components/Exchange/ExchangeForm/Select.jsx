import React from 'react';

const Select = ({players, handleChange}) => {

    if (players.length === 0) {
        return (
            <select>
                <option>---</option>
            </select>
        )
    }

    return (
            <select onChange={handleChange}>
                <option defaultValue hidden> </option>
                {players.map(p => {
                    if (p.available) {
                        return (
                            <option key={p._id} value={p.name}>{p.name}</option>
                        );
                    }
                    return null;
                })}
            </select>
        );
};

export default Select;