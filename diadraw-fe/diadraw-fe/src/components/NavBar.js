import React from 'react';
import NavBarCSS from '../styles/NavBar.module.css'

const NavBar = ({ label, onClick }) => {
  return (
    <div className={NavBarCSS.navbarcontainer}>
    <h1 className={NavBarCSS.navbartitle}>Website</h1>
    <button className={NavBarCSS.navbarbutton}>NEED HELP?</button>
    </div>
  );
};

export default NavBar;