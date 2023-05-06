import { Fab, Zoom } from "@mui/material";
import React, {useState} from "react";

function AddGuest(){

    const [isExpanded, setExpanded] = useState(false);

    const [guest, setGuest] = useState({
        title: "",
        surname: "",
        phone: ""
      });

    function expand() {
        setExpanded(true);
    }

    function handleChange(event) {
        const { name, value } = event.target;
    
        setGuest(prevGuests => {
          return {
            ...prevGuests,
            [name]: value
          };
        });
      }

    function submitGuest(event){

        if(guest.name !== "" && guest.surname !== "" && guest.phone !== ""){
            setGuest(guest.name = "");
            setGuest(guest.surname = "");
            setGuest(guest.phone = "");
        }
        setExpanded(false);

    }

    return <div>
        <form className="add">
        <input
          name="name"
          onClick={expand}
          onChange={handleChange}
          value={guest.name}
          placeholder="Name"
          rows={isExpanded ? 3 : 1}
        />
        {isExpanded && (
          <input
            name="surname"
            onChange={handleChange}
            value={guest.surname}
            placeholder="Surname"
          />
        )}

        {isExpanded && (
          <input
            name="phone"
            onChange={handleChange}
            value={guest.cost}
            placeholder="Phone"
          />
        )}

        
        <Zoom in={isExpanded}>
          <Fab 
            variant="extended"
            onClick = {submitGuest}
            >
            Add guest
          </Fab>
        </Zoom>
      </form>
    </div>

}


export default AddGuest;