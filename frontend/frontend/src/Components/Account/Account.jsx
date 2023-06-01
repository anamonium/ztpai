import React, {useState, useEffect} from "react";
import PersonIcon from '@mui/icons-material/Person';
import "react-datepicker/dist/react-datepicker.css";
import DatePicker from "react-datepicker";
import BudgetInput from "./BudgetInput";
import axiosInstance from "../axios-interceptors";

function Account(){

    const [isCalShown, setCalendar] = useState(false);
    const [startDate, setStartDate] = useState(null);
    const [isBudgetEditable, setBudgetEditable] = useState(false);

    const [accountDet, setAccountDet] = useState({});

    useEffect(() => {
        getAccount();
    }, []);


    async function getAccount(){

        try{
            const response = await axiosInstance.get("/account");

            setAccountDet(response.data);
            const weddDate = response.data.weddingDate;
            weddDate !== null ? setStartDate(new Date(weddDate)) : setStartDate(new Date());

        }catch(error){

        }

    }

    function logOut(){
        sessionStorage.clear();
        window.location.reload(false);
    }

    function showCalendar(){
        setCalendar(!isCalShown);
    }

    async function saveDate(date){

        try{
            await axiosInstance.put("/account/date", date);

            const formattedDate = date.toISOString().substr(0, 10);
            setAccountDet(prevState => ({
                ...prevState,
                weddingDate: formattedDate
            }));
            setCalendar(false);

        }catch(error){

        }

    }

    function editBudget(){
        setBudgetEditable(true);
    }

    async function saveBudget(val){

        try{
            await axiosInstance.put('/account/budget', val);

            setAccountDet(prevState => ({
                ...prevState,
                budget: val
            }));
            setBudgetEditable(false);
        }catch(error){

        }
    }

    return <div className = "accou" id = "acc">
        <div className = "userDetail">
            <PersonIcon />
            {accountDet.name}
        </div>
        <div className = "budgetChanger">
            Beginning budget:
            {!isBudgetEditable && <span id = "budgetText" onClick = {editBudget}>
                {accountDet.budget != null ? accountDet.budget : "Budget not set yet"}
            </span>}
            {
                isBudgetEditable && 
                <BudgetInput 
                    saveBudget = {saveBudget}
                    budget = {accountDet.budget}
                />
            }
        </div>
        <div className = "weddingDateChanger">
            Wedding date:
            {!isCalShown && <span id = "weddingText" onClick={showCalendar}>
                {
                    accountDet.weddingDate != null ? 
                        <div className="infos">{accountDet.weddingDate}</div> : 
                        <div className="infos">Your wedding date is not set yet.</div>
                }
            </span>}
            {/* <EditIcon onClick = {showCalendar}/> */}
            {isCalShown && <DatePicker 
                            selected={startDate} 
                            onChange={date => {setStartDate(date);
                                                saveDate(date);
                                                }} 
                            dateFormat="yyyy-MM-dd"
                            label="New budget"
            />}
        </div>
        <div className = "logOut">
            <button id = "logOutButton" type = "submit" onClick={logOut}>Log out</button>
        </div>
    </div>
}

export default Account;