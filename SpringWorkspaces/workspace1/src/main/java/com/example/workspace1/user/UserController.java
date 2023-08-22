package com.example.workspace1.user;

import com.example.workspace1.error.ApiError;
import com.example.workspace1.shared.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;
      @PostMapping("api/1.0/users")
      @ResponseStatus(HttpStatus.CREATED)
      public ResponseEntity<?> createUser(@RequestBody User user) {
          String username = user.getUsername();
          ApiError error = new ApiError(400, "Validation error!", "user/api/1.0/users");
          Map<String, String> validationErrors = new HashMap<>();


          if(username==null || username.isEmpty()){
              validationErrors.put("username", "Username cannot be null");
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
          }

          userService.save(user);
          return ResponseEntity.ok(new GenericResponse("User created!"));
      }






}
  /*  @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String createUser(@RequestBody String displayName) {

        userRepository.save(new User(displayName, "sahin"));
        return userRepository.findByName(displayName) + "Saved successfully!";*/





