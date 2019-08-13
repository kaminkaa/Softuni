import React, { Component } from 'react';
import Input from '../common/Input';
import {addPlayer} from "../../services/playersRemote";

export default class AddPlayer extends Component {
    constructor(props) {
        super(props);

        this.state = {
            name: '',
            image: '',
            age: '',
            position: '',
            prefFoot: '',
            owner: '',
            ranking: '',
            price: '',
            msg: ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.onAdd = this.onAdd.bind(this);
    }

    handleChange(event) {
        event.preventDefault();
        this.setState({
            [event.target.name]: event.target.value,
            msg: ''
        });

        /* const target = event.target;
         const prop = target.name;
         const value = target.value;
         const newState = {};
         newState[prop] = value;
         this.setState(newState); */
    }

    async onAdd() {
        let playerData = {
            name: this.state.name,
            image: this.state.image,
            age: this.state.age,
            position: this.state.position,
            prefFoot: this.state.prefFoot,
            owner: this.state.owner,
            ranking: this.state.ranking,
            price: this.state.price,
            available: true,
            forSale: true
        };

        await addPlayer(playerData)
            .then(response => {
                this.setState({
                    msg: response.msg
                });
            });

        this.setState({ name: '', image: '', age: '', position: '', prefFoot: '', owner: '', ranking: '', price: '', msg: '' });
        window.location.reload();
    }

    render() {
        return (
            <div className="playerAdd">
                <div className="addPlayerForm">
                    <Input
                        name="name"
                        type="text"
                        value={this.state.name}
                        onChange={this.handleChange}
                        label="Name"
                        className="formAdmin"
                    />
                    <Input
                        name="image"
                        type="text"
                        value={this.state.image}
                        onChange={this.handleChange}
                        label="Image"
                        className="formAdmin"
                    />
                    <Input
                        name="age"
                        type="number"
                        value={this.state.age}
                        onChange={this.handleChange}
                        label="Age"
                        className="formAdmin"
                    />
                    <Input
                        name="position"
                        type="text"
                        value={this.state.position}
                        onChange={this.handleChange}
                        label="Position"
                        className="formAdmin"
                    />
                    <Input
                        name="prefFoot"
                        type="text"
                        value={this.state.prefFoot}
                        onChange={this.handleChange}
                        label="Pref. Foot"
                        className="formAdmin"
                    />
                    <Input
                        name="owner"
                        type="text"
                        value={this.state.owner}
                        onChange={this.handleChange}
                        label="Owner"
                        className="formAdmin"
                    />
                    <Input
                        name="ranking"
                        type="number"
                        value={this.state.ranking}
                        onChange={this.handleChange}
                        label="Ranking"
                        className="formAdmin"
                    />
                    <Input
                        name="price"
                        type="number"
                        value={this.state.price}
                        onChange={this.handleChange}
                        label="Price"
                        className="formAdmin"
                    />
                    <div className="addPlayerBtn">
                        <input type="button" value="Add" onClick={this.onAdd}/>
                    </div>
                </div>
            </div>
        );
    }
}