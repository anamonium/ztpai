import React from "react";
import PersonIcon from '@mui/icons-material/Person';
import MenuIcon from '@mui/icons-material/Menu';

function Header(){
    return <header>
        <div class = "pasek">
            <a href =" "><MenuIcon /></a>
            <img id = "logo" src = {require("../../img/logo.svg")} alt = "Marimay" />
            <a href = " "><PersonIcon /></a>
        </div>
    </header>
}

export default Header;