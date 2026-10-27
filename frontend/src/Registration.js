import React, {Component} from 'react';
import AppNavbar from "./AppNavbar";
import {Link} from 'react-router-dom';
import {Button, Container, Form, FormGroup, Input, Label} from "reactstrap";

class Registration extends Component {

    constructor(props) {
        super(props);

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {

    }

    async handleSubmit(event) {
        //TODO
    }

    render() {
        return (
            <div>
                <AppNavbar/>
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="first-name">First Name</Label>
                        <Input type="text" name="first-name" id="first-name" value={''} onChange={this.handleChange}></Input>
                    </FormGroup>
                    <FormGroup>
                        <Label for="last-name">Last Name</Label>
                        <Input type="text" name="last-name" id="last-name" value={''} onChange={this.handleChange}></Input>
                    </FormGroup>
                    <FormGroup>
                        <Label for="email">Email</Label>
                        <Input type="email" name="email" id="email" value={''} onChange={this.handleChange}></Input>
                    </FormGroup>
                    <FormGroup>
                        <Label for="username">Username</Label>
                        <Input type="text" name="username" id="username" value={''} onChange={this.handleChange}></Input>
                    </FormGroup>
                    <FormGroup>
                        <Label for="password">Password</Label>
                        <Input type="password" name="password" id="password" value={''} onChange={this.handleChange}></Input>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/">Cancel</Button>
                    </FormGroup>
                </Form>
            </div>
        )
    }
}

export default Registration;