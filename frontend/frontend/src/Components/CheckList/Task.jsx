import React from "react";
import DeleteIcon from '@mui/icons-material/Delete';

function Task(props){

    
    return<div className="task" id = "">
        <div className = "taskTitle">
            {props.taskTitle}
        </div>

        <div className = "taskDet">
            <div className="checkSquare" onClick = {props.changeStatus}>
                {props.taskStatus}
            </div>

            <div className="taskContent">
                {props.taskContent}
            </div>

            <div className="deleteTask" onClick = {props.deleteTask}>
                <DeleteIcon />
            </div>
        
        </div>
    </div>
}


export default Task;

