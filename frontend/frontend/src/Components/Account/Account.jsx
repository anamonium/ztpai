import React, {useState, useEffect} from "react";
import PersonIcon from '@mui/icons-material/Person';
import "react-datepicker/dist/react-datepicker.css";
import DatePicker from "react-datepicker";
import BudgetInput from "./BudgetInput";
import axios from "axios";

function Account(props){

    const [isCalShown, setCalendar] = useState(false);
    const [startDate, setStartDate] = useState(null);
    const token = props.token;
    const [isBudgetEditable, setBudgetEditable] = useState(false);

    const [accountDet, setAccountDet] = useState({});

    useEffect(() => {
        getAccount();
    }, []);


    async function getAccount(){
        try {
            const response = await axios.get("/account", {
              headers: {
                Authorization: `Bearer ${token}`,
                Accept: "application/json",
                "Content-Type": "application/json",
              },
            });
            const data = response.data;
            console.log(data);
            setAccountDet(data);
            const weddDate = data.weddingDate;
            setStartDate(new Date(weddDate));
          } catch (error) {
            console.error("Error fetching overview:", error);
          }
    }

    function logOut(){
        sessionStorage.setItem('token', "");
        console.log("Tok:" + sessionStorage.getItem('token'));
        window.location.href = "/login";
    }

    function showCalendar(){
        setCalendar(!isCalShown);
    }

    function saveDate(date){
        console.log(date);
        axios.put('/account/date', date, {
            headers: {
                "Authorization": "Bearer " + token,
                "Accept": "application/json",
                "Content-Type": "application/json"
            }
        }).then(res => {
            console.log(res);
            const formattedDate = date.toISOString().substr(0, 10);
            setAccountDet(prevState => ({
                ...prevState,
                weddingDate: formattedDate
            }));
            setCalendar(false);
        });
    }

    function editBudget(){
        setBudgetEditable(true);
    }

    function saveBudget(val){
        console.log(val);

        axios.put('/account/budget', val, {
            headers: {
                "Authorization": "Bearer " + token,
                "Accept": "application/json",
                "Content-Type": "application/json"
            }
        }).then(res => {
            console.log(res);
            setAccountDet(prevState => ({
                ...prevState,
                budget: val
            }));
            setBudgetEditable(false);
        });

        
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