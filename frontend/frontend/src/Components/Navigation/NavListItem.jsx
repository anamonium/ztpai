import React from "react";

function NavListItem(props){
    return <li>
        
        {props.icon} <a href = {props.link} className = "button">{props.name}</a>
    </li>
}


export default NavListItem;