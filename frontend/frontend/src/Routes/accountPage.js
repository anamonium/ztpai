import React, {useState} from "react";
import Navigation from "../Components/Navigation/Navigation";
import Account from "../Components/Account/Account";
import Header from "../Components/BasicComponents/Header"
import '../Css/account.css'
import '../Css/mainPage.css'

function AccountPage(){

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
                <Account 
                    name = {"Sam Wall"}
                    beginningBudget = {10000}
                    date = {null}

                />
            </main>
    </div>
}


export default AccountPage;