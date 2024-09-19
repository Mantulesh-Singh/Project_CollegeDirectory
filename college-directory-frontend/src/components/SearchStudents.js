// src/components/SearchStudents.js
import React, { useState } from 'react';
import './SearchStudents.css'; // Import the CSS file

const SearchStudents = () => {
  const [searchTerm, setSearchTerm] = useState('');
  const [students, setStudents] = useState([]); // Replace with actual student data fetching

  const handleSearch = () => {
    // Implement search logic
    // Example placeholder data
    const foundStudents = [
      { id: 1, name: 'Alice Smith', department: 'Computer Science', photo: 'https://via.placeholder.com/50' },
      { id: 2, name: 'Bob Johnson', department: 'Mathematics', photo: 'https://via.placeholder.com/50' }
    ];
    setStudents(foundStudents);
  };

  return (
    <div className="search-container">
      <div className="search-bar">
        <input
          type="text"
          placeholder="Search students..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
        />
        <button onClick={handleSearch}>Search</button>
      </div>
      <ul className="student-list">
        {students.map(student => (
          <li key={student.id}>
            <div>
              <img src={student.photo} alt={`${student.name}'s profile`} />
              <div>
                <h3>{student.name}</h3>
                <p>Department: {student.department}</p>
              </div>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default SearchStudents;
