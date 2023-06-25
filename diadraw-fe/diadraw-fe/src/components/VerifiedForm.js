import React, { useState } from 'react';
import RegisterFormCSS from '../styles/RegisterForm.module.css';

const VerifyForm = ({image}) => {

  return (
    <div className={RegisterFormCSS.registerformcontainer}>
    <img src={image} />
    <p>Verification successful!</p>
    </div>
  );
};

export default VerifyForm;