import React from "react";
import NavListItem from "./NavListItem";
import SummarizeIcon from '@mui/icons-material/Summarize';
import ChecklistIcon from '@mui/icons-material/Checklist';
import AttachMoneyIcon from '@mui/icons-material/AttachMoney';
import PeopleAltIcon from '@mui/icons-material/PeopleAlt';


function Navigation(){

    return <nav className = "menuBar">
        <img id = "flowers" src = {require("../../img/images/login-flowers-kopia.png")} alt = "Flowers"></img>
        <ul>
            <NavListItem  link = "/overview" name = "Overview" icon = {<SummarizeIcon />} />
            <NavListItem  link = "/checklist" name = "Checklist" icon = {<ChecklistIcon />} />
            <NavListItem  link = "/budget" name = "Budget" icon = {<AttachMoneyIcon />} />
            <NavListItem  link = "/guestlist" name = "Guest list" icon = {<PeopleAltIcon />} />
        </ul>

    </nav>

}

export default Navigation;