import React from 'react';

const Pokemon = props => (
    <div>
        <h2>{props.item.pokemonName}</h2>
        <p>{props.item.pokemonInfo}</p>
        <img src={props.item.pokemonImg} alt={props.item.pokemonName}/>
    </div>
);

export default Pokemon;