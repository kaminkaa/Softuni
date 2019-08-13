import React, { Component } from 'react';
import Input from '../common/Input';
import { updatePlayer, deletePlayer } from "../../services/playersRemote";

export default class EditPlayer extends Component {
    constructor(props) {
        super(props);

        const { name, image, age, position, prefFoot, owner, ranking, price } = this.props;

        this.state = {
            name: name,
            image: image,
            age: age,
            position: position,
            prefFoot: prefFoot,
            owner: owner,
            ranking: ranking,
            price: price,
            editMode: false
        };

        this.handleChange = this.handleChange.bind(this);
        this.onEdit = this.onEdit.bind(this);
        this.onUpdate = this.onUpdate.bind(this);
        this.onDelete = this.onDelete.bind(this);
    }

    handleChange(event) {
        event.preventDefault();
        this.setState({[event.target.name]: event.target.value});
    }

    onEdit() {
        this.setState({editMode: true});
    }

    async onUpdate() {
        this.setState({editMode: false});

        const { id, available, forSale } = this.props;
        const playerData = {
            name: this.state.name,
            image: this.state.image,
            age: this.state.age,
            position: this.state.position,
            prefFoot: this.state.prefFoot,
            owner: this.state.owner,
            ranking: this.state.ranking,
            price: this.state.price,
            available: available,
            forSale: forSale
        };

        await updatePlayer(id, playerData);
    }

    async onDelete() {
        const { id } = this.props;

        await deletePlayer(id);

        window.location.reload();
    }

    render() {

        return (
            <div className="playerEdit">
                <div className="editPlayerForm">
                    <Input
                        name="name"
                        type="text"
                        value={this.state.name}
                        onChange={this.handleChange}
                        label="Name"
                        className="formAdmin"
                        classNameInput={this.state.editMode === true ? "" : "disabledInput"}
                    />
                    <Input
                        name="image"
                        type="text"
                        value={this.state.image}
                        onChange={this.handleChange}
                        label="Image"
                        className="formAdmin"
                        classNameInput={this.state.editMode === true ? "" : "disabledInput"}
                    />
                    <Input
                        name="age"
                        type="number"
                        value={this.state.age}
                        onChange={this.handleChange}
                        label="Age"
                        className="formAdmin"
                        classNameInput={this.state.editMode === true ? "" : "disabledInput"}
                    />
                    <Input
                        name="position"
                        type="text"
                        value={this.state.position}
                        onChange={this.handleChange}
                        label="Position"
                        className="formAdmin"
                        classNameInput={this.state.editMode === true ? "" : "disabledInput"}
                    />
                    <Input
                        name="prefFoot"
                        type="text"
                        value={this.state.prefFoot}
                        onChange={this.handleChange}
                        label="Pref. Foot"
                        className="formAdmin"
                        classNameInput={this.state.editMode === true ? "" : "disabledInput"}
                    />
                    <Input
                        name="owner"
                        type="text"
                        value={this.state.owner}
                        onChange={this.handleChange}
                        label="Owner"
                        className="formAdmin"
                        classNameInput={this.state.editMode === true ? "" : "disabledInput"}
                    />
                    <Input
                        name="ranking"
                        type="number"
                        value={this.state.ranking}
                        onChange={this.handleChange}
                        label="Ranking"
                        className="formAdmin"
                        classNameInput={this.state.editMode === true ? "" : "disabledInput"}
                    />
                    <Input
                        name="price"
                        type="number"
                        value={this.state.price}
                        onChange={this.handleChange}
                        label="Price"
                        className="formAdmin"
                        classNameInput={this.state.editMode === true ? "" : "disabledInput"}
                    />
                    <div className="addPlayerBtn">
                        <input type="button" value="Edit" onClick={this.onEdit} className={this.state.editMode === true ? "disabledBtn" : ""}/>
                        <input type="button" value="Update" onClick={this.onUpdate} className={this.state.editMode === true ? "" : "disabledBtn"} />
                        <input type="button" value="Delete" onClick={this.onDelete} />
                    </div>
                </div>
            </div>
        );
    }
}