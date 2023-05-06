import React from "react";
import EditIcon from '@mui/icons-material/Edit';
import PersonIcon from '@mui/icons-material/Person';


function Account(props){

    function logOut(){
        sessionStorage.setItem('token', null);
        console.log("Tok:" + sessionStorage.getItem('token'));
    }

    return <div class = "accou" id = "acc">
        <div class = "userDetail"s>
            <PersonIcon />
            {props.name}
        </div>
        <div class = "budgetChanger">
            Beginning budget:
            <span id = "budgetText">{props.beginningBudget}</span>

            <EditIcon />
        </div>
        <div class = "weddingDateChanger">
            Wedding date:
            <span id = "weddingText">
                {
                    props.date != null ? 
                        <div class="overInfo">{props.date}</div> : 
                        <div class="overInfo">Your wedding date is not set yet.</div>
                }
            </span>
            <EditIcon />
        </div>
        <div class = "logOut">
            <button id = "logOutButton" type = "submit" onClick={logOut}>Log out</button>
        </div>
    </div>
}

export default Account;