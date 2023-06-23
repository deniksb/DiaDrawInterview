import React, { useState } from 'react';
import RegisterFormCSS from '../styles/RegisterForm.module.css';

const RegisterForm = ({ image, onSubmit }) => {
  const [email, setEmail] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    const data = { email, phoneNumber };

    onSubmit(data);

    setEmail('');
    setPhoneNumber('');
  };

  return (
    <div className={RegisterFormCSS.registerformcontainer}>
    <p>Enter your mobile no. & email id</p>
    <img src={image} />
    <form onSubmit={handleSubmit}>
    <div className={RegisterFormCSS.inputfieldcontainer}>
        <label>MOBILE NO.</label>
        <input
          type="tel"
          value={phoneNumber}
          onChange={(e) => setPhoneNumber(e.target.value)}
          required
          className={RegisterFormCSS.inputfield}
        />
      </div>
      <div className={RegisterFormCSS.inputfieldcontainer}>
        <label>EMAIL ADDRESS</label>
        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
          className={RegisterFormCSS.inputfield}
        />
      </div>
      <button type="submit">CONTINUE</button>
    </form>
    <p className={RegisterFormCSS.termstext}>By signing up, I agree to the <a href='#'>Privacy Policy</a> & <a href='#'>Terms of Use</a></p>
    </div>
  );
};

export default RegisterForm;
