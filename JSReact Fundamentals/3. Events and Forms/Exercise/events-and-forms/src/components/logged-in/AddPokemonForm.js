import React, { Component } from 'react';

class AddPokemonForm extends Component {
    constructor() {
        super();

        this.state = {
            form: {}
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        event.preventDefault();
        const name = event.target.dataset.name;
        const value = event.target.value;
        const formInput = {};

        formInput[name] = value;
        console.log(name, value);

        this.setState({
            form: Object.assign(this.state.form, formInput)
        });
    }

    handleSubmit() {
        fetch('http://localhost:5000/pokedex/create', {
            method: 'POST',
            body: JSON.stringify(this.state.form),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(data => data.json())
            .then(response => {
                this.props.updatePokedex(response);
            })
            .catch(err => console.log(err))
    }

    render() {
        return (
            <form>
                <h2>Create Pokemon</h2>
                <div className="form-group">
                    <label>Pokemon name</label>
                    <input data-name="pokemonName" type="text" onChange={this.handleChange} className="form-control" id="input-pokemonName"  placeholder="Enter pokemon name"/>
                </div>
                <div className="form-group">
                    <label>Pokemon Image</label>
                    <input data-name="pokemonImg" type="text" onChange={this.handleChange} className="form-control" id="input-pokemonImg" placeholder="Select a pokemon image"/>
                </div>
                <div className="form-group">
                    <label>Pokemon Info</label>
                    <input data-name="pokemonInfo" type="text" onChange={this.handleChange} className="form-control" id="input-pokemonInfo" placeholder="Add info"/>
                </div>
                <button type="button" onClick={this.handleSubmit} className="btn btn-primary">Submit</button>
            </form>
        )
    }
}

export default AddPokemonForm;