// src/components/StudentProfile.js
import React from 'react';
import './StudentProfile.css'; // Import the CSS file

const StudentProfile = ({ student }) => {
  return (
    <div className="profile-container">
      <div className="profile-header">
        <img src={student.photo} alt="Student" />
        <h1>{student.name}</h1>
      </div>
      <div className="profile-details">
        <div>
          <h2>Personal Information</h2>
          <p>Email: {student.email}</p>
          <p>Phone: {student.phone}</p>
        </div>
        <div>
          <h2>Academic Information</h2>
          <p>Department: {student.department}</p>
          <p>Year: {student.year}</p>
        </div>
      </div>
    </div>
  );
};

export default StudentProfile;
