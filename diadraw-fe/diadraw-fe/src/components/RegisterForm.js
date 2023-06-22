import React, { useState } from 'react';
import axios from 'axios';

const RegisterForm = ({ onSubmit }) => {
  const [email, setEmail] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    // Create the request payload
    const data = { email, phoneNumber };

    // Call the onSubmit function with the payload
    onSubmit(data);

    // Reset the form fields
    setEmail('');
    setPhoneNumber('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Email:</label>
        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
      </div>
      <div>
        <label>Phone Number:</label>
        <input
          type="tel"
          value={phoneNumber}
          onChange={(e) => setPhoneNumber(e.target.value)}
          required
        />
      </div>
      <button type="submit">Submit</button>
    </form>
  );
};

export default RegisterForm;
