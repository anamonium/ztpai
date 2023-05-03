import React from "react";
import Header from "./Header";
import MainSection from "./MainSection";
import Navigation from "../Navigation/Navigation";
import GuestList from "../GuestList/GuestList";

function DefaultPage(props){
    return <div className = "containerMain">
        <Header/>
        <main>
            <Navigation />
            <MainSection inside = {<GuestList />}/>
        </main>
    </div>
}

export default DefaultPage;