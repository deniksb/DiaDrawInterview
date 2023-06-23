import React from 'react';
import LandingCard from '../components/LandingCard';
import { useNavigate } from 'react-router-dom';
import LandingPageCSS from '../styles/LandingPage.module.css';

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
      <div className="button-container">
        <LandingCard headingLabel="I'm new user" buttonLabel="CREATE ACCOUNT" onClick={onRegister} />
        <LandingCard headingLabel = "I have an account" buttonLabel="LOGIN NOW" onClick={onLogin} />
      </div>
    </div>
  );
};

export default LandingPage;