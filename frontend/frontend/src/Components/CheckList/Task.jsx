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

        <div className="deleteTask" onClick = {props.deleteTask}>
            <DeleteIcon />
        </div>

    </div>
}


export default Task;


// import React, { useState, useRef } from "react";
// import DeleteIcon from '@mui/icons-material/Delete';

// function Task(props) {
//     const [isEditing, setIsEditing] = useState(false);
//     const [content, setContent] = useState(props.taskContent);
//     const taskContentRef = useRef(null);

//     const handleTaskContentClick = () => {
//         setIsEditing(true);
//     };

//     const handleTaskContentKeyDown = (event) => {
//         if (event.key === "Enter") {
//             setIsEditing(false);
//             props.updateTaskContent(content);
//         }
//     };

//     const handleTaskContentChange = (event) => {
//         setContent(event.target.value);
//     };

//     const handleDeleteTaskClick = () => {
//         props.deleteTask();
//     };

//     return (
//         <div className="task">
//             <div className="checkSquare" onClick={props.changeStatus}>
//                 {props.taskStatus}
//             </div>

//             {isEditing ? (
//                 <input
//                     type="text"
//                     ref={taskContentRef}
//                     value={content}
//                     onChange={handleTaskContentChange}
//                     onKeyDown={handleTaskContentKeyDown}
//                     autoFocus
//                 />
//             ) : (
//                 <div className="taskContent" onClick={handleTaskContentClick}>
//                     {content}
//                 </div>
//             )}

//             <div className="deleteTask" onClick={handleDeleteTaskClick}>
//                 <DeleteIcon />
//             </div>
//         </div>
//     );
// }

// export default Task;
