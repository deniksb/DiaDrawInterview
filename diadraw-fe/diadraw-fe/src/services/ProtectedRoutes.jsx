import { Navigate, Outlet } from 'react-router-dom';
import axios from 'axios';
import { useEffect, useState } from 'react';

const useAuth = () => {
  const [isAuth, setIsAuth] = useState(false);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const authenticate = async () => {
      try {
        const jwt = localStorage.getItem('jwt_authorization');
        const response = await axios.post("http://localhost:8080/authenticate", { token: jwt });
        console.log(response.data);
        setIsAuth(true);
      } catch (error) {
        console.log(error);
        setIsAuth(false);
      } finally {
        setIsLoading(false);
      }
    };

    authenticate();
  }, []);

  return { isAuth, isLoading };
};

const ProtectedRoutes = () => {
  const { isAuth, isLoading } = useAuth();

  if (isLoading) {
    return <div>Loading...</div>;
  }

  return isAuth ? <Outlet /> : <Navigate to="/" />;
};

export default ProtectedRoutes;

