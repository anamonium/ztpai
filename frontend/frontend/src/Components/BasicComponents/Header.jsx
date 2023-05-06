import React from "react";
import PersonIcon from '@mui/icons-material/Person';
import MenuIcon from '@mui/icons-material/Menu';
import { Button } from "@mui/material";

function Header(props){

    return <header>
        <div class = "pasek">
            <Button 
                onClick = {props.hideNav}
                size="small"
                variant="elevated"
                style={{ width: "30px" }}
                disableElevation
            ><MenuIcon 
                fontSize="large"
            /></Button>
            <img id = "logo" src = {require("../../img/logo.svg")} alt = "Marimay" />
            <Button 
                href = "/account" 
                variant="elevated"
            ><PersonIcon 
                fontSize="large"
            /></Button>
        </div>
    </header>
}

export default Header;