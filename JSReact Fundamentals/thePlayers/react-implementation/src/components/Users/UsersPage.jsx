import React, { Component } from 'react';
import '../../style/users.css';
import EditUser from './EditUser';
import Pagination from '../common/Pagination';

import { fetchUsersCountAction, fetchUsersPerPageAction } from '../../actions/usersActions';
import { connect } from 'react-redux';

class UsersPage extends Component {
    constructor(props) {
        super(props);

        this.state = { page: 1};

        this.onPageClick = this.onPageClick.bind(this);
    }

    onPageClick(page) {
        this.setState({page});
        this.props.fetchUsersPerPage(page, 6);
    }

    componentWillMount() {
        this.props.fetchUsersPerPage(this.state.page, 6);
        this.props.fetchUsersCount();
    }

    render() {
        const { usersCount, usersPerPage } = this.props;
        const pageCount = Math.ceil((usersCount) / 6);

        return (
            <div className="container">
                <h1>Users</h1>
                <div className="usersWrapper">
                    {usersPerPage.map(u =>
                        <EditUser
                            key={u._id}
                            id={u._id}
                            username={u.username}
                            firstName={u.firstName}
                            lastName={u.lastName}
                            email={u.email}
                            money={u.money}
                            offers={u.offers}
                        />
                    )}
                </div>
                { pageCount > 1 ? <Pagination pageCount={pageCount} current={this.state.page} clickHandler={this.onPageClick}/> : null }
            </div>
        );
    }
}

function mapStateToProps(state) {
    const { usersCount, usersPerPage } = state.users;

    return {
        usersCount: usersCount,
        usersPerPage: usersPerPage
    };
}

function mapDispatchToProps(dispatch) {
    return {
        fetchUsersCount: () => dispatch(fetchUsersCountAction()),
        fetchUsersPerPage: (page, count) => dispatch(fetchUsersPerPageAction(page, count))
    };
}

export default  connect(mapStateToProps, mapDispatchToProps)(UsersPage);

