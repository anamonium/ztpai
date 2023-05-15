import React , {useState}from "react";
import Navigation from "../Components/Navigation/Navigation";
import InfoSection from "../Components/BasicComponents/InfoSection";
import Overview from "../Components/Overview/Overview";
import Header from "../Components/BasicComponents/Header"
import '../Css/overview.css'
import '../Css/mainPage.css'


function OverviewPage(){
    
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
                    <InfoSection title = {"Overview"}/>
                    <Overview 
                        date = {null} 
                        budgetLeft = {1000}
                        beginnningBudget = {10000}
                        guestsAccepted = {93}
                        guestsInvited = {120}
                        tasksCompleted = {42}
                        allTasks = {60}
                    />
                </div>
            </main>
    </div>
}

export default OverviewPage;