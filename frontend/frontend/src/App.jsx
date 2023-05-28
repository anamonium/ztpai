import React, {useState} from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import WelcomePage from './Components/WelcomePage/WelcomePage';
import GuestListPage from './Routes/guestlistPage';
import CheckListPage from './Routes/checklistPage';
import BudgetPage from './Routes/budgetPage';
import OverviewPage from './Routes/overwiewPage';
import AccountPage from './Routes/accountPage';
import LoginPage from './Routes/loginPage';
import SignInPage from './Routes/signinPage';

function App(){

     const token = sessionStorage.getItem('token');
     const isAuthenticated = token !== null;
     const [isNavVisible, setNavVisible] = useState(true);
     
     function toggleNav(){
          setNavVisible(!isNavVisible);
     }

    return (
       <>
          <Routes>
            
             <Route 
                  path="/"
                  element={<WelcomePage />} > </Route>
             <Route 
                  path="/login" 
                  element = {!isAuthenticated ? <LoginPage /> : <Navigate to = "/overview" /> } > </Route>
             <Route 
                  path="/signin" 
                  element = {<SignInPage />} > </Route>
             <Route 
                  path="/account"
                  element={isAuthenticated ? <AccountPage isNavVisible = {isNavVisible} toggleNav = {toggleNav}/> : <Navigate to="/login" />} > </Route>
             <Route 
                  path="/overview" 
                  element = {isAuthenticated ? <OverviewPage isNavVisible = {isNavVisible} toggleNav = {toggleNav}/> : <Navigate to="/login" />} > </Route>
             <Route 
                  path="/checklist" 
                  element = {isAuthenticated ? <CheckListPage isNavVisible = {isNavVisible} toggleNav = {toggleNav}/> : <Navigate to="/login" />} > </Route>
             <Route 
                  path="/budget" 
                  element = {isAuthenticated ? <BudgetPage isNavVisible = {isNavVisible} toggleNav = {toggleNav}/> : <Navigate to="/login" />} > </Route>
             <Route 
                  path="/guestlist" 
                  element={isAuthenticated ? <GuestListPage isNavVisible = {isNavVisible} toggleNav = {toggleNav}/> : <Navigate to="/login" />} > </Route>
             <Route 
                  path="/*" 
                  element = {isAuthenticated ? <OverviewPage /> : <Navigate to="/login" />} > </Route>

          </Routes>
       </>
    );
}
   
export default App;