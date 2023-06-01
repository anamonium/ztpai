import React, {useState, useEffect} from "react";
import Task from "./Task";
import CheckBoxOutlineBlankIcon from '@mui/icons-material/CheckBoxOutlineBlank';
import CheckBoxIcon from '@mui/icons-material/CheckBox';
import AddTask from "./AddTask";
import axiosInstance from "../axios-interceptors";

function Checklist(){

    const [tasks, setTasks] = useState([]);
    const [summary, setSummary] = useState({});

    useEffect(() => {
        fetchTasks();
        fetchSummary();
    }, [])

    async function fetchSummary(){

        try{
            const response = await axiosInstance.get("/checklist/summary");
            setSummary(response.data);
        }catch(error){

        }
    }

    async function fetchTasks() {

        try{
            const response = await axiosInstance.get("/checklist");
            setTasks(response.data)
        }catch(error){
            
        }
    }

    async function changeStatus(id){

        try{
            await axiosInstance.put("/checklist/" + id);
            setTasks(tasks.map(task => {
                if (task.id === id) {
                    const stat = task.status ? -1 : 1
                    setSummary({
                        ...summary,
                        done: summary.done + stat
                    })
                    return {...task, status: !task.status};
                } else {
                    return task;
                }
            }));
        }catch(error){

        }
    }

    async function deleteTask(id){

        try{
            await axiosInstance.delete("/checklist/" + id);
            const deletedTask = tasks.find(task => task.id === id);

            if (deletedTask) {
                const val = deletedTask.status ? -1 : 0;

                setSummary({
                    all: summary.all - 1,
                    done: summary.done + val
                });
            }
            setTasks(tasks.filter(task => task.id !== id));

        }catch(err){

        }
       
    }

    async function addTask(task){

        try{
            const response = await axiosInstance.post("/checklist/add",{
                title: task.title,
                content: task.content
            });

            const taskId = response.data;
            const updatedTasks = [...tasks, { id: taskId, title: task.title, content: task.content, status: false }];
            setTasks(updatedTasks);
            setSummary({
                ...summary,
                all: summary.all + 1
            })
        }catch(error){

        }
    }

    function createTask(task){
        return <Task 
            key = {task.id}
            taskTitle = {task.title}
            taskStatus = {task.status ? <CheckBoxIcon /> : <CheckBoxOutlineBlankIcon />}
            taskContent = {task.content}
            changeStatus={() => changeStatus(task.id)}
            deleteTask = {() => deleteTask(task.id)}
        />
    }

    return <div className="checklist">
        <div className = "checklistInfo">

            <h1>Checklists</h1>
            <span>This is the place when you can store all your tasks and mark them as completed.</span>
            <div>
                <div>
                    <div id = "all">All tasks: {summary.all}</div>
                </div>
                <div>
                    <div id = "completed">Tasks completed: {summary.done}</div>
                </div>
            </div>

        </div>
        {tasks.map(createTask)}
        <AddTask addTask = {addTask}/>
    </div>
}


export default Checklist;