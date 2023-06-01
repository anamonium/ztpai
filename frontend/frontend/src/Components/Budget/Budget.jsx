import React, {useState, useEffect} from "react";
import BudgetItem from "./BudgetItem"
import AddBudgetItem from './AddBudgetItem';
import axiosInstance from "../axios-interceptors";


function Budget(){

    const[bItems, setBItems] = useState([]);
    const[summary, setSummary] = useState({});

    useEffect(() => {
        getBudget();
        fetchSummary();
    }, [])

    async function fetchSummary(){
        try{
            const response = await axiosInstance.get("/budget/summary");
            setSummary(response.data);
        }catch(error){

        }
    }

    async function getBudget(){

        try{
            const response = await axiosInstance.get("/budget");
            setBItems(response.data)
        }catch(error){
            
        }
    }

    async function deleteBudgetItem(id){

        try{
            await axiosInstance.delete("/budget/" + id);

            const deletedBItem = bItems.find(bItem => bItem.id === id);
            if (deletedBItem) {
                const updatedSpend = summary.spend - parseFloat(deletedBItem.cost);
                setSummary({ ...summary, spend: updatedSpend });
            }
            setBItems(bItems.filter(bItem => bItem.id !== id));

        }catch(error){
            
        }
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

    async function addBudget(bItem){

        try{
            const response = await axiosInstance.post("budget", {
                cost: bItem.cost,
                name: bItem.name
            });

            const bItemId = response.data;
            const updatesBudget = [...bItems, { id: bItemId, name: bItem.name, cost: bItem.cost }];
            setSummary({
                ...summary,
                spend: summary.spend + parseFloat( bItem.cost )
            })
            setBItems(updatesBudget);

        }catch(error){
            
        }
    }

    return <div className = "budget">
        <div className = "budgetInfo">
                   <h1>Budget manager</h1>
                    <span>In this place you can store all of your expenses.</span>
                    <div>

                          <div>Budget spend: {summary.spend}</div>
                          <div>Beginnig budget: {summary.beginning === null ? 0 : summary.beginning}</div>

                    </div>
                </div>
        <div className = "bItems">
            {bItems.map(getItems)}
        </div>
        <AddBudgetItem addBudget = {addBudget}/>
    </div>
}

export default Budget;