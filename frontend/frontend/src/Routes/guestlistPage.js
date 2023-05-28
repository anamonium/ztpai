import React from "react";
import Navigation from "../Components/Navigation/Navigation";
import GuestList from "../Components/GuestList/GuestList";
import Header from "../Components/BasicComponents/Header"
import '../Css/guestList.css'
import '../Css/mainPage.css'

function GuestListPage(props){

    return <div className = "containerMain">
            <Header
                hideNav = {props.toggleNav}
            />
            <main>
                {props.isNavVisible && <Navigation />}
                <div className = "inside">
                    
                    <GuestList 

                    />
                </div>
            </main>
    </div>
}

export default GuestListPage;

