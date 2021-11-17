package com.example.demo.domain.security;

import com.example.demo.domain.appUser.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.UUID;

@Component("blogPostSecurity")
public class BlogPostSecurity {
    private UserRepository userRepository;
    public BlogPostSecurity() {

    }

    /**
     * @return returns the current user's username, taken from the request header sent with the request
     */
    public static String getCurrentUsername() {
        //declare the username
        String username;
        //creates object from context and gets currently logged in user as object
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        /*if the principal is an instance of the UserDetail class, the username equals get username from
         principal of UserDetails */
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            /*if principal is not an instance of UserDetails, username equals principal (which is the logged in user)
            converted to a string*/
            username = principal.toString();
        }
        return username;
    }

    public boolean hasUserId(UUID id){
        UUID idCurrent = userRepository.findByUsername(getCurrentUsername()).getId();
        if(idCurrent.equals(id))
            return true;
        return false;
    }
}
