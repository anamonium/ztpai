import React from "react";
import Header from "./Header";
import MainSection from "./MainSection";
import Navigation from "./Navigation";

function DefaultPage(props){
    return <div className = "containerMain">
        <Header/>
        <main>
            <Navigation />
            <MainSection />
        </main>
    </div>
}

export default DefaultPage;