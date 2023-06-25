import React from 'react';
import VerifiedForm from '../components/VerifiedForm'
import VerifiedImg from '../assets/Verified.svg';
import RegisterPageCSS from '../styles/RegisterPage.module.css';

const VerifiedPage = () => {

  return (
    <div className={RegisterPageCSS.registerpagecontainer}>
      <h1>Verify your mobile number</h1>
      <VerifiedForm image={VerifiedImg}/>
    </div>
  );
};

export default VerifiedPage;