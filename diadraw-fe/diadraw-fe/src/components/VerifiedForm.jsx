import React, { useState } from 'react';
import FormCSS from '../styles/Form.module.css';

const VerifyForm = ({image}) => {

  return (
    <div className={FormCSS.registerformcontainer}>
    <div className={FormCSS.inputfieldcontainer}>
    <img src={image} />
    <p>Verification successful!</p>
    </div>
    </div>
  );
};

export default VerifyForm;