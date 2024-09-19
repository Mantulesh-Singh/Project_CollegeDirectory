// src/components/Enrollment.js
import React, { useState, useEffect } from 'react';
import './Enrollment.css'; // Import the CSS file

const Enrollment = () => {
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    // Fetch courses from API or service
    // Here using a placeholder array for demonstration
    const fetchedCourses = [
      { id: 1, title: 'Introduction to Computer Science', description: 'Learn the basics of computer science.', photo: '/path/to/photo.jpg' },
      { id: 2, title: 'Advanced Mathematics', description: 'Explore advanced topics in mathematics.', photo: '/path/to/photo.jpg' }
    ];
    setCourses(fetchedCourses);
  }, []);

  const handleEnroll = (courseId) => {
    // Implement enrollment logic here
    console.log(`Enrolled in course ${courseId}`);
  };

  return (
    <div className="enrollment-container">
      <h1>Course Enrollment</h1>
      <ul className="course-list">
        {courses.map(course => (
          <li key={course.id} className="course-item">
            <img src={course.photo} alt={course.title} />
            <div className="course-details">
              <h3>{course.title}</h3>
              <p>{course.description}</p>
            </div>
            <div className="enrollment-buttons">
              <button onClick={() => handleEnroll(course.id)}>Enroll</button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Enrollment;
