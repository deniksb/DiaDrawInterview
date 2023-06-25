import React, { useState } from 'react';
import FormCSS from '../styles/Form.module.css';

const VerifyForm = ({ onSubmit, image, text, redirectUrl }) => {
  const [code, setCode] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    const data = code;

    onSubmit(data);

    setCode('');
  };

  return (
    <div className={FormCSS.registerformcontainer}>
    <p className={FormCSS.titleText}>{text}</p>
    <img src={image} />
    <form onSubmit={handleSubmit} className={FormCSS.registerform}>
      <div className={FormCSS.inputfieldcontainer}>
        <label className={FormCSS.formtext}>VERIFICATION CODE</label>
        <input
          type="code"
          value={code}
          onChange={(e) => setCode(e.target.value)}
          placeholder='Enter 6-digit verification code here'
          required
          className={FormCSS.inputfield}
        />
      </div>
      <button className={FormCSS.formbutton} type="submit">CONTINUE</button>
    </form>
    <div className={FormCSS.footerText}>
    <p className={FormCSS.formtext}>Didn't receive code? <a href="#">Resend code</a></p>
    <p className={FormCSS.formtext}>OR</p>
    <p className={FormCSS.formtext}><a href={redirectUrl}>Send verification code on email</a></p>
    </div>
    </div>
  );
};

export default VerifyForm;