package com.InventoryManagement.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
import com.InventoryManagement.Payloads.*;
import com.InventoryManagement.Services.UserService;
import com.InventoryManagement.entities.User;
import com.InventoryManagement.repository.UserRepo;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("/api/users/Register")

public class UserController {
   
	@Autowired
	private UserService userService;
	private  UserRepo userRepo;
	
	public UserController(UserRepo userRepo)
	{
		this.userRepo=userRepo;
	}
	
	@PostMapping("/Register")
	public ResponseEntity<Userdatatransfer> createUser(@RequestBody Userdatatransfer userDto){
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
	
	 @GetMapping("/login")
	    public String showLoginForm() {
	        return "login";
	    }
	 @PostMapping("/login{email}{password}")
	    public String processLogin(@RequestParam("email") String username,
	                               @RequestParam("password") String password,
	                              
	                               Model model) {
	        User user = userRepo.findByEmail(username);
            
	        if (user != null && user.getPassword().equals(password)) {
	            // Authentication successful
	            return "Admin login";
	        } else {
	            // Authentication failed
	            model.addText("error: Invalid username or password");
	            return "Invalid info";
	        }
	        
             
	    }
	    
	

}