import React, {useState, useEffect} from "react";
import BudgetItem from "./BudgetItem"
import bit from './budgetItems.js'

function Budget(){

    const[bItems, setBItems] = useState([]);

    useEffect(() => {
        setBItems(bit)
    }, [])

    function deleteBudgetItem(id){
        setBItems(bItems.filter(bItem => bItem.id !== id));
    }

    function getItems(item){
        return <BudgetItem 
            key = {item.id}
            id = {item.id}
            name = {item.name}
            cost = {item.cost}
            deleteBudgetItem = {() => deleteBudgetItem(item.id)}
        />
    }

    return <div className = "budget">
        <div className = "bItems">
            {bItems.map(getItems)}
        </div>

    </div>
}

export default Budget;