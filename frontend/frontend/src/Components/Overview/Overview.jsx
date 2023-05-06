import React from "react";

function Overview(props){
    return <div className = "overview">

        <div class = "weddingDate">
            <div class="overLabel">Wedding date:</div>
                 {
                    props.date != null ? 
                        <div class="overInfo">{props.date}</div> : 
                        <div class="overInfo">Your wedding date is not set yet.</div>
                 }
        </div>

        <hr />            
        <div class = "budget">
            <div class="overLabel">Budget left:</div>
            <div class="overInfo">
                {props.budgetLeft} / 
                {props.beginnningBudget}
            </div>

        </div>

        <hr />                
        <div class = "guests">
            <div class="overLabel">Confirmed guests:</div>
                <div class="overInfo"> 
                    {props.guestsAccepted} / 
                    {props.guestsInvited}
                </div>
        </div>

        <hr />
        <div class = "tasks">
            <div class="overLabel">Tasks completed:</div>
            <div class="overInfo">
                {props.tasksCompleted} / 
                {props.allTasks}
            </div>
        </div>
                        

    </div>
}


export default Overview;