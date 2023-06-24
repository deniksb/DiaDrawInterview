import React from 'react';
import axios from 'axios';
import RegisterForm from '../components/RegisterForm';
import { useNavigate } from 'react-router-dom';
import RegisterPageCSS from '../styles/RegisterPage.module.css';
import RegisterFormImg from '../assets/RegisterForm.svg';

const RegisterPage = () => {

    const navigate = useNavigate();

  const handleSubmit = async (data) => {
    await axios.post("http://localhost:8080/signup", data)
      .then(response => {
        console.log(response.data)
        navigate(`/verify?email=${encodeURIComponent(data.email)}`);
      })
      .catch(error => {
        console.log(error)
        alert("Failed to register");
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

export default RegisterPage;