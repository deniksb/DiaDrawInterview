import React from 'react';
import axios from 'axios';
import RegisterForm from '../components/RegisterForm';
import { useNavigate } from 'react-router-dom';

const LoginPage = () => {

  const navigate = useNavigate();

  const handleSubmit = async (data) => {
    await axios.post("http://localhost:8080/signin", data)
      .then(response => {
        console.log(response.data)
        navigate(`/verify?email=${encodeURIComponent(data.email)}`);
      })
      .catch(error => {
        console.log(error)
      });
  };

  return (
    <div>
      <h1>LoginPage</h1>
      <RegisterForm onSubmit={handleSubmit} />
    </div>
  );
};

export default LoginPage;