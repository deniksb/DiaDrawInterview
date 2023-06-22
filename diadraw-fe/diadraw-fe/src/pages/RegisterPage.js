import React from 'react';
import axios from 'axios';
import RegisterForm from '../components/RegisterForm';
import { useNavigate } from 'react-router-dom';

const RegisterPage = () => {

    const navigate = useNavigate();

  const handleSubmit = async (data) => {
    await axios.post("http://localhost:8080/signup", data)
      .then(response => {
        console.log(response)
        navigate(`/verify?email=${encodeURIComponent(data.email)}`);
      })
      .catch(error => {
        console.log(error)
        alert("Failed to register");
      });
  };

  return (
    <div>
      <h1>RegisterPage</h1>
      <RegisterForm onSubmit={handleSubmit} />
    </div>
  );
};

export default RegisterPage;