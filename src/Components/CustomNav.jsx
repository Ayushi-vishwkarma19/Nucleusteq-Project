
import 'bootstrap/dist/css/bootstrap.min.css';  
import { Navbar, Container, Nav, NavDropdown,  } from 'react-bootstrap';  
const CustomNav =()  =>{  
  return (  
     
      <Navbar collapseOnSelect expand="lg" bg="secondary"  variant="dark">  
        <Container>  
          <Navbar.Brand href="/">Inventory Management</Navbar.Brand>  
          
            <Nav className="me-auto">  
            
             <Nav.Link href="/about">About</Nav.Link>
              <Nav.Link href="/login">Login</Nav.Link>  
              <Nav.Link href="/signup">Signup</Nav.Link>  
              <NavDropdown title="More" id="collasible-nav-dropdown">  
                <NavDropdown.Item href="#action/3.1">Option 1</NavDropdown.Item>  
                <NavDropdown.Item href="#action/3.2">Option 2</NavDropdown.Item>  
                <NavDropdown.Item href="#action/3.3">Option 3</NavDropdown.Item>  
                <NavDropdown.Divider />  
                <NavDropdown.Item href="#action/3.4">Separated Item</NavDropdown.Item>  
              </NavDropdown>  
            </Nav>  
            <Nav>  
              
              <Nav.Link eventKey={1} href="#memes">  
                 Link  
              </Nav.Link>  
            </Nav>  
            
        </Container>  
      </Navbar>  
    
  );  
}  
export default CustomNav;  
