import React from 'react';
import Button from '../components/Button';
import { useNavigate } from 'react-router-dom';

const LandingPage = () => {

    const navigate = useNavigate();

    const onRegister = () => {
        navigate('/register');
      };
    
      const onLogin = () => {
        navigate('/login');
      };

  return (
    <div className="landing-page">
      <h1>Welcome to Website</h1>
      <h2>Keeping Communities Connected</h2>
      <div className="button-container">
        <Button label="Register" onClick={onRegister} />
        <Button label="Login" onClick={onLogin} />
      </div>
    </div>
  );
};

export default LandingPage;