import axios from "axios";
export const BASE_URL='http://localhost:9090';

export const Axiosobj=axios.create({
    baseURL:BASE_URL
});