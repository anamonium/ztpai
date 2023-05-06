import React from "react";
import DeleteIcon from '@mui/icons-material/Delete';

function Task(props){

    
    return<div className="task" id = "">

        <div className="checkSquare" onClick = {props.changeStatus}>
            {props.taskStatus}
        </div>

        <div className="taskContent">
            {props.taskContent}
        </div>

        <div class="deleteTask" onClick = {props.deleteTask}>
            <DeleteIcon />
        </div>

    </div>
}


export default Task;