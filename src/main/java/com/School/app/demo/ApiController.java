package com.School.app.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
	@Autowired
	UserRepo userRepo;
	
	//@GetMapping(value = "/")
	//public String getPage() {
		//return "Welcome";
	//}
	
	@GetMapping(value= "/users")
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	@PostMapping(value = "/save")
	public String saveUser(@RequestBody User user) {
		
		if(userRepo.existByPhoneNo(user.getPhoneNo())){
			return "PhoneNo already Exist";
			}
		
		userRepo.save(user);
		return "Data Saved in DataBase";
	}
	
	@PutMapping(value = "update/{id}")
	public String updateUser(@PathVariable long id, @RequestBody User user){
		
		User updatedUser = userRepo.findById(id).get();
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setOccupation(user.getOccupation());
		updatedUser.setAge(user.getAge());
		updatedUser.setPhoneNo(user.getPhoneNo());
		userRepo.save(updatedUser);
		return "Updated User info successfully...";
		
	}
	

}
