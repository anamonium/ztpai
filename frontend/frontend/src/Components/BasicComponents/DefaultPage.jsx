import React from "react";
import Header from "./Header";
import MainSection from "./MainSection";
import Navigation from "../Navigation/Navigation";
import GuestList from "../GuestList/GuestList";
import InfoSection from "./InfoSection";

function DefaultPage(props){
    return <div className = "containerMain">
        <Header/>
        <main>
            <Navigation />
            <InfoSection />
            <MainSection inside = {props.component}/>
        </main>
    </div>
}

export default DefaultPage;