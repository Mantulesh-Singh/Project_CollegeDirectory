// src/components/StudentDashboard.js
import React from 'react';
import './StudentDashboard.css'; // Import the CSS file

const StudentDashboard = ({ student }) => {
  return (
    <div className="dashboard-container">
      <div className="dashboard-header">
        <h1>Student Dashboard</h1>
        {/* You can add more header elements here if needed */}
      </div>
      <div className="dashboard-content">
        <section className="student-info">
          <img src={student.photo} alt="Student" />
          <div>
            <h2>{student.name}</h2>
            <p>Department: {student.department}</p>
            <p>Year: {student.year}</p>
          </div>
        </section>
        <section>
          <h2>Courses</h2>
          <ul className="courses-list">
            {student.courses.map(course => (
              <li key={course.id}>{course.title}</li>
            ))}
          </ul>
        </section>
        <section>
          <h2>Grades</h2>
          <ul className="grades-list">
            {student.grades.map(grade => (
              <li key={grade.courseId}>
                {grade.courseTitle}: {grade.grade}
              </li>
            ))}
          </ul>
        </section>
      </div>
    </div>
  );
};

export default StudentDashboard;
