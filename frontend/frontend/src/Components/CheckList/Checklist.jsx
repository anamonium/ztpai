import React from "react";
import tasks from "./tasks";
import Task from "./Task";
import CheckBoxOutlineBlankIcon from '@mui/icons-material/CheckBoxOutlineBlank';
import CheckBoxIcon from '@mui/icons-material/CheckBox';

function Checklist(){

    function createTask(task){
        return <Task 
            taskStatus = {task.status ? <CheckBoxIcon /> : <CheckBoxOutlineBlankIcon />}
            taskContent = {task.content}

        />
    }

    return <div className="checklist">
        {tasks.map(createTask)}
    </div>
}


export default Checklist;