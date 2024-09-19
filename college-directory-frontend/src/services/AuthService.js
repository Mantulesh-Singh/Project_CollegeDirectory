import axios from 'axios';

// Define the API base URL
const API_URL = "http://localhost:8080/api/auth/";

class AuthService {
  // Login function, takes username and password, sends to backend, and stores the token
  login(username, password) {
    return axios
      .post(API_URL + "login", {
        username,
        password,
      })
      .then((response) => {
        if (response.data.token) {
          // Store the JWT token in localStorage for authenticated requests
          localStorage.setItem("user", JSON.stringify(response.data));
        }
        return response.data;
      });
  }

  // Logout function clears the token from localStorage
  logout() {
    localStorage.removeItem("user");
  }

  // Register a new user
  register(name, username, email, password, role) {
    return axios.post(API_URL + "register", {
      name,
      username,
      email,
      password,
      role,
    });
  }

  // Get the current user from localStorage (used for role-based access control)
  getCurrentUser() {
    return JSON.parse(localStorage.getItem("user"));
  }

  // Check if user is authenticated by verifying the token in localStorage
  isAuthenticated() {
    const user = this.getCurrentUser();
    return user && user.token;
  }

  // Get the token for authenticated API requests
  getAuthToken() {
    const user = this.getCurrentUser();
    return user ? user.token : null;
  }

  // Axios interceptor for authenticated API requests, attaches the token in headers
  setupAxiosInterceptors() {
    axios.interceptors.request.use(
      (config) => {
        const token = this.getAuthToken();
        if (token) {
          config.headers.Authorization = `Bearer ${token}`;
        }
        return config;
      },
      (error) => {
        return Promise.reject(error);
      }
    );
  }
}

export default new AuthService();
