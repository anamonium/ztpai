import React, { useEffect, useState } from "react";
import Guest from "./Guest";
import CheckBoxOutlineBlankIcon from '@mui/icons-material/CheckBoxOutlineBlank';
import CheckBoxIcon from '@mui/icons-material/CheckBox';
import axiosInstance from "../axios-interceptors";
import AddGuest from './AddGuest';

function GuestList(props){
    
    const[guests, setGuests] = useState([]);
    const[summary, setSummary] = useState({});

    useEffect(() => {
      fetchGuests();
      fetchSummary();
    }, []);
    
    async function fetchGuests() {
      try {
        const response = await axiosInstance.get("/guestlist");
        setGuests(response.data);
      } catch (error) {
        console.error(error);
      }
    }

    async function fetchSummary(){
      try {
        const response = await axiosInstance.get("/guestlist/summary")
        setSummary(response.data);
      } catch (error) {
        console.error(error);
      }
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

    async function deleteGuest(id) {

      try {
        await axiosInstance.delete('/guestlist/' + id)

        const deletedGuest = guests.find(guest => guest.id === id);

        if (deletedGuest) {
          const accepted = deletedGuest.status ? (deletedGuest.plusOne ? -2 : -1) : 0;
          const invited = deletedGuest.plusOne ? -2 : -1;

          setSummary({
            invited: summary.invited + invited,
            accepted: summary.accepted + accepted
          });
        }

        setGuests(guests.filter(guest => guest.id !== id));
      } catch (error) {
        console.error(error);
      }

    }


      async function changeStatus(id) {
        try{
          await axiosInstance.put('/guestlist/st/' + id)
          setGuests(guests.map(guest => {
            if (guest.id === id) {
              const accepted = guest.status ? (guest.plusOne ? -2 : -1) : (guest.plusOne ? 2 : 1);
              setSummary({
                ...summary,
                accepted: summary.accepted + accepted
              })
              return {...guest, status: !guest.status};
            } else {
              return guest;
            }
          }));
        }catch(error){
          console.error(error);
        }
      }

    async function changePlusOne(id) {

      try{
        await axiosInstance.put('/guestlist/po/' + id);
        setGuests(guests.map(guest => {
          if (guest.id === id) {
            const invited = guest.plusOne ? -1 : 1;
            const accepted = guest.status ? (guest.plusOne ? -1 : 1) : 0;
            setSummary({
              invited: summary.invited + invited,
              accepted: summary.accepted + accepted
            })
            return {...guest, plusOne: !guest.plusOne};
          } else {
            return guest;
          }
        }));
      }catch(error){
        console.error(error);
      }
    }

    async function addGuest(guest) {

      try{
        const response = await axiosInstance.post("/guestlist", {
          firstName: guest.name,
          lastName: guest.surname,
          phone: guest.phone
        });

        const updatedGuests = [...guests, {
          id: response.data,
          name: guest.name,
          surname: guest.surname,
          phone: guest.phone,
          status: false,
          plusOne: false
        }];
  
        setGuests(updatedGuests);
        setSummary({
          ...summary,
          invited: summary.invited
        })


      }catch(error){
        console.error(error);
      }

    }
      

    return <div className = "ag">
      <div className = "info">
                        <h2>Guest list</h2>
                        <span>Here you can store the information about your guests.</span>
                        <div className = "guestListInfo">
                            <div >
                                <div id = "invited">Invited: {summary.invited}</div>
                            </div>

                            <div>
                                <div id = "confirmed">Confirmed: {summary.accepted}</div>
                            </div>
                        </div>
                    </div>
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