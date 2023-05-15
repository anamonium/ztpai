import React, {useState} from "react";
import Navigation from "../Components/Navigation/Navigation";
import InfoSection from "../Components/BasicComponents/InfoSection";
import Header from "../Components/BasicComponents/Header"
import Budget from "../Components/Budget/Budget";
import '../Css/mainPage.css'
import '../Css/budget.css'


function BudgetPage(){

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
                    <Budget />
                </div>
            </main>
    </div>
}

export default BudgetPage;