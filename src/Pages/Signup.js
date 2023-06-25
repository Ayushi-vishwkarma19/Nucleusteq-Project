import { signUp } from "../Services/userService";

import { Card,CardBody,CardHeader,Label,Button,Form,FormGroup,Container,Row,Col,Input } from "reactstrap";

import Base from "../Components/Base";
import { useEffect, useState } from "react";
import {toast} from'react-toastify';

const Signup=()=>{

   const[data,setData]=useState({    //data is current state and setdata is a function that updates the state.
    name:'',
    email:'',
    password:'',
    phone:'',
    address:'',
    accountType:'',
   })
   const[error,setError]=useState({    
    errors:{},
    isError:false
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

   //Submit form

   const submitForm=(event)=>
   {
      event.preventDefault()
      console.log(data)
      //call server api for sending data

      signUp(data).then((resp)=>{
        console.log(resp)
        console.log(resp.status)
        console.log("success log");
        toast.success("Registration Successful");

      }).catch((error)=>{
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
            <h2>Register yourself !!</h2>
          </CardHeader>
          <CardBody>
            {/*Starting of form */}
            <Form onSubmit={submitForm}>
               {/*Name field */}
              <FormGroup>

                <Label for="name">Name</Label>
                <Input type="text" placeholder="Enter your name" id="name" onChange={(e)=>handleChange(e,'name')}/>
              </FormGroup>
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
                {/*Contact field */}
                <FormGroup>

                <Label for="phone">Contact No.</Label>
                <Input type="text" placeholder="Enter your contact no." id="phone"onChange={(e)=>handleChange(e,'phone')}/>
              </FormGroup>
                {/*Address field */}
                <FormGroup>

                <Label for="address">Address</Label>
                <Input type="text" placeholder="Enter your Address" id="address"onChange={(ev)=>handleChange(ev,'address')}/>
              </FormGroup>
                {/*about field */}
                <FormGroup>

                <Label for="accountType">Account</Label>
                <Input type="text" placeholder="Enter here" id="accountType" onChange={(ev)=>handleChange(ev,'accountType')}/>
              </FormGroup>
              <Container className="text-center">
                <Button color="dark">Register</Button>
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
   }

   export default Signup;