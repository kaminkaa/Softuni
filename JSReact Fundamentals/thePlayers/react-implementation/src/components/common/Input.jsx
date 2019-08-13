import React from 'react';

const Input = ({ name, type, value, onChange, label, className, classNameInput }) => {

        return (
            <div className={className}>
                <label>{label}</label>
                <input
                    onChange={onChange}
                    name={name}
                    id={name}
                    type={type}
                    value={value}
                    className={classNameInput}
                />
            </div>
        );
};

export default Input;

