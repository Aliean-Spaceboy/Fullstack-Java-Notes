package com.example.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking.model.User;
import com.example.banking.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController
{
    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> getAllusers()
    {
    	return userService.getAllUsers();
    	
    }
    @PostMapping("/register")
    
    	public User registerUser (@RequestBody User user)
    	{
    		return userService.registerUser(user);
    	}

    @GetMapping("/{id}")
   
    	public User getUserById(@PathVariable Long id)
    	{
    		return userService.getUserById(id);
    	}
    @PutMapping("/{id}")
    public User UpdateUser (@PathVariable Long id,@RequestBody User UserDetails)
    {
    	return userService.updateUser(id,UserDetails);
    }
    @DeleteMapping
    public void deleteuser (@PathVariable Long id)
    {
    	userService.deleteUser(id);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
