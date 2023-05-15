import React, {useState, useEffect} from "react";
import Task from "./Task";
import CheckBoxOutlineBlankIcon from '@mui/icons-material/CheckBoxOutlineBlank';
import CheckBoxIcon from '@mui/icons-material/CheckBox';
import AddTask from "./AddTask";
import axios from "axios";

function Checklist(){

    const token = sessionStorage.getItem('token');
    const [tasks, setTasks] = useState([]);

    useEffect(() => {
        fetchTasks();
    }, [])

    async function fetchTasks() {

       return axios.get(
        "/checklist",{
            headers: {
                "Authorization": 'Bearer ' + token,
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }
       ).then(res => {
        setTasks(res.data)
       })
    }

    function changeStatus(id){

        axios.put('/checklist/' + id, null, {
            headers: {
                "Authorization": "Bearer " + token,
                "Accept": "application/json",
                "Content-Type": "application/json"
              }
        }).then(res => {
            console.log("Task status changed");
            setTasks(tasks.map(task => {
                if (task.id === id) {
                    return {...task, status: !task.status};
                } else {
                    return task;
                }
            }));
        })

    }

    function deleteTask(id){
        
        axios.delete('/checklist/' + id, {
            headers: {
                "Authorization": "Bearer " + token,
                "Accept": "application/json",
                "Content-Type": "application/json"
              }
        }).then(res => {
            console.log("Task deleted successfully");
            setTasks(tasks.filter(task => task.id !== id));
        })
       
    }

    function addTask(task){

        axios.post("/checklist/add", {
            title: task.title,
            content: task.content
        }, {
            headers: {
                "Authorization": "Bearer " + token,
                "Accept": "application/json",
                "Content-Type": "application/json"
            }
        })
        .then(res => {
            const taskId = res.data;
            
            const updatedTasks = [...tasks, { id: taskId, title: task.title, content: task.content, status: false }];

            setTasks(updatedTasks);
        })
        .catch(error => {
            console.error(error);
        });
    
    }

    function createTask(task){
        return <Task 
            key = {task.id}
            taskStatus = {task.status ? <CheckBoxIcon /> : <CheckBoxOutlineBlankIcon />}
            taskContent = {task.content}
            changeStatus={() => changeStatus(task.id)}
            deleteTask = {() => deleteTask(task.id)}
        />
    }

    return <div className="checklist">
        {tasks.map(createTask)}
        <AddTask addTask = {addTask}/>
    </div>
}


export default Checklist;