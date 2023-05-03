import React from "react";
import BudgetItem from "./BudgetItem"
import bItems from "./budgetItems"

function Budget(){


    function getItems(item){
        return <BudgetItem 
            name = {item.name}
            cost = {item.cost}
        />
    }

    return <div className = "budget">
        <div className = "bItems">
            {bItems.map(getItems)}
        </div>

    </div>
}

export default Budget;