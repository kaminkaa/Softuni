import React from 'react';
import '../../style/pagination.css';

const Pagination = ({pageCount, current, clickHandler}) => {

        const pages=[];

        for (let i = 1; i <= pageCount; i++) {
            pages.push((
                <li key={i} className="paginationLI">
                    <div className={`paginationLink${current === i ? ' activePage' : ''}`} onClick={() => clickHandler(i)}>{i}</div>
                </li>
            ));
        }

        return (
            <div className="pagination">
                <ul className="paginationUL">
                    <li className="paginationLI">
                        <div className={`paginationLink${current === 1 ? ' disabled' : ''}`} onClick={() => clickHandler(current - 1)}>«</div>
                    </li>
                    {pages}
                    <li className="paginationLI">
                        <div className={`paginationLink${current === pageCount ? ' disabled' : ''}`} onClick={() => clickHandler(current + 1)}>»</div>
                    </li>
                </ul>
            </div>
        );
};

export default Pagination;