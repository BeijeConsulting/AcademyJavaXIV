import axios from "axios";

// config
import { BASEURL, TIMEOUT } from "./config";

const axiosInstance = axios.create({
    baseURL: BASEURL,
    timeout: TIMEOUT
})

// axiosInstance.interceptors.response.use(function (response) {
//     // Any status code that lie within the range of 2xx cause this function to trigger
//     // Do something with response data
//     return response;
//   }, function (error) {
//     const originalRequest = error.config;
//     // Any status codes that falls outside the range of 2xx cause this function to trigger
//     // Do something with response error
//     if (error.response.status === 401 &&
//       originalRequest.url === `${BASEURL}/updateAuthToken`) {
//       return Promise.reject(error);
//     }

//     if (error.response.status === 401 && !originalRequest._retry) {
//       originalRequest._retry = true

//       //api call updateAuthToken
//       if (localStorage.getItem('refreshToken') !== null) {

//         updateAuthTokenPostApi().then(res => {
//           const { token, refreshToken } = res.data;
//           setLocalStorage('token', token);
//           setLocalStorage('refreshToken', refreshToken);
//           axios.defaults.headers.common['Authorization'] = 'Bearer' + getLocalStorage("token");
//         });
//       }
//     }

//     return Promise.reject(error);
//   });

export function responseApi(response) {
    //general function for get the response
    return response?.data;
}

export function responseApiError(error) {
    //general function in case of wrong api call
    return {
        message: error?.message,
        status: error?.status,
    };
}

export async function postApi(resource, obj) {
    return axiosInstance
        .post(resource, obj)
        .then(responseApi())
        .catch(responseApiError());
}

export async function getApi(resource) {
    //function for get api call
    return axiosInstance
        .get(resource)
        .then(responseApi())
        .catch(responseApiError());
}

export async function putApi(resource, obj) {
    //function for put api call
    return axiosInstance
        .put(resource, obj)
        .then(responseApi())
        .catch(responseApiError());
}

export async function deleteApi(resource) {
    return axiosInstance
        .delete(resource)
        .then(responseApi())
        .catch(responseApiError());
}
