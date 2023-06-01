import React, {useState} from "react";
import '../Css/style.css'
import { Button } from "@mui/material";
import axios from "axios";

function SignInPage(){

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [repeatPassword, setRepeatPassword] = useState('');
    const [name, setName] = useState('');
    const [surname, setSurname] = useState('');

    async function handleRegistry(){

        if(/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(username) && password === repeatPassword){}

        const options = {
            method: 'POST',
            url: 'http://localhost:8080/signin',
            headers: {'Content-Type': 'application/json'},
            data: {
              email: username,
              password: password,
              firstName: name,
              lastName: surname,
              phone: " "
            }
          };

          axios.request(options)
          .then(function (response) {
            console.log(response.data.token);
            sessionStorage.setItem('token', response.data.token);
            window.location.href = '/login';
          })
          .catch(function (error) {
            console.log("Brak dostepu");
          });
      
    }


    return <div className = "container">
        <div className ="flowers">
            <img src = {require("../img/images/login-flowers.jpg")} alt = "flowers" />
        </div>
        <div className = "loginContainer">
            <div className = "loginPhoto">
                <a href = "welcomePage"> <img src = {require("../img/logo.svg")} alt = "marimay"/></a>
            </div>
            <div className ="login-container">
                <form className = "tmp">
                    Sign in
                    <input 
                        name = "name" 
                        type="text"
                        placeholder="name" 
                        value = {name}
                        onChange = {e => setName(e.target.value)}
                    />
                    <input 
                        name="surname" 
                        type="text" 
                        placeholder="surname" 
                        value = {surname}
                        onChange = {e => setSurname(e.target.value)}
                    />
                    <input 
                        name = "username" 
                        type="text" 
                        placeholder="e-mail" 
                        value = {username}
                        onChange = {e => setUsername(e.target.value)}
                        style = {{border:
                            !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(username) && username !== ""
                              ? "2px solid red"
                              : "none",
                        }}
                    />
                    <input
                        name = "password" 
                        type="password" 
                        placeholder="password" 
                        value = {password}
                        onChange = {e => setPassword(e.target.value)}
                    />
                    <input 
                        name = "passwordconfirm" 
                        type="password" 
                        placeholder="repeat password"
                        value = {repeatPassword}
                        onChange = {e => setRepeatPassword(e.target.value)}
                        style={{
                            border:
                              repeatPassword !== password && repeatPassword !== ""
                                ? "2px solid red"
                                : "none",
                          }}
                    />
                    <Button onClick = {handleRegistry}>Sign in</Button>
                </form>
            </div>
            <div className = "sigin">Already have an account?</div>
            <Button href = "/login" >Log in</Button>
        </div>
    </div>
}

export default SignInPage;