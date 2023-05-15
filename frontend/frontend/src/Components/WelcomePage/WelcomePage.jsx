import React from "react";
import '../../Css/welcomePage.css'
import PeopleAltIcon from '@mui/icons-material/PeopleAlt';
import AttachMoneyIcon from '@mui/icons-material/AttachMoney';
import ChecklistIcon from '@mui/icons-material/Checklist';
import SummarizeIcon from '@mui/icons-material/Summarize';
import { Button } from "@mui/material";


function WelcomePage(){

    
    return <div>
        <div className = "topBar">
            <div>
                <img src = {require("../../img/logo.svg")} alt = "logo"/>
            </div>
            <div className = "buttons">
                <Button 
                    id = "signIn" 
                    href="/signin"
                    variant="contained"
                >Sign in</Button>
                <Button 
                    id = "logIn"
                    href = "/login"
                    variant="outlined"
                
                >Log in</Button>
            </div>
        </div>
        <div className = "mainPicture">
            <div className = "info">
                <h1>Online Wedding Planner</h1>
                <h3 id = "longNapis">With our wedding planner you do not have to worry about frogetting anything. We will remember everything for you.
                    All for free!</h3>
            </div>
            <div className = "pictures">
                <div id = "rectangle"></div>
                <img id = "dots" src = {require("../../img/images/dots.png")} alt = "dots" />
                <img id = "fls" src = {require("../../img/images/login-flowers.jpg")}  alt = "flowers" />
            </div>
        </div>
        <h2 id = "setOfTools">A unique set of tools we offer you </h2>
        <div className = "icons">
            
                <div>
                    <div className = "header">
                        <PeopleAltIcon />
                        <h4>Managing 
                            guestlist</h4>
                    </div>
                        <p>With this tool you will be able to
                            create a comprehensive wedding
                            guest list including attendance,
                            a plus one, dietary preferences.</p>
                    
                </div>
                <div>
                    <div className = "header">
                        <ChecklistIcon />
                        <h4>Personalised
                            checklists</h4>
                    </div>
                    <p>We offer you a set of checklist so 
                        you will not forget about anything. 
                        It will help you to keep track of 
                        tasks that need to be taken care of. </p>
                </div>
    
                <div>
                    <div className = "header">
                        <AttachMoneyIcon />
                        <h4>Managing 
                            your budget</h4>
                    </div>
                    <p>Keep track of the all the essential 
                        costs in order to stop you from 
                        spencding more than you should. </p>
                </div>
                <div>
                    <div className = "header">
                        <SummarizeIcon />
                        <h4>Overview </h4>
                    </div>
                    <p>On a main page you will be able 
                        to read an overview of all the 
                        wedding details. </p>
                    </div>
            
        </div>
        <div className = "endSection">
            <img id = "roses" src = {require("../../img/images/roses.png")}  alt = "roses"/>
            <h2>Join us now!</h2>
            <h3>No hidden costs.
                Everything is for free!</h3>
            <Button 
                id = "logIn"
                href = "/signin"
                variant="contained"
            >Sign in</Button>
        </div>
    </div>
}

export default WelcomePage;