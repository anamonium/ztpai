import React from "react";
import Navigation from "../Components/Navigation/Navigation";
import Header from "../Components/BasicComponents/Header"
import Checklist from "../Components/CheckList/Checklist"
import '../Css/mainPage.css'
import '../Css/checklist.css'

function CheckListPage(props){

    return <div className = "containerMain">
            <Header
                hideNav = {props.toggleNav}
            />
            <main>
                {props.isNavVisible && <Navigation />}
                <div className = "inside">
                    <Checklist />
                </div>
            </main>
    </div>
}

export default CheckListPage;