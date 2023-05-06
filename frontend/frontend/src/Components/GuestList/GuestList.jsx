import React, { useEffect, useState } from "react";
import Guest from "./Guest";
import CheckBoxOutlineBlankIcon from '@mui/icons-material/CheckBoxOutlineBlank';
import CheckBoxIcon from '@mui/icons-material/CheckBox';
import gu from './guests.js'

function GuestList(){
    
    const[guests, setGuests] = useState([]);

    useEffect( () => {
        setGuests(gu);
    }, [])

    function getGuests(guest){
        return <Guest 
            guestName = {guest.name + " " + guest.surname}
            plusOne = {guest.plus_one ? <CheckBoxIcon /> : <CheckBoxOutlineBlankIcon />}
            guestStatus = {guest.status ? <CheckBoxIcon /> : <CheckBoxOutlineBlankIcon />}
            guestPhone = {guest.phone}
            deleteGuest = {() => deleteGuest(guest.id)}
            changePlusOne = {() => changePlusOne(guest.id)}
            changeStatus = {() => changeStatus(guest.id)}
        />
    }

    function deleteGuest(id){
        setGuests(guests.filter(guest => guest.id !== id));
    }


    function changeStatus(id){
        setGuests(guests.map(guest => {
            if (guest.id === id) {
                return {...guest, status: !guest.status};
            } else {
                return guest;
            }
        }));
    }

    function changePlusOne(id){
        setGuests(guests.map(guest => {
            if (guest.id === id) {
                return {...guest, plus_one: !guest.plus_one};
            } else {
                return guest;
            }
        }));
    }

    return <div className="guestList">
        <table>
            <thead>
                <tr>
                    <th class = "gName">Name</th>
                    <th class = "gPlusOne">Plus one</th>
                    <th class = "gStatus">Status</th>
                    <th class = "gPhone">Phone</th>
                    <th class = "removeGuest"></th>
                </tr>
            </thead>
            <tbody>
                {guests.map(getGuests)}
            </tbody>
        </table>
    </div>
}

export default GuestList;