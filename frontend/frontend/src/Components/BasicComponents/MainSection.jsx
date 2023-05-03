import React from "react";

function MainSection(props){
    return <div className = "siter">
        <section>
            {props.inside}
        </section>
    </div>
}

export default MainSection;