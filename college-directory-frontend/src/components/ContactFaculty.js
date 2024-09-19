// src/components/ContactFaculty.js
import React, { useState, useEffect } from 'react';
import './ContactFaculty.css'; // Import the CSS file

const ContactFaculty = () => {
  const [facultyMembers, setFacultyMembers] = useState([]);

  useEffect(() => {
    // Fetch faculty members from API or service
    // Here using a placeholder array for demonstration
    const fetchedFacultyMembers = [
      { id: 1, name: 'Dr. Alice Johnson', photo: '/path/to/photo.jpg', email: 'alice@example.com', phone: '123-456-7890' },
      { id: 2, name: 'Prof. Bob Brown', photo: '/path/to/photo.jpg', email: 'bob@example.com', phone: '987-654-3210' }
    ];
    setFacultyMembers(fetchedFacultyMembers);
  }, []);

  return (
    <div className="contact-faculty-container">
      <h1>Contact Faculty Advisors</h1>
      <ul className="faculty-list">
        {facultyMembers.map(faculty => (
          <li key={faculty.id} className="faculty-item">
            <img src={faculty.photo} alt={faculty.name} width="50" height="50" />
            <div className="faculty-details">
              <h3>{faculty.name}</h3>
              <p>Email: <a href={`mailto:${faculty.email}`}>{faculty.email}</a></p>
              <p>Phone: <a href={`tel:${faculty.phone}`}>{faculty.phone}</a></p>
            </div>
            <div className="contact-buttons">
              <a href={`mailto:${faculty.email}`}>Email</a>
              <a href={`tel:${faculty.phone}`}>Call</a>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ContactFaculty;
