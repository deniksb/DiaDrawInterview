import React, { useState } from 'react';
import RegisterFormCSS from '../styles/RegisterForm.module.css';

const VerifyForm = ({ onSubmit, image, phoneNumber }) => {
  const [code, setCode] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    const data = code;

    onSubmit(data);

    setCode('');
  };

  return (
    <div className={RegisterFormCSS.registerformcontainer}>
    <p>A 6-digit code has been sent as a <br></br> text messge to +{phoneNumber}</p>
    <img src={image} />
    <form onSubmit={handleSubmit} className={RegisterFormCSS.registerform}>
      <div className={RegisterFormCSS.inputfieldcontainer}>
        <label className={RegisterFormCSS.formtext}>VERIFICATION CODE</label>
        <input
          type="code"
          value={code}
          onChange={(e) => setCode(e.target.value)}
          placeholder='Enter 6-digit verification code here'
          required
          className={RegisterFormCSS.inputfield}
        />
      </div>
      <button className={RegisterFormCSS.formbutton} type="submit">CONTINUE</button>
    </form>
    <div>
    <p className={RegisterFormCSS.formtext}>Didn't receive code? Resend code</p>
    <p className={RegisterFormCSS.formtext}>OR</p>
    <p className={RegisterFormCSS.formtext}>Send verification code on email</p>
    </div>
    </div>
  );
};

export default VerifyForm;