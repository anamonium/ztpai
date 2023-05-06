import React from "react";
import DeleteIcon from '@mui/icons-material/Delete';

function BudgetItem(props){


    return <div 
        className = "budgetItem" 
        id = {props.id}
    >
        <div className = "name">{props.name}</div>
        <div className = "cost">{props.cost}</div>
        <DeleteIcon onClick = {props.deleteBudgetItem}/>
    </div>
}

export default BudgetItem;