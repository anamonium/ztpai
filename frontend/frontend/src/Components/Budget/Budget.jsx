import React, {useState, useEffect} from "react";
import BudgetItem from "./BudgetItem"
import AddBudgetItem from './AddBudgetItem';
import axios from "axios";

function Budget(){

    const[bItems, setBItems] = useState([]);
    const token = sessionStorage.getItem('token');

    useEffect(() => {
        getBudget();
    }, [])

    async function getBudget(){
        return axios.get(
            "/budget",{
                headers: {
                    "Authorization": 'Bearer ' + token,
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            }
           ).then(res => {
            setBItems(res.data)
           })
    }

    function deleteBudgetItem(id){

        axios.delete('/budget/' + id, {
            headers: {
                "Authorization": "Bearer " + token,
                "Accept": "application/json",
                "Content-Type": "application/json"
              }
        }).then(res => {
            console.log("Budget item deleted successfully");
            setBItems(bItems.filter(bItem => bItem.id !== id));
        })

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

    function addBudget(bItem){

        axios.post("/budget", {
            cost: bItem.cost,
            name: bItem.name
        }, {
            headers: {
                "Authorization": "Bearer " + token,
                "Accept": "application/json",
                "Content-Type": "application/json"
            }
        }).then(res =>{
            const bItemId = res.data;
            
            const updatesBudget = [...bItems, { id: bItemId, name: bItem.name, cost: bItem.cost }];

            setBItems(updatesBudget);
        })

    }

    return <div className = "budget">
        <div className = "bItems">
            {bItems.map(getItems)}
        </div>
        <AddBudgetItem addBudget = {addBudget}/>
    </div>
}

export default Budget;