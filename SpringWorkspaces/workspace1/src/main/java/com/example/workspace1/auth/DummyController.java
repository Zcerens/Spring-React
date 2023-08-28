package com.example.workspace1.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @GetMapping(path = "/secured")
    String securedPath(){
        return "Secured place";
    }
}
