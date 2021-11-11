package com.example.demo;

import com.example.demo.domain.appUser.User;
import com.example.demo.domain.appUser.UserController;
import com.example.demo.domain.appUser.UserService;
import com.example.demo.domain.authority.Authority;
import com.example.demo.domain.authority.AuthorityRepository;
import com.example.demo.domain.blogPost.BlogPost;
import com.example.demo.domain.blogPost.BlogPostService;
import com.example.demo.domain.role.Role;
import com.example.demo.domain.role.RoleRepository;
import com.example.demo.domain.role.RoleServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;


@Component
@RequiredArgsConstructor
//ApplicationListener used to run commands after startup
class AppStartupRunner implements ApplicationRunner {
    @Autowired
    private final UserService userService;
    @Autowired
    private final RoleRepository roleRepository;
    @Autowired
    private final AuthorityRepository authorityRepository;
    @Autowired
    private final BlogPostService blogPostService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        RUN YOUR STARTUP CODE HERE
//        e.g. to add a user or role to the DB (only for testing)

//        Authorities
        Authority read_auth = new Authority(null, "READ");
        authorityRepository.save(read_auth);

        Authority write_auth = new Authority(null, "WRITE");
        authorityRepository.save(write_auth);

        Authority allrights = new Authority(null, "ALLRIGHTS");
        authorityRepository.save(allrights);

//        Roles
        Role default_role = new Role(null, "READER", Arrays.asList(read_auth));
        roleRepository.save(default_role);

        Role user_role = new Role(null, "USER", Arrays.asList(write_auth));
        roleRepository.save(user_role);

        Role admin_role = new Role(null, "ADMIN", Arrays.asList(allrights));
        roleRepository.save(admin_role);

        userService.saveUser(new User(null, "james", "james.bond@mi6.com", "bond", Set.of(default_role)));
        userService.addRoleToUser("james", "READ");

        userService.saveUser(new User(null, "max", "max.muster@gmail.com", "muster", Set.of(user_role)));
        userService.addRoleToUser("max", "WRITE");

        userService.saveUser(new User(null, "bob", "bob.builder@gmail.com", "builder", Set.of(admin_role)));
        userService.addRoleToUser("bob", "ALLRIGHTS");

        userService.saveUser(new User(null, "default", "default@gmail.com", "", Set.of(admin_role)));
        userService.addRoleToUser("default", "READ");

        BlogPost blogPost = new BlogPost(null, "Title", userService.getUser("max").getId(), "text", "category");
        blogPostService.save(blogPost);
    }
}
