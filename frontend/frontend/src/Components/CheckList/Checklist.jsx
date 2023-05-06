import React, {useState, useEffect} from "react";
import Task from "./Task";
import CheckBoxOutlineBlankIcon from '@mui/icons-material/CheckBoxOutlineBlank';
import CheckBoxIcon from '@mui/icons-material/CheckBox';
import tas from './tasks.js'
import axios from "axios";

function Checklist(){

    const token = sessionStorage.getItem('token');
    const [tasks, setTasks] = useState([]);

    useEffect(() => {
        fetchTasks();
    }, [])

    async function fetchTasks() {
        try {
            const response = await axios.get('http://localhost:8080/checklist', {
                headers: {
                    "Authorization": 'Bearer ' + token,
                    "Access-Control-Allow-Origin": "http://localhost:8080"
                },
                mode: 'cors'
            });
            setTasks(response.data);
        } catch (error) {
            console.error('Błąd podczas pobierania zadań:', error);
        }
    }

    function changeStatus(id){
        setTasks(tasks.map(task => {
            if (task.id === id) {
                return {...task, status: !task.status};
            } else {
                return task;
            }
        }));
    }

    function deleteTask(id){
        setTasks(tasks.filter(task => task.id !== id));
    }

    function createTask(task){
        return <Task 
            taskStatus = {task.status ? <CheckBoxIcon /> : <CheckBoxOutlineBlankIcon />}
            taskContent = {task.content}
            changeStatus={() => changeStatus(task.id)}
            deleteTask = {() => deleteTask(task.id)}
        />
    }

    return <div className="checklist">
        {tasks.map(createTask)}
    </div>
}


export default Checklist;