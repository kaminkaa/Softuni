import React from 'react';
import Username from './Username';

const Usernames = ({ usersUsernames, selectedUsername, setSelectedUsername }) => {
    const usernames = usersUsernames.filter(u => u.username !== localStorage.getItem("username") && u.username !== 'admin');

    return (
        <div className="usernames">
            {usernames.map(u => {
                return (
                    <Username
                        key={u._id}
                        selected={u.username === selectedUsername}
                        username={u.username}
                        onClick={() => setSelectedUsername(u.username)}
                    />
                )
            })}
        </div>
    );
};

export default Usernames;