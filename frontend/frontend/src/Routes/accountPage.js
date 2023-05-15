import React, {useState} from "react";
import Navigation from "../Components/Navigation/Navigation";
import Account from "../Components/Account/Account";
import Header from "../Components/BasicComponents/Header"
import '../Css/account.css'
import '../Css/mainPage.css'

function AccountPage(props){

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
                    token = {props.token}

                />
            </main>
    </div>
}


export default AccountPage;