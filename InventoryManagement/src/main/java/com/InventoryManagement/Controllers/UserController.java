//Controllers are used to handle incoming HTTP requests and provides responses to the clients
package com.InventoryManagement.Controllers;

import org.springframework.http.MediaType;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.util.MultiValueMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.InventoryManagement.Payloads.*;
import com.InventoryManagement.Services.UserService;
import com.InventoryManagement.Services.impl.UserDetailServiceImpl;
import com.InventoryManagement.entities.User;
import com.InventoryManagement.repository.UserRepo;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/users")

@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
   
	@Autowired
	private  PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;
	@Autowired
	private  UserRepo userRepo;
	@Autowired
	 private UserDetailServiceImpl userDetailServiceImpl;
	
	public UserController(UserRepo userRepo,PasswordEncoder passwordEncoder)
	{
		this.userRepo=userRepo;
		 this.passwordEncoder = passwordEncoder;
	}
	
	//Register Method
	@PostMapping("/Register")
	public ResponseEntity<Userdatatransfer> createUser(@Validated @RequestBody Userdatatransfer userDto){
		Userdatatransfer createdUserDto=this.userService.CreateUser(userDto);
		return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<Userdatatransfer>updateUser(@RequestBody Userdatatransfer userDto,@PathVariable("userId") Integer Id){
	  Userdatatransfer updatedUser=this.userService.updateUser(userDto, Id);
	  return ResponseEntity.ok(updatedUser);
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<?>deleteUser(@PathVariable("userId")Integer Id)
	{
		this.userService.deleteUser(Id);
		return new ResponseEntity(Map.of("message","Information deleted Successfully."),HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<Userdatatransfer>> getAll()
	{
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	@GetMapping("/{userId}")
	public ResponseEntity<Userdatatransfer> getUser(@PathVariable("userId")Integer Id)
	{
		return ResponseEntity.ok(this.userService.getUserById(Id));
	}
	
	
	//Login Method
	
	 @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Userdatatransfer> log(@Validated @RequestBody Map<String, String> request,
	                                   HttpServletResponse response) throws IOException {
	    String email = request.get("email");
	    String password=request.get("password");
	    String accountType=request.get("accountType");
	     User user = userRepo.findByEmail(email);
	    // System.out.println("email:"+email);
	     //System.out.println("Request Payload: " + request.toString());
	     if (user != null) {
	         boolean verify = passwordEncoder.matches(password, user.getPassword());
	         	         if (verify && user.getAccountType().equals(accountType)) {
	             if (user.getAccountType().equals("Admin")) {
	            	return ResponseEntity.ok(this.userService.getUserByEmail(email));
	             } else if (user.getAccountType().equals("Employee")) {
	            	return ResponseEntity.ok(this.userService.getUserByEmail(email));
	             }
	         }
	     }
	     
	     Userdatatransfer errorData = new Userdatatransfer();
	     errorData.setMessage("Invalid Credentials");
	     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorData);
	 }

}