import { Card, CardBody, CardHeader, Col, Container, Form, FormGroup, Label, Row,Input,Button } from "reactstrap";
import Base from "../Components/Base";
import { DropdownButton ,Dropdown } from "react-bootstrap";

const Login=()=>{
    return(
      <Base>
      <Container>
        <Row>
          <Col sm={{size:6,offset:3}}>
            <Card>
              <CardHeader>
                <h1>Login here !</h1>
              </CardHeader>
              <CardBody>
                <Form>
                  {/*email field */}
                  <FormGroup>
                    <Label for="email">Email</Label>
                    <Input type="email" placeholder="Enter email"/>
                  </FormGroup>
                   {/*password field */}
                   <FormGroup>
                    <Label for="password">password</Label>
                    <Input type="password" placeholder="Enter password"/>
                  </FormGroup>
                  <FormGroup>
                    <Label for="utype">UserType</Label>
                    <DropdownButton id="utype" title="UserType" variant="secondary">
                    <Dropdown.Item >Admin</Dropdown.Item>
                    <Dropdown.Item >Employee</Dropdown.Item>
                    </DropdownButton>
                  </FormGroup>
                  {/*Button field*/}
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
   }
   
   export default Login;