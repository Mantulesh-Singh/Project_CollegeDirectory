import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import AuthService from './services/AuthService';
import Login from './components/Login';
import StudentDashboard from './components/StudentDashboard';
import FacultyDashboard from './components/FacultyDashboard';
import AdminDashboard from './components/AdminDashboard';
import NotFound from './components/NotFound'; // Correct import
import PrivateRoute from './components/PrivateRoute'; // Correct import

function App() {
  const [currentUser, setCurrentUser] = useState(null);

  useEffect(() => {
    AuthService.setupAxiosInterceptors();
    const user = AuthService.getCurrentUser();
    setCurrentUser(user);
  }, []);

  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/login" element={<Login />} />
          
          <Route
            path="/student-dashboard"
            element={
              <PrivateRoute role="STUDENT" currentUser={currentUser}>
                <StudentDashboard />
              </PrivateRoute>
            }
          />
          <Route
            path="/faculty-dashboard"
            element={
              <PrivateRoute role="FACULTY_MEMBER" currentUser={currentUser}>
                <FacultyDashboard />
              </PrivateRoute>
            }
          />
          <Route
            path="/admin-dashboard"
            element={
              <PrivateRoute role="ADMINISTRATOR" currentUser={currentUser}>
                <AdminDashboard />
              </PrivateRoute>
            }
          />

          <Route
            path="/"
            element={
              currentUser ? (
                currentUser.role === "STUDENT" ? (
                  <Navigate to="/student-dashboard" />
                ) : currentUser.role === "FACULTY_MEMBER" ? (
                  <Navigate to="/faculty-dashboard" />
                ) : currentUser.role === "ADMINISTRATOR" ? (
                  <Navigate to="/admin-dashboard" />
                ) : (
                  <Navigate to="/login" />
                )
              ) : (
                <Navigate to="/login" />
              )
            }
          />

          <Route path="*" element={<NotFound />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
