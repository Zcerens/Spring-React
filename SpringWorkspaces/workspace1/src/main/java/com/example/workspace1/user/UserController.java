package com.example.workspace1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
      @PostMapping("api/1.0/users")
      public void createUser(@RequestBody User user) {
         userRepository.save(user);


      }




}
  /*  @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String createUser(@RequestBody String displayName) {

        userRepository.save(new User(displayName, "sahin"));
        return userRepository.findByName(displayName) + "Saved successfully!";*/





