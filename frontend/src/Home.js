import React, {Component} from 'react';
import {Navbar, NavbarBrand} from "reactstrap";
import {Link} from "react-router-dom";
import App from "./App";
import AppNavbar from "./AppNavbar";

class Home extends Component {
    render() {
        return (
            <div>
                <AppNavbar/>
                <Container>
                    Testing
                </Container>
            </div>
        )
    }
}

export default Home;