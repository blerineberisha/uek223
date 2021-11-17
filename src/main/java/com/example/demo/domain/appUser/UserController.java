package com.example.demo.domain.appUser;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class UserController {
    //    ADD YOUR ENDPOINT MAPPINGS HERE
    private final UserService userService;
    //private UUID currentUserUUID = null;

    @GetMapping("/")
    public ResponseEntity<String> HomeTest() {
        return ResponseEntity.ok().body("Hello World");
    }


    @GetMapping("/users")
    public ResponseEntity<Collection<User>> findAll() {
        return new ResponseEntity<Collection<User>>(userService.findAll(), HttpStatus.OK);
    }
}
