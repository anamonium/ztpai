import React from "react";
import DeleteIcon from '@mui/icons-material/Delete';

function Guest(props){

    return <tr id = "">
        <td class = "gName">{props.guestName}</td>
        <td class = "gPlusOne" onClick= {props.changeStatus} >{props.plusOne}</td>
        <td class = "gStatus" onClick= {props.changeStatus} >{props.guestStatus}</td>
        <td class = "gPhone">{props.guestPhone}</td>
        <td class = "removeGuest" onClick={props.deleteGuest }><DeleteIcon/></td>
    </tr>
}

export default Guest;