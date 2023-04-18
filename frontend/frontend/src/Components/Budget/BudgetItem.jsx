import React from "react";
import DeleteIcon from '@mui/icons-material/Delete';

function BudgetItem(props){



    return <div className = "budgetItem" id = "">
        <div className = "name">{props.name}</div>
        <div className = "cost">{props.cost}</div>
        <DeleteIcon />
    </div>
}

export default BudgetItem;