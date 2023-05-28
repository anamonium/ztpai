import React from "react";
import Navigation from "../Components/Navigation/Navigation";
import InfoSection from "../Components/BasicComponents/InfoSection";
import Overview from "../Components/Overview/Overview";
import Header from "../Components/BasicComponents/Header"
import '../Css/overview.css'
import '../Css/mainPage.css'


function OverviewPage(props){

    return <div className = "containerMain">
            <Header
                hideNav = {props.toggleNav}
            />
            <main>
                {props.isNavVisible && <Navigation />}
                <div className = "inside">
                    <InfoSection title = {"Overview"}/>
                    <Overview />
                </div>
            </main>
    </div>
}

export default OverviewPage;