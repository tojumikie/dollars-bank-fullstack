import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ListAccountComponent from './components/ListAccountComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';

function App() {
  return (
    <div>
      <Router>
          <HeaderComponent />
          <div className="container">
            <Switch>
              <Route path="/" component={ListAccountComponent}></Route>
              <Route path="/accounts" component={ListAccountComponent}></Route>
              <ListAccountComponent />
            </Switch>
          </div>
          <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
