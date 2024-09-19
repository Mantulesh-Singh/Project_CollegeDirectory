// src/components/FacultyDashboard.js
import React, { useState, useEffect } from 'react';
import './FacultyDashboard.css'; // Import the CSS file

const FacultyDashboard = () => {
  const [profile, setProfile] = useState({});
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    // Fetch faculty profile and courses from API or service
    // Here using placeholder data for demonstration
    const fetchedProfile = {
      name: 'Dr. John Doe',
      email: 'john.doe@example.com',
      phone: '123-456-7890',
      photo: '/path/to/photo.jpg'
    };
    const fetchedCourses = [
      { id: 1, title: 'Introduction to Computer Science', description: 'Basics of computer science.', photo: '/path/to/photo.jpg' },
      { id: 2, title: 'Advanced Algorithms', description: 'Study of complex algorithms.', photo: '/path/to/photo.jpg' }
    ];
    setProfile(fetchedProfile);
    setCourses(fetchedCourses);
  }, []);

  return (
    <div className="dashboard-container">
      <div className="dashboard-header">
        <h1>Faculty Dashboard</h1>
      </div>
      <div className="profile-card">
        <img src={profile.photo} alt={profile.name} />
        <h2>{profile.name}</h2>
        <p>Email: {profile.email}</p>
        <p>Phone: {profile.phone}</p>
      </div>
      <div>
        <h2>Courses</h2>
        <ul className="course-list">
          {courses.map(course => (
            <li key={course.id} className="course-item">
              <img src={course.photo} alt={course.title} />
              <div className="course-details">
                <h3>{course.title}</h3>
                <p>{course.description}</p>
              </div>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default FacultyDashboard;
