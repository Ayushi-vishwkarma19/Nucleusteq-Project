import { Axiosobj } from "./constfile";
 export const signUp=(user)=>{
   return Axiosobj.post('/api/users/Register',user).then((response)=>response.data);
};
export const Log=(info)=>{
return Axiosobj.post('/api/users/login',info ,{ headers: {
  'Content-Type': 'application/json'
}
}).then((response)=>response.data);
};










