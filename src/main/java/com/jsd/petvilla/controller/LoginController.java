package com.jsd.petvilla.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsd.petvilla.entity.Login;
import com.jsd.petvilla.service.LoginService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class LoginController {
    @Autowired
    LoginService ls;

    //Endpoint for user login and generating a JWT token
    @PostMapping("/login")
    public String validate(@RequestBody Login user) throws ServletException {
        String jwtToken = "";

        //checking if username and password are null. If yes, throws an exception
        if (user.getUsername() == null || user.getPassword() == null) {
            throw new ServletException("Mandatory to fill username & password");
        }

        // extracting username and password from user object 
        String username = user.getUsername();
        String password = user.getPassword();

        // Generating a JWT token with the user's username and role
        jwtToken = Jwts.builder()
                .setSubject(username).claim("roles", "user")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        //logging in
        user = ls.loginUser(username, password, jwtToken);

        //if user details not found/ not matched, throw an exception
        if (user == null) {
            throw new ServletException("User details not found");
        }
        return jwtToken;
    }
    
    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody Login credientials) {
    	return new ResponseEntity<String>(ls.registerUser(credientials), HttpStatus.CREATED);
    }
    
    @GetMapping("/checkUsernameAvailability/{username}")
    public boolean checkUsernameAvailability(@PathVariable String username) {
        return ls.isUsernameAvailable(username);
    }
}
