import React, {useState} from "react";
import Navigation from "../Components/Navigation/Navigation";
import InfoSection from "../Components/BasicComponents/InfoSection";
import GuestList from "../Components/GuestList/GuestList";
import Header from "../Components/BasicComponents/Header"
import '../Css/guestList.css'
import '../Css/mainPage.css'

function GuestListPage(){
    
    const [isNavVisible, setNavVisible] = useState(true);

    function toggleNav(){
        setNavVisible(!isNavVisible);
    }

    return <div className = "containerMain">
            <Header
                hideNav = {toggleNav}
            />
            <main>
                {isNavVisible && <Navigation />}
                <div className = "inside">
                    <InfoSection />
                    <GuestList />
                </div>
            </main>
    </div>
}

export default GuestListPage;

