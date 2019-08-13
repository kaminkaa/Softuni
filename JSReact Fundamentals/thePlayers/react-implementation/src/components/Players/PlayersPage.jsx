import React, { Component } from 'react';
import '../../style/players.css';
import AddPlayer from './AddPlayer';
import EditPlayer from './EditPlayer';
import Pagination from '../common/Pagination';

import { fetchPlayersCountAction, fetchPlayersPerPageAction } from '../../actions/playersActions';
import { connect } from 'react-redux';

class PlayersPage extends Component {
    constructor(props) {
        super(props);

        this.state = { page: 1};

        this.onPageClick = this.onPageClick.bind(this);
    }

    onPageClick(page) {
        this.setState({page});
        this.props.fetchPlayers(page, 5);
    }

    componentWillMount() {
        this.props.fetchPlayers(this.state.page, 5);
        this.props.fetchPlayersCount();
    }

    render() {
        const { players, playersCount } = this.props;
        const playersPerPage = 5;
        const pageCount = Math.ceil(playersCount / playersPerPage);

        if (players === undefined) {
            return null;
        }

        return (
            <div className="container">
                <h1>Players</h1>
                <div className="playersWrapper">
                    <AddPlayer />
                    {players.map(p =>
                        <EditPlayer
                            key={p._id}
                            id={p._id}
                            name={p.name}
                            image={p.image}
                            age={p.age}
                            position={p.position}
                            prefFoot={p.prefFoot}
                            owner={p.owner}
                            ranking={p.ranking}
                            price={p.price}
                            available={p.available}
                            forSale={p.forSale}
                        />)}
                </div>
                { pageCount > 1 ? <Pagination pageCount={pageCount} current={this.state.page} clickHandler={this.onPageClick}/> : null }
            </div>
        );
    }
}

function mapStateToProps(state) {
    const { playersCount, players } = state.players;

    return {
        players: players,
        playersCount: playersCount
    };
}

function mapDispatchToProps(dispatch) {
    return {
        fetchPlayers: (page, count) => dispatch(fetchPlayersPerPageAction(page, count)),
        fetchPlayersCount: () => dispatch(fetchPlayersCountAction())
    };
}

export default connect(mapStateToProps, mapDispatchToProps)(PlayersPage);