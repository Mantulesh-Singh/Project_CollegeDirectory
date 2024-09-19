// src/components/AdminDashboard.js
import React from 'react';
import './AdminDashboard.css'; // Import the CSS file

const AdminDashboard = () => {
  return (
    <div className="admin-dashboard">
      <h1>Administrator Dashboard</h1>
      <div className="dashboard-content">
        <div className="dashboard-section">
          <h2>Manage Student Records</h2>
          <button>Manage Records</button>
        </div>
        <div className="dashboard-section">
          <h2>View Reports</h2>
          <button>View Reports</button>
        </div>
        <div className="dashboard-section">
          <h2>Settings</h2>
          <button>Settings</button>
        </div>
      </div>
    </div>
  );
};

export default AdminDashboard;
