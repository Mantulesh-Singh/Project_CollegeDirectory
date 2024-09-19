import axios from 'axios';

const API_URL = "http://localhost:8080/api/user";

const getStudentProfile = () => {
  return axios.get(API_URL + "/student/profile", {
    headers: { Authorization: `Bearer ${localStorage.getItem("token")}` },
  });
};

const getEnrolledCourses = () => {
  return axios.get(API_URL + "/student/courses", {
    headers: { Authorization: `Bearer ${localStorage.getItem("token")}` },
  });
};

export default {
  getStudentProfile,
  getEnrolledCourses,
};
