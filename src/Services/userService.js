import { Axiosobj } from "./constfile";
 export const signUp=(user)=>{
   return Axiosobj.post('/api/users/Register',user).then((response)=>response.data);
};