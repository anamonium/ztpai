import React from "react";
import Navigation from "../Components/Navigation/Navigation";
import Account from "../Components/Account/Account";
import Header from "../Components/BasicComponents/Header"
import '../Css/account.css'
import '../Css/mainPage.css'

function AccountPage(props){


    return <div className = "containerMain">
            <Header
                hideNav = {props.toggleNav}
            />
            <main>
                {props.isNavVisible && <Navigation />}
                <Account 
                />
            </main>
    </div>
}


export default AccountPage;