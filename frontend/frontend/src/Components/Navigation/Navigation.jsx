import React from "react";
import NavListItem from "./NavListItem";
import SummarizeIcon from '@mui/icons-material/Summarize';
import ChecklistIcon from '@mui/icons-material/Checklist';
import AttachMoneyIcon from '@mui/icons-material/AttachMoney';
import PeopleAltIcon from '@mui/icons-material/PeopleAlt';
import StorefrontIcon from '@mui/icons-material/Storefront';



function Navigation(){

    return <nav className = "menuBar">
        <img id = "flowers" src = {require("./img/images/login-flowers-kopia.png")} alt = "Flowers"></img>
        <ul>
            <NavListItem  name = "Overview" icon = {<SummarizeIcon />} />
            <NavListItem  name = "Checklist" icon = {<ChecklistIcon />} />
            <NavListItem  name = "Budget" icon = {<AttachMoneyIcon />} />
            <NavListItem  name = "Guest list" icon = {<PeopleAltIcon />} />
            <NavListItem  name = "Vendors" icon = {<StorefrontIcon />} />
        </ul>

    </nav>

}

export default Navigation;