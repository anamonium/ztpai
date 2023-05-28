import React from "react";
import Navigation from "../Components/Navigation/Navigation";
import Header from "../Components/BasicComponents/Header"
import Budget from "../Components/Budget/Budget";
import '../Css/mainPage.css'
import '../Css/budget.css'


function BudgetPage(props){

    return <div className = "containerMain">
            <Header
                hideNav = {props.toggleNav}
            />
            <main>
                {props.isNavVisible && <Navigation />}
                <div className = "inside">
                    <Budget />
                </div>
            </main>
    </div>
}

export default BudgetPage;