import React, {Component} from 'react';
import {Navbar, NavbarBrand} from "reactstrap";
import {Link} from "react-router-dom";

export default class AppNavbar extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <Navbar color="dark">
                <NavbarBrand tag={Link} to="/">Home</NavbarBrand>
            </Navbar>
        );
    }
}