import React, {useState} from "react";
import { Link } from "react-router-dom";
import '../Css/style.css'
import { Button } from "@mui/material";
import axios from 'axios';

function LoginPage(){

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [noAccess, setNoAccess] = useState('');

    async function handleLogin(){

        const options = {
            method: 'POST',
            url: 'http://localhost:8080/login',
            headers: {'Content-Type': 'application/json'},
            data: {
              email: username,
              password: password
            }
          };

          axios.request(options)
          .then(function (response) {
            console.log(response.data.token);
            sessionStorage.setItem('token', response.data.token);
            window.location.href = '/overview';
          })
          .catch(function (error) {
            setNoAccess("Wrong login or password");
          });
      
    }


  return  <div className = "container">
                <div className="flowers">
                    <img src = {require("../img/images/login-flowers.jpg")} alt = "flowers"/>
                </div>
        <div className = "loginContainer">
            <div className = "loginPhoto">
                <Link to = "/"><img src = {require("../img/logo.svg")} alt = "marimay"/></Link>
            </div>
            <form className="tmp">
                Log in
                
                <div>{noAccess}</div>
                <input 
                    name = "email" 
                    type="text" 
                    placeholder="e-mail"
                    value = {username}
                    onChange = {e => setUsername(e.target.value)}
                />
                <input 
                    name = "password" 
                    type="password" 
                    placeholder="password" 
                    value = {password}
                    onChange = {e => setPassword(e.target.value)}
                />
                <Button onClick = {handleLogin}>Log in</Button>
            </form>
            <div className="sigin">Don't have an account?</div>
            <Button href = "/signin" className = "sButt">Sign in</Button>
        </div>
    </div>
}

export default LoginPage;