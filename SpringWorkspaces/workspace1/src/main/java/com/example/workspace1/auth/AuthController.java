package com.example.workspace1.auth;

import com.example.workspace1.error.ApiError;
import com.example.workspace1.shared.Views;
import com.example.workspace1.user.User;
import com.example.workspace1.user.UserRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {
    @Autowired
    UserRepository userRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping(path = "/api/1.0/auth")
    @JsonView(Views.Base.class)
    ResponseEntity<?> handleAuthentication(@RequestHeader(name ="Authorization", required = false) String authorization){
        System.out.print("auth: "+ authorization);
        if (authorization == null){
            ApiError apiError = new ApiError(401,"Unau55thorized request", "/api/1.0/auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);
        }

        String base64encoded = authorization.split("Basic ")[1];
        String decoded = new String(Base64.getDecoder().decode(base64encoded));// user1:password
        String[] parts = decoded.split(":");
        String username = parts[0];
        String password = parts[1];

        User inDb = userRepository.findByUsername(username);

        if(inDb ==null){
            ApiError apiError = new ApiError(401,"Unautoııohorized request", "/api/1.0/auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);
        }
        String hashedPassword = inDb.getPassword();
        if(!passwordEncoder.matches(password,hashedPassword)){
            ApiError apiError = new ApiError(401,"Unautoııohorized request", "/api/1.0/auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);
        }


        //username, displayName, image
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("username", inDb.getUsername());
        responseBody.put("displayName", inDb.getDisplayName());
        responseBody.put("image", inDb.getImage());
        responseBody.put("password", inDb.getPassword());
        return ResponseEntity.ok(responseBody);
    }
}
