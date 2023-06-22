import {Navigate, Outlet} from 'react-router-dom';

const useAuth = () => {
    
    const jwt = localStorage.getItem('jwt_authorization');

    console.log(jwt);

    return jwt;
};

const ProtectedRoutes = () => {
    const isAuth = useAuth();
    return isAuth ? <Outlet /> : <Navigate to="/" />;
}

export default ProtectedRoutes;