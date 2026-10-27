import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import Home from "./Home";
import Registration from "./Registration";

class App extends Component {

  render() {
    return (
        <Router>
          <Routes>
            <Route exact={true} path="/" element={<Home/>}/>
              <Route exact={true} path="/register" element={<Registration/>}/>
          </Routes>
        </Router>
    )
  }
}

export default App;
