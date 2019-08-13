import React, { Component } from 'react';
import Input from '../common/Input';
import {updateUser} from "../../services/userRemote";

export default class EditUser extends Component {
    constructor(props) {
        super(props);

        const {username, firstName, lastName, email, money} = this.props;

        this.state = {
            username: username,
            firstName: firstName,
            lastName: lastName,
            email: email,
            money: money,
            msg: '',
            editMode: false
        };

        this.handleChange = this.handleChange.bind(this);
        this.onEdit = this.onEdit.bind(this);
        this.onUpdate = this.onUpdate.bind(this);
    }

    handleChange(event) {
        event.preventDefault();
        this.setState({
            [event.target.name]: event.target.value,
            msg: ''
        });
    }

    onEdit() {
        this.setState({editMode: true});
    }

    async onUpdate() {
        this.setState({editMode: false});

        const { id, offers } = this.props;
        const userData = {
            username: this.state.username,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            email: this.state.email,
            money: this.state.money,
            offers: offers
        };

        await updateUser(id, userData)
            .then(response => {
                this.setState({
                    msg: response.msg
                });
            });
    }

    render() {

        return (
            <div className="userEdit">
                <div className="editUserForm">
                    <Input
                        name="username"
                        type="text"
                        value={this.state.username}
                        onChange={this.handleChange}
                        label="Username"
                        className="formAdmin"
                        classNameInput={this.state.editMode === true ? "" : "disabledInput"}
                    />
                    <Input
                        name="firstName"
                        type="text"
                        value={this.state.firstName}
                        onChange={this.handleChange}
                        label="First Name"
                        className="formAdmin"
                        classNameInput={this.state.editMode === true ? "" : "disabledInput"}
                    />
                    <Input
                        name="lastName"
                        type="text"
                        value={this.state.lastName}
                        onChange={this.handleChange}
                        label="Last Name"
                        className="formAdmin"
                        classNameInput={this.state.editMode === true ? "" : "disabledInput"}
                    />
                    <Input
                        name="email"
                        type="text"
                        value={this.state.email}
                        onChange={this.handleChange}
                        label="E-mail"
                        className="formAdmin"
                        classNameInput={this.state.editMode === true ? "" : "disabledInput"}
                    />
                    <Input
                        name="money"
                        type="text"
                        value={this.state.money}
                        onChange={this.handleChange}
                        label="Money"
                        className="formAdmin"
                        classNameInput={this.state.editMode === true ? "" : "disabledInput"}
                    />
                    <div className="editUserBtn">
                        <input type="button" value="Edit" onClick={this.onEdit} className={this.state.editMode === true ? "disabledBtn" : ""} />
                        <input type="button" value="Update" onClick={this.onUpdate} className={this.state.editMode === true ? "" : "disabledBtn"} />
                    </div>
                </div>
            </div>
        );
    }
}