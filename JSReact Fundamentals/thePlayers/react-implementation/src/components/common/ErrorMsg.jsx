import React from 'react';

const ErrorMsg = ({errorMsg}) => {

        if (errorMsg !== '') {
            return (
                <div className="formErrorMsg">{errorMsg}</div>
            );
        }

        return null;
};

export default ErrorMsg;