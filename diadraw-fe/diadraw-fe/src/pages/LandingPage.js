import React from 'react';
import LandingCard from '../components/LandingCard';
import { useNavigate } from 'react-router-dom';
import LandingPageCSS from '../styles/LandingPage.module.css';
import RegisterImg from '../assets/Register.svg';
import LoginImg from '../assets/Login.svg';

const LandingPage = () => {

    const navigate = useNavigate();

    const onRegister = () => {
        navigate('/register');
      };
    
      const onLogin = () => {
        navigate('/login');
      };

  return (
    <div className={LandingPageCSS.landingpage}>
      <h1>Welcome to Website</h1>
      <p>Keeping Communities Connected</p>
      <div className={LandingPageCSS.landingpagebuttoncontainer}>
        <LandingCard headingLabel="I'm new user" buttonLabel="CREATE ACCOUNT" image={RegisterImg} onClick={onRegister} />
        <LandingCard headingLabel = "I have an account" buttonLabel="LOGIN NOW" image={LoginImg} onClick={onLogin} />
      </div>
    </div>
  );
};

export default LandingPage;