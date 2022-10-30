import React, { Component } from 'react';
import AccountService from '../services/AccountService';

class CreateAccountComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            name: '',
            userid: '',
            pin: '',
            amount: ''
        }
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeUseridHandler = this.changeUseridHandler.bind(this);
        this.changePinHandler = this.changePinHandler.bind(this);
        this.changeAmountHandler = this.changeAmountHandler.bind(this);
        this.registerAccount = this.registerAccount.bind(this);
    }

    changeNameHandler = (event) => {
        this.setState({name: event.target.value});
    }
    changeUseridHandler = (event) => {
        this.setState({userid: event.target.value});
    }
    changePinHandler = (event) => {
        this.setState({pin: event.target.value});
    }
    changeAmountHandler = (event) => {
        this.setState({amount: event.target.value});
    }

    registerAccount = (e) => {
        e.preventDefault();
        let account = {name: this.state.name, userid: this.state.userid, pin: this.state.pin, amount: this.state.amount};
        console.log('account ==> ' + JSON.stringify(account));
        AccountService.createAccount(account).then(res => {
            this.props.history.push('/accounts');
        });
    }

    cancel() {
        this.props.history.push("/accounts");
    }

    render() {
        return (
            <div>
                <div className='container'>
                    <div className='row'>
                        <div className='card col-md-6 offset-md-3 offset md-3'></div>
                        <h3 className='text-center'>create an account</h3>
                        <div className='card-body'>
                            <form action="">
                                <div className='form-group'>
                                    <label>name</label>
                                    <input placeholder='name' name='name' className='form-control' 
                                        value={this.state.name} onChange={this.changeNameHandler}/>
                                </div>
                                <div className='form-group'>
                                    <label>userid</label>
                                    <input placeholder='userid' name='userid' className='form-control' 
                                        value={this.state.userid} onChange={this.changeUseridHandler}/>
                                </div>
                                <div className='form-group'>
                                    <label>pin/password</label>
                                    <input placeholder='pin' name='pin' className='form-control' 
                                        value={this.state.pin} onChange={this.changePinHandler}/>
                                </div>
                                <div className='form-group'>
                                    <label>amount</label>
                                    <input placeholder='amount' name='amount' className='form-control' 
                                        value={this.state.amount} onChange={this.changeAmountHandler}/>
                                </div>
                                <button className='btn btn-success' onClick={this.registerAccount}>register</button>
                                <button className='btn btn-danger' onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>cancel registration and go back</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default CreateAccountComponent;