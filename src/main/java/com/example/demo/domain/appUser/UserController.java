package com.example.demo.domain.appUser;


import com.example.demo.domain.blogPost.BlogPost;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;
import java.security.Principal;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    //    ADD YOUR ENDPOINT MAPPINGS HERE
    private final UserService userService;
    //private UUID currentUserUUID = null;

    @GetMapping("/")
    public ResponseEntity<String> HomeTest() {
        return ResponseEntity.ok().body("Hello World");
    }


    @GetMapping("users")
    public ResponseEntity<Collection<User>> findAll() {
        return new ResponseEntity<Collection<User>>(userService.findAll(), HttpStatus.OK);
    }


    /*public UUID getCurrentUserUUID() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserUUID = getCurrentUserUUID();
        } else {
            currentUserUUID = null;
        }
        return currentUserUUID;
    }*/
}
