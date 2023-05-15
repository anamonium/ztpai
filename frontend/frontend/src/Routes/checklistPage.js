import React, {useState} from "react";
import Navigation from "../Components/Navigation/Navigation";
import InfoSection from "../Components/BasicComponents/InfoSection";
import Header from "../Components/BasicComponents/Header"
import Checklist from "../Components/CheckList/Checklist"
import '../Css/mainPage.css'
import '../Css/checklist.css'

function CheckListPage(){

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
                    <Checklist />
                </div>
            </main>
    </div>
}

export default CheckListPage;