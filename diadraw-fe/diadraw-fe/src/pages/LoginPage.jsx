import React from 'react';
import axios from 'axios';
import RegisterForm from '../components/RegisterForm';
import { useNavigate } from 'react-router-dom';
import RegisterPageCSS from '../styles/RegisterPage.module.css';
import RegisterFormImg from '../assets/RegisterForm.svg';

const LoginPage = () => {

  const navigate = useNavigate();

  const handleSubmit = async (data) => {
    await axios.post("http://localhost:8080/signin", data)
      .then(response => {
        console.log(response.data)
        navigate(`/verify/phone?email=${encodeURIComponent(data.email)}&phoneNumber=${encodeURIComponent(data.phoneNumber)}`);
      })
      .catch(error => {
        console.log(error)
      });
  };

  return (
    <div className={RegisterPageCSS.registerpagecontainer}>
      <h1>Welcome to Website</h1>
      <div>
      <RegisterForm image={RegisterFormImg} onSubmit={handleSubmit} />
      </div>
    </div>
  );
};

export default LoginPage;