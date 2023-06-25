import { Card,CardBody,CardHeader,Label,Button,Form,FormGroup,Container,Row,Col,Input } from "reactstrap";

import Base from "../Components/Base";
import { useEffect, useState } from "react";
import {toast} from'react-toastify';
import { Log } from '../Services/userService';
const LoginForm = () => {
  const[data,setData]=useState({    //data is current state and setdata is a function that updates the state.
    
    email:'',
    password:'',
    accountType:'',
   })
  
   //useEffect hooks allows to perform side effect in our components.
   useEffect(()=>{
    console.log(data)
   },
  [data]
   )

    {/* handleChange function*/}
    const handleChange=(event,field)=>{
      //Dynamically setting of data
      setData({...data,[field]:event.target.value});
      
     }
     const submitForm=async(event)=>
     {
        event.preventDefault()
        console.log(data)
        //call server api for sending data
        
        await Log(data).then((resp)=>{
          console.log(resp)
          console.log("success log");
          toast.success("Login Successful");
        
    
          // Redirect to the desired page after successful login
         
  
        }).catch((error)=>{
          toast.error("Invalid Credentials");
          console.log(error);
          console.log("Error Log")
        })
  
     }
  
     return(
      <Base>
      <Container>
       <Row>
        <Col sm={{size:6,offset:3}}>
        <Card>
          <CardHeader>
            <h2>Login Here !!</h2>
          </CardHeader>
          <CardBody>
            {/*Starting of form */}
            <Form onSubmit={submitForm}>
             
                {/*Email field */}
                <FormGroup>

                <Label for="email">Email</Label>
                <Input type="email" placeholder="Enter email" id="email"onChange={(e)=>handleChange(e,'email')}/>
              </FormGroup>
                {/*password field */}
                <FormGroup>

                <Label for="password">Password</Label>
                <Input type="password" placeholder="Enter password" id="password"onChange={(e)=>handleChange(e,'password')}/>
              </FormGroup>
               
               
                {/*accountType field */}
                <FormGroup>

                <Label for="accountType">Account</Label>
                <Input type="text" placeholder="Enter here" id="accountType" onChange={(ev)=>handleChange(ev,'accountType')}/>
              </FormGroup>
              <Container className="text-center">
                <Button color="dark">Login</Button>
                <Button color="secondary"type="reset" className="ms-2">Reset</Button>
              </Container>
            </Form>
          </CardBody>
        </Card>
        </Col>
       </Row>
      </Container>
      </Base>
    );
};

export default LoginForm;
