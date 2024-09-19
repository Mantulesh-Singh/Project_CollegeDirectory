// src/components/ProfileView.js
import React, { useState, useEffect } from 'react';
import './ProfileView.css'; // Import the CSS file

const ProfileView = ({ userId }) => {
  const [profile, setProfile] = useState(null);

  useEffect(() => {
    // Fetch profile data from API
    // Example placeholder data
    const fetchedProfile = {
      id: userId,
      name: 'John Doe',
      email: 'john.doe@example.com',
      phone: '123-456-7890',
      department: 'Computer Science',
      photo: 'https://via.placeholder.com/120',
      role: 'Student' // or 'Faculty Member', 'Administrator'
    };
    setProfile(fetchedProfile);
  }, [userId]);

  if (!profile) return <div>Loading...</div>;

  return (
    <div className="profile-view-container">
      <div className="profile-header">
        <img src={profile.photo} alt={`${profile.name}'s profile`} />
        <div>
          <h1>{profile.name}</h1>
          <p><strong>Email:</strong> {profile.email}</p>
          <p><strong>Phone:</strong> {profile.phone}</p>
          <p><strong>Department:</strong> {profile.department}</p>
          <p><strong>Role:</strong> {profile.role}</p>
        </div>
      </div>
      <div className="profile-actions">
        <button onClick={() => console.log('Edit profile')}>Edit Profile</button>
        <button onClick={() => console.log('Back to list')}>Back</button>
      </div>
    </div>
  );
};

export default ProfileView;
