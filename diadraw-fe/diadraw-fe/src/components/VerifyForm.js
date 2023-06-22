import React, { useState } from 'react';
import axios from 'axios';

const VerifyForm = ({ onSubmit }) => {
  const [code, setCode] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    const data = code;

    onSubmit(data);

    setCode('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Code:</label>
        <input
          type="code"
          value={code}
          onChange={(e) => setCode(e.target.value)}
          required
        />
      </div>
      <button type="submit">Submit</button>
    </form>
  );
};

export default VerifyForm;