import React from "react";
import axios from "axios";

class UserSignupPage extends React.Component {

    state = {
        username: null,
        displayName: null,
        password: null,
        passwordRepeat: null,
        agreedClicked: false
    }



    onChange = event => {
        // const value = event.target.value;
        // const name = event.target.name;
        const { name, value } = event.target;

        this.setState({
            [name]: value
        })
    }

    onChangeAgreed = event => {
        this.setState(
            { agreedClicked: event.target.checked }
        )
    }

    onClickSignup = event => {
        event.preventDefault();

        const body = {
            username: this.state.username,
            displayName: this.state.displayName,
            password: this.state.password
        };
        console.log(body)

        axios.post("/users/create", body)
    }

    onClickSayHello = event =>{
        event.preventDefault();

        axios.get("http://localhost:8080/api/hello")
    }

    render() {
        return (
            <form>
                <h1>Sign Up</h1>
                <div>
                    <label>Username</label>
                    <input name="username" onChange={
                        this.onChange
                    } />
                </div>

                <div>
                    <label>Display Name</label>
                    <input name="displayName" onChange={this.onChange} />
                </div>

                <div>
                    <label>Password</label>
                    <input name="password" type="password" />
                </div>
                <div>
                    <label>Password Repeat</label>
                    <input type="password" />
                </div>
                <div>
                    <input type="checkbox" onChange={this.onChangeAgreed} />
                </div>
                <button disabled={!this.state.agreedClicked} onClick={this.onClickSignup}>Sign Up</button>
                <button onClick={this.onClickSayHello}>Say Hello</button>
            </form>
        )
    }

}

export default UserSignupPage;