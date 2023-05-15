import { Fab, Zoom } from "@mui/material";
import React, {useState} from "react";

function AddTask(props){

    const [isExpanded, setExpanded] = useState(false);

    const [task, setTask] = useState({
        title: "",
        content: "",
      });

    function expand() {
        setExpanded(true);
    }

    function handleChange(event) {
        const { name, value } = event.target;
    
        setTask(prevGuests => {
          return {
            ...prevGuests,
            [name]: value
          };
        });
      }

    function submitTask(event){
        props.addTask(task);
        setTask({
          title: "",
          content: ""
        });
        event.preventDefault();
        setExpanded(false);
    }

    return <div>
        <form className="add">
        <input
          name="title"
          onClick={expand}
          onChange={handleChange}
          value={task.title}
          placeholder="Title"
          rows={isExpanded ? 3 : 1}
        />
        {isExpanded && (
          <input
            name="content"
            onChange={handleChange}
            value={task.content}
            placeholder="Content"
          />
        )}

        <Zoom in={isExpanded}>
          <Fab 
            variant="extended"
            onClick = {submitTask}
            >
            Add task
          </Fab>
        </Zoom>
      </form>
    </div>
}

export default AddTask;