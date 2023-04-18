import React from "react";
import Header from "./Header";
import MainSection from "./MainSection";
import Navigation from "./Navigation/Navigation";

function DefaultPage(props){
    return <div className = "containerMain">
        <Header/>
        <main>
            <Navigation />
            <MainSection /*props.inside np *//>
        </main>
    </div>
}

export default DefaultPage;