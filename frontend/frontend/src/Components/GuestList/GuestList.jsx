import React, { useEffect, useState } from "react";
import Guest from "./Guest";
import CheckBoxOutlineBlankIcon from '@mui/icons-material/CheckBoxOutlineBlank';
import CheckBoxIcon from '@mui/icons-material/CheckBox';
import axios from "axios";
import AddGuest from './AddGuest';

function GuestList(){
    
    const[guests, setGuests] = useState([]);
    const token = sessionStorage.getItem('token');

    useEffect( () => {
        fetchGuests();
    }, [])

    async function fetchGuests(){
        return axios.get(
            "/guestlist",{
                headers: {
                    "Authorization": 'Bearer ' + token,
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            }
           ).then(res => {
            console.log(res.data);
            setGuests(res.data);
           })
    }

    function getGuests(guest){
        return <Guest 
            guestName = {guest.name + " " + guest.surname}
            plusOne = {guest.plusOne ? <CheckBoxIcon /> : <CheckBoxOutlineBlankIcon />}
            guestStatus = {guest.status ? <CheckBoxIcon /> : <CheckBoxOutlineBlankIcon />}
            guestPhone = {guest.phone}
            deleteGuest = {() => deleteGuest(guest.id)}
            changePlusOne = {() => changePlusOne(guest.id)}
            changeStatus = {() => changeStatus(guest.id)}
            key = {guest.id}
        />
    }

    function deleteGuest(id){

        axios.delete('/guestlist/' + id, {
            headers: {
                "Authorization": "Bearer " + token,
                "Accept": "application/json",
                "Content-Type": "application/json"
              }
        }).then(res => {
            console.log("Task deleted successfully");
            setGuests(guests.filter(guest => guest.id !== id));
        })

    }


    function changeStatus(id){

        axios.put('/guestlist/st/' + id, null, {
            headers: {
                "Authorization": "Bearer " + token,
                "Accept": "application/json",
                "Content-Type": "application/json"
              }
        }).then(res => {
            console.log("Guest status changed");
            setGuests(guests.map(guest => {
                if (guest.id === id) {
                    return {...guest, status: !guest.status};
                } else {
                    return guest;
                }
            }));
        })

    }

    //sprawdzic w bazie czy dziala 
    function changePlusOne(id){

        axios.put('/guestlist/po/' + id, null, {
            headers: {
                "Authorization": "Bearer " + token,
                "Accept": "application/json",
                "Content-Type": "application/json"
              }
        }).then(res => {
            console.log("Guest plus one changed");
            setGuests(guests.map(guest => {
                if (guest.id === id) {
                    return {...guest, plus_one: !guest.plus_one};
                } else {
                    return guest;
                }
            }));
        })

        
    }

    function addGuest(guest){

        axios.post("/guestlist", {
            firstName: guest.name,
            lastName: guest.surname,
            phone: guest.phone
        }, {
            headers: {
                "Authorization": "Bearer " + token,
                "Accept": "application/json",
                "Content-Type": "application/json"
            }
        })
        .then(res => {
            const guestId = res.data;
            
            const updatedGuests = [...guests, { id: guestId, name: guest.name, surname: guest.surname, phone: guest.phone, status: false, plusOne: false }];

            setGuests(updatedGuests);
        })
        .catch(error => {
            console.error(error);
        });

    }

    return <div className = "ag">
        <div className="guestList">
            <table>
                <thead>
                    <tr>
                        <th className = "gName">Name</th>
                        <th className = "gPlusOne">Plus one</th>
                        <th className = "gStatus">Status</th>
                        <th className = "gPhone">Phone</th>
                        <th className = "removeGuest"></th>
                    </tr>
                </thead>
                <tbody>
                    {guests.map(getGuests)}
                </tbody>
            </table>
            
        </div>
    <AddGuest addGuest = {addGuest}/>
    </div>
}

export default GuestList;