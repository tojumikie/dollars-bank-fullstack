import React, { Component } from 'react';

class HeaderComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {

        }
    }

    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-light bg-light"> 
                        <div><a href="" className="navbar-brand">dollars bank app</a></div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default HeaderComponent;