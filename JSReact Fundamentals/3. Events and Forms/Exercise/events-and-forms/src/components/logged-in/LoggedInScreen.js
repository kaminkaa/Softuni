import React, { Component } from 'react';
import AddPokemonForm from './AddPokemonForm';
import Pokemon from './Pokemon';

class LoggedInScreen extends Component {
    constructor() {
        super();

        this.state = {
            pokemonsArray: []
        };

        this.updatePokedex = this.updatePokedex.bind(this);
    }

    updatePokedex(newPokedex) {
        this.setState({pokemonsArray: newPokedex});
    }

    componentDidMount() {
        fetch('http://localhost:5000/pokedex/pokedex')
            .then(rawData => rawData.json())
            .then(response => this.setState({pokemonsArray: response.pokemonColection}))
    }

    render() {
        return (
            <div>
                <AddPokemonForm updatePokedex={this.updatePokedex}/>
                {this.state.pokemonsArray.map((pokemon, index) => <Pokemon key={index} item={pokemon}/>)}
            </div>
        )
    }
}

export default LoggedInScreen;