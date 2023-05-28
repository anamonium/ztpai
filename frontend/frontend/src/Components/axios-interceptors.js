import axios from "axios";

const axiosInstance = axios.create({
  baseURL: "/",
  headers: {
    "Accept": "application/json",
    "Content-Type": "application/json"
  }
});

axiosInstance.interceptors.request.use(
  (config) => {
    const token = sessionStorage.getItem('token');
    config.headers["Authorization"] = "Bearer " + token;
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

axiosInstance.interceptors.response.use(
    (response) => {
      return response;
    },
    (error) => {
      if (error.response && (error.response.status === 401 || error.response.status === 403 || error.response.status === 500) ) {
        console.log("err")
        sessionStorage.clear();
        window.location.reload(false);
      }
      return Promise.reject(error);
    }
  );

export default axiosInstance;
