package com.example.projectk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectk.model.Users;
import com.example.projectk.repository.BookRepository;
import com.example.projectk.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController 
{

    @Autowired
    UserRepository ur;



     @PostMapping("/register")
     ResponseEntity<?> register(@RequestBody Users u)
     {
          Users result=this.ur.findByUsername(u.getUsername());
          if(result != null)
          {
              return ResponseEntity.status(HttpStatus.CONFLICT).body("book already exist");
          }
          this.ur.save(u);
           return ResponseEntity.status(HttpStatus.CREATED).body("book successfully added");
     }

     @PostMapping("/login")
     ResponseEntity<?> Login(@RequestBody Users u)
     {
          Users result=this.ur.findByUsername(u.getUsername());
          if(result != null && result.getPassword().equals(u.getPassword()))
          {
             return ResponseEntity.status(HttpStatus.CREATED).body("login successfully done...");
          }
         
          return ResponseEntity.status(HttpStatus.CONFLICT).body("invalid credentials");
     }
}
