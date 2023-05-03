import React, { useState } from "react";
import guests from "./guests";
import Guest from "./Guest";
import CheckBoxOutlineBlankIcon from '@mui/icons-material/CheckBoxOutlineBlank';
import CheckBoxIcon from '@mui/icons-material/CheckBox';

function GuestList(){
    

    function getGuests(guest){
        return <Guest 
            guestName = {guest.name + " " + guest.surname}
            plusOne = {guest.plus_one ? <CheckBoxIcon /> : <CheckBoxOutlineBlankIcon />}
            guestStatus = {guest.status ? <CheckBoxIcon /> : <CheckBoxOutlineBlankIcon />}
            guestPhone = {guest.phone}
        />
    }

    function deleteGuest(event){

    }

    function changeStatus(event){
        
    }

    return <div className="guestList">
        <table>
            <thead>
                <th class = "gName">Name</th>
                <th class = "gPlusOne">Plus one</th>
                <th class = "gStatus">Status</th>
                <th class = "gPhone">Phone</th>
                <th class = "removeGuest"></th>
            </thead>
            <tbody>
                {guestss.map(getGuests)}
            </tbody>
        </table>
    </div>
}

export default GuestList;