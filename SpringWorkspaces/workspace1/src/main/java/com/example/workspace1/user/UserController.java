package com.example.workspace1.user;

import com.example.workspace1.error.ApiError;
import com.example.workspace1.shared.GenericResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("api/1.0/users")
    @ResponseStatus(HttpStatus.CREATED)
    public GenericResponse createUser(@Valid @RequestBody User user) {
     /*   String username = user.getUsername();
        String dislplayName = user.getDisplayName();

        ApiError error = new ApiError(400, "Validation error!", "user/api/1.0/users");
        Map<String, String> validationErrors = new HashMap<>();


        if (username == null || username.isEmpty()) {
            validationErrors.put("username", "Username cannot be null");
        }

        if (dislplayName == null || dislplayName.isEmpty()) {
            validationErrors.put("displayName", "Displayname cannot be null");
        }

        if (!validationErrors.isEmpty()) {
            error.setValidationErrors(validationErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }*/

        userService.save(user);
        return new GenericResponse("User created!");
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(MethodArgumentNotValidException exception) {
        ApiError error = new ApiError(400, "Validation Error", "user/api/1.0/users");
        Map<String, String> validationErrors = new HashMap<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        error.setValidationErrors(validationErrors);
        return error;
    }



}
  /*  @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String createUser(@RequestBody String displayName) {

        userRepository.save(new User(displayName, "sahin"));
        return userRepository.findByName(displayName) + "Saved successfully!";*/





