import { Fab, Zoom } from "@mui/material";
import React, {useState} from "react";

function AddBudgetItem(props){

    const [isExpanded, setExpanded] = useState(false);

    const [bItem, setBItem] = useState({
        title: "",
        cost: ""
      });

    function expand() {
        setExpanded(true);
    }

    function handleChange(event) {
        const { name, value } = event.target;
    
        setBItem(prevItem => {
          return {
            ...prevItem,
            [name]: value
          };
        });
      }

    function submitCost(event){
        props.addBudget(bItem);
        setExpanded(false)
        setBItem({
          title: "",
          cost: ""
        });
        
    }

    return <div className = "abi">
        <form className="add">
        {isExpanded && (
          <input
            name="cost"
            onChange={handleChange}
            value={bItem.cost}
            placeholder="Cost"
          />
        )}

        <input
          name="name"
          onClick={expand}
          onChange={handleChange}
          value={bItem.name}
          placeholder="Cost name..."
          rows={isExpanded ? 3 : 1}
        />
        <Zoom in={isExpanded}>
          <Fab 
            variant="extended"
            onClick = {submitCost}
            >
            Add cost
          </Fab>
        </Zoom>
      </form>
    </div>
}

export default AddBudgetItem;