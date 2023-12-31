import React from 'react';
import LandingPage from './pages/LandingPage';
import RegisterPage from './pages/RegisterPage';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import VerifyPhonePage from './pages/VerifyPhonePage';
import VerifyEmailPage from './pages/VerifyEmailPage';
import ProtectedRoutes from './services/ProtectedRoutes';
import VerifiedPage from './pages/VerifiedPage';
import NavBar from './components/NavBar';

const App = () => {

  return (
    <Router>
      <div className="app">
        <NavBar />
        <Routes>
          <Route exact path="/" element={<LandingPage />} />
          <Route exact path="/register" element={<RegisterPage />} />
          <Route exact path="/login" element={<LoginPage />} />
          <Route path="/verify/phone" element={<VerifyPhonePage />} />
          <Route path="/verify/email" element={<VerifyEmailPage />} />
          <Route element={<ProtectedRoutes />}>
          <Route exact path="/verified" element={<VerifiedPage />} />
          </Route>
        </Routes>
      </div>
    </Router>
  );
};

export default App;
