import React from "react";
import { Link } from "react-router-dom";

function NavListItem(props){
    return <li>
        
        <Link to = {props.link} className = "button">{props.icon} {props.name}</Link>
    </li>
}


export default NavListItem;