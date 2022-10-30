import React, { Component } from 'react';

class FooterComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {

        }
    }

    render() {
        return (
            <div>
                <footer className='footer'>
                    <span className='text-warning'>created by toju mikie</span>
                </footer>
            </div>
        );
    }
}

export default FooterComponent;