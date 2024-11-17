package com.example.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banking.exception.ResourceNotFoundException;
import com.example.banking.model.User;
import com.example.banking.repo.UserRepository;

@Service
public class UserService
{
      @Autowired
      private UserRepository userRepository;
      
      public List<User>getAllUsers()
      {
    	  return userRepository.findAll();
      }
      public User getUserById(Long id) 
      {
    	  return userRepository.findById(id)
    			  .orElseThrow(() -> new ResourceNotFoundException("User Not Found With id:"+id));
      }
      public User getUserByUsername(String username)
      {
    	  return userRepository.findByUsername(username);
      }
      public User registerUser (User user)
      {
    	  return userRepository.save(user);
      }
      public User updateUser(Long id,User userDetails)
      {
    	  User user=getUserById(id);
    	  user.setUsername(userDetails.getUsername());
    	  user.setPassword(userDetails.getPassword());
    	  return userRepository.save(user);
      }
      public void deleteUser(Long id)
      {
          User user = userRepository.findById(id)
              .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
          userRepository.delete(user);
      }
      
}
