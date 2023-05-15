import React, { useState } from "react";
import TextField from "@mui/material/TextField";


function BudgetInput(props) {
    
    const [value, setValue] = useState("");
  
    const handleChange = (event) => {
      const inputValue = event.target.value;
  
      if (inputValue === "") {
        setValue("");
        return;
      }
  
      if (isValidNumber(inputValue)) {
        setValue(inputValue);
      }
    };
  
    const isValidNumber = (value) => {
        const regex = /^(\d+([.,]\d*)?|[.,]\d+)$/;
        if (!regex.test(value)) {
          return false;
        }
      
        const parsedValue = parseFloat(value.replace(",", "."));
        if (isNaN(parsedValue)) {
          return false;
        }
      
        return true;
      };
  
    const inputStyle = {
      border: value && !isValidNumber(value) ? "2px solid red" : "black",
    };

   

  return (
    <div>
    <TextField
      label="New budget"
      value={value}
      onChange={handleChange}
      style={inputStyle}
      onKeyDown={(e) => {
        if (e.key === "Enter") {
          props.saveBudget(value)
        }
      }}
    />
    </div>
  );
};

export default BudgetInput;
