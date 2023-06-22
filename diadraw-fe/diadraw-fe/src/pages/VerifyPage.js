import React from 'react';
import axios from 'axios';
import VerifyForm from '../components/VerifyForm';
import jwt from 'jwt-decode';
import { useNavigate, useLocation } from 'react-router-dom';

const VerifyPage = () => {

  const navigate = useNavigate();

  const location = useLocation();

  const searchParams = new URLSearchParams(location.search);

  const email = searchParams.get('email');

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
    <div>
      <h1>VerifyPage</h1>
      <VerifyForm onSubmit={handleSubmit} />
    </div>
  );
};

export default VerifyPage;