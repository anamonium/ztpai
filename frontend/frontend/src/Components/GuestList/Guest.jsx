import React from "react";
import DeleteIcon from '@mui/icons-material/Delete';

function Guest(props){

    return <tr id = "">
        <td className = "gName">{props.guestName}</td>
        <td className = "gPlusOne" onClick= {props.changePlusOne} >{props.plusOne}</td>
        <td className = "gStatus" onClick= {props.changeStatus} >{props.guestStatus}</td>
        <td className = "gPhone">{props.guestPhone}</td>
        <td className = "removeGuest" onClick={props.deleteGuest }><DeleteIcon/></td>
    </tr>
}

export default Guest;