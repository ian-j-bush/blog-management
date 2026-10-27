import './App.css';
import {Component} from "react";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import Home from "./Home";

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route exact={true} path="/" component={Home}/>
          </Switch>
        </Router>
    )
  }
}

export default App;
