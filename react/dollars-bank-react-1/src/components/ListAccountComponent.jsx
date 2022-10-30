import React, { Component } from 'react';
import AccountService from '../services/AccountService';

class ListAccountComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            accounts: []
        }
        this.register = this.register.bind(this);
    }

    componentDidMount() {
        AccountService.getAccounts().then((res) => {
            this.setState({ accounts: res.data });
        });
    }

    register() {
        this.props.history.push("/register")
    }

    render() {
        return (
            <div>
                <h2 className="text-center">List of Bank Accounts</h2>
                <div className="row">
                    <button className="btn btn-primary" onClick={this.register}> Link to create an account</button>
                </div>
                <div className = "row">
                    <table className='table table-striped table-bordered'>
                        <thead>
                            <tr>
                                <th>Account ID #</th>
                                <th>Account Name</th>
                                <th>Account UserID</th>
                                <th>Account PIN/Password</th>
                                <th>Account Amount</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.accounts.map(
                                    account =>
                                    <tr key = {account.id}>
                                        <td> {account.id} </td>
                                        <td> {account.name} </td>
                                        <td> {account.userid} </td>
                                        <td> {account.pin} </td>
                                        <td> {account.amount} </td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default ListAccountComponent;