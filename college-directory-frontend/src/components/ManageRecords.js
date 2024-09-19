// src/components/ManageRecords.js
import React, { useState, useEffect } from 'react';
import './ManageRecords.css'; // Import the CSS file

const ManageRecords = () => {
  const [records, setRecords] = useState([]);

  useEffect(() => {
    // Fetch records from API or service
    // Example placeholder data
    const fetchedRecords = [
      { id: 1, name: 'John Doe', role: 'Student', email: 'john.doe@example.com' },
      { id: 2, name: 'Jane Smith', role: 'Faculty Member', email: 'jane.smith@example.com' }
    ];
    setRecords(fetchedRecords);
  }, []);

  const handleEdit = (id) => {
    // Handle edit action
    console.log(`Edit record with id: ${id}`);
  };

  const handleDelete = (id) => {
    // Handle delete action
    console.log(`Delete record with id: ${id}`);
  };

  return (
    <div className="manage-records-container">
      <div className="manage-records-header">
        <h1>Manage Records</h1>
        <button onClick={() => console.log('Add new record')}>Add New Record</button>
      </div>
      <table className="records-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Role</th>
            <th>Email</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {records.map(record => (
            <tr key={record.id}>
              <td>{record.id}</td>
              <td>{record.name}</td>
              <td>{record.role}</td>
              <td>{record.email}</td>
              <td className="action-buttons">
                <button onClick={() => handleEdit(record.id)}>Edit</button>
                <button onClick={() => handleDelete(record.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ManageRecords;
