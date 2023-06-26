import React from 'react';
import LandingCardCSS from '../styles/LandingCard.module.css';

const LandingCard = ({ headingLabel, buttonLabel, image, onClick }) => {
  return (
    <div className={LandingCardCSS.landingcontainer}>
      <img src={image} />
    <div>
      <p>{headingLabel}</p>
      <button className={LandingCardCSS.landingbutton} onClick={onClick}>
      {buttonLabel}
      </button>
    </div>
    </div>
  );
};

export default LandingCard;