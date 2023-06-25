import React from 'react';
import axios from 'axios';
import VerifyForm from '../components/VerifyForm';
import jwt from 'jwt-decode';
import { useNavigate, useLocation } from 'react-router-dom';
import RegisterFormImg from '../assets/RegisterForm.svg';
import RegisterPageCSS from '../styles/RegisterPage.module.css';

const VerifyPhonePage = () => {

  const navigate = useNavigate();

  const location = useLocation();

  const searchParams = new URLSearchParams(location.search);

  const email = searchParams.get('email');

  const phoneNumber = searchParams.get('phoneNumber');

  const handleSubmit = async (code) => {
    await axios.get(`http://localhost:8080/verify?code=${code}&email=${encodeURIComponent(email)}`)
      .then(response => {
        console.log(response)

        const decoded = jwt(response.data);

        console.log(decoded);

        localStorage.setItem("jwt_authorization", response.data);

        navigate('/verified');
      })
      .catch(error => {
        console.log(error)

        alert("Failed verification");
      });
  };

  return (
    <div className={RegisterPageCSS.registerpagecontainer}>
      <h1>Verify your mobile number</h1>
      <VerifyForm text={`A 6-digit code has been sent as a text message to +${phoneNumber}`} image={RegisterFormImg} onSubmit={handleSubmit} redirectUrl={`/verify/email?email=${encodeURIComponent(email)}&phoneNumber=${encodeURIComponent(phoneNumber)}`} />
    </div>
  );
};

export default VerifyPhonePage;