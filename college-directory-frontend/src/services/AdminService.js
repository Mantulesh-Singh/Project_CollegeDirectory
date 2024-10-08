import axios from 'axios';

const API_URL = "http://localhost:8080/api/auth";

const login = (username, password, role) => {
  return axios
    .post(API_URL + "/login", { username, password, role })
    .then((response) => {
      localStorage.setItem("user", JSON.stringify(response.data));
    });
};

const logout = () => {
  localStorage.removeItem("user");
};

export default {
  login,
  logout,
};
