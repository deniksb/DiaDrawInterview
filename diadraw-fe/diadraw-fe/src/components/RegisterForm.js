import React, { useState } from 'react';
import FormCSS from '../styles/Form.module.css';

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
    <div className={FormCSS.registerformcontainer}>
    <p>Enter your mobile no. & email id</p>
    <img src={image} />
    <form onSubmit={handleSubmit} className={FormCSS.registerform}>
    <div className={FormCSS.inputfieldcontainer}>
        <label className={FormCSS.formtext}>MOBILE NO.</label>
        <input
          type="tel"
          value={phoneNumber}
          placeholder='Enter your mobile no.'
          onChange={(e) => setPhoneNumber(e.target.value)}
          required
          className={FormCSS.inputfield}
        />
      </div>
      <div className={FormCSS.inputfieldcontainer}>
        <label className={FormCSS.formtext}>EMAIL ADDRESS</label>
        <input
          type="email"
          value={email}
          placeholder='Enter your email id'
          onChange={(e) => setEmail(e.target.value)}
          required
          className={FormCSS.inputfield}
        />
      </div>
      <button className={FormCSS.formbutton} type="submit">CONTINUE</button>
    </form>
    <p className={FormCSS.formtext}>By signing up, I agree to the <a href='#'>Privacy Policy</a> & <a href='#'>Terms of Use</a></p>
    </div>
  );
};

export default RegisterForm;
