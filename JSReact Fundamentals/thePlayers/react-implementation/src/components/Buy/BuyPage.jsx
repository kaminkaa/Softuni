import React, { Component } from 'react';
import '../../style/buy.css';
import '../../style/popup.css';
import PlayersForSale from './PlayersForSale';
import Pagination from '../common/Pagination';

import { fetchPlayersForSaleCountAction, fetchPlayersForSalePerPageAction } from '../../actions/playersActions';
import { fetchUserInfoAction } from '../../actions/usersActions';
import { connect } from 'react-redux';

class BuyPage extends Component {
    constructor(props) {
        super(props);

        this.state = {
            page: 1,
            showPopup: false,
            popupMessage: ""
        };

        this.onPageClick = this.onPageClick.bind(this);
        this.togglePopup = this.togglePopup.bind(this);
    }

    onPageClick(page) {
        this.setState({page});
        this.props.fetchPlayersForSale(page);
    }

    togglePopup() {
        this.setState({ showPopup: !this.state.showPopup });
    }

    componentWillMount() {
        this.props.fetchPlayersForSale(this.state.page);
        this.props.fetchPlayersCount();
        this.props.fetchUserInfo();
    }

    render() {
        const { playersForSale, playersCount, userInfo } = this.props;
        const playersPerPage = 6;
        const pageCount = Math.ceil(playersCount / playersPerPage);

        return (
            <div className="container">
                <h1>Players Catalogue</h1>
                <div className="field">
                    <PlayersForSale players={playersForSale} userInfo={userInfo}/>
                </div>
                { pageCount > 1 ? <Pagination pageCount={pageCount} current={this.state.page} clickHandler={this.onPageClick}/> : null }
            </div>
        );
    }
}

function mapStateToProps(state) {
    const { playersForSale, playersForSaleCount, playerInfo } = state.players;
    const { userInfo } = state.users;

    return {
        playersForSale: playersForSale,
        playersCount: playersForSaleCount,
        playerInfo: playerInfo,
        userInfo: userInfo
    };
}

function mapDispatchToProps(dispatch) {
    return {
        fetchPlayersForSale: (page) => dispatch(fetchPlayersForSalePerPageAction(page)),
        fetchPlayersCount: () => dispatch(fetchPlayersForSaleCountAction()),
        fetchUserInfo: () => dispatch(fetchUserInfoAction(localStorage.getItem("username")))
    };
}

export default connect(mapStateToProps, mapDispatchToProps)(BuyPage);