import React from "react";
import BudgetItem from "./BudgetItem";

function Budget(){

    const [items, setItems] = useState();



    return <div className = "budget">
        <div className = "bItems">
            {items.map()}
        </div>

    </div>
}

export default Budget;