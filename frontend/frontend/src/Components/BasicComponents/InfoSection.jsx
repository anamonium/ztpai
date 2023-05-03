import React from "react";

function InfoSection(props){
    return <div className = "info">
        <h1>{props.title}</h1>
        <span>{props.info}</span>
    </div>
}

export default InfoSection;