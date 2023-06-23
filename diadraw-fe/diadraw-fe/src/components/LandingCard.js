import React from 'react';
import LandingCardCSS from '../styles/LandingCard.module.css';

const LandingCard = ({ headingLabel, buttonLabel, onClick }) => {
  return (
    <div className={LandingCardCSS.landingcontainer}>
    <p>{headingLabel}</p>
    <button className="button" onClick={onClick}>
    {buttonLabel}
    </button>
    </div>
  );
};

export default LandingCard;