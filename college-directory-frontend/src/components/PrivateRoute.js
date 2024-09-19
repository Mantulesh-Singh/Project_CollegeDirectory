// src/components/PrivateRoute.js
import React from 'react';
import { Navigate } from 'react-router-dom';

const PrivateRoute = ({ children, role, currentUser }) => {
  if (!currentUser) {
    // Not logged in, redirect to login page
    return <Navigate to="/login" />;
  }

  if (currentUser.role !== role) {
    // Logged in but not authorized, redirect to default or error page
    return <Navigate to="/" />;
  }

  // Authorized, render the component
  return children;
};

export default PrivateRoute;
