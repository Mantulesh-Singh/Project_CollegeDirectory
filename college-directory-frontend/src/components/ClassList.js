// src/components/ClassList.js
import React, { useState, useEffect } from 'react';
import './ClassList.css'; // Import the CSS file

const ClassList = () => {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    // Fetch student list from API or service
    // Here using a placeholder array for demonstration
    const fetchedStudents = [
      { id: 1, name: 'John Doe', photo: '/path/to/photo.jpg', email: 'john@example.com' },
      { id: 2, name: 'Jane Smith', photo: '/path/to/photo.jpg', email: 'jane@example.com' }
    ];
    setStudents(fetchedStudents);
  }, []);

  return (
    <div className="class-list-container">
      <h1>Class List</h1>
      <ul className="student-list">
        {students.map(student => (
          <li key={student.id} className="student-item">
            <img src={student.photo} alt={student.name} width="50" height="50" />
            <div className="student-details">
              <h3>{student.name}</h3>
              <p>Email: {student.email}</p>
            </div>
            <button>Contact</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ClassList;
