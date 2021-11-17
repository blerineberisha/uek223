package com.example.demo;

import com.example.demo.domain.appUser.User;
import com.example.demo.domain.appUser.UserService;
import com.example.demo.domain.authority.Authority;
import com.example.demo.domain.authority.AuthorityRepository;
import com.example.demo.domain.blogPost.BlogPost;
import com.example.demo.domain.blogPost.BlogPostService;
import com.example.demo.domain.role.Role;
import com.example.demo.domain.role.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;


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

        Authority execute_auth = new Authority(null, "EXECUTE");
        authorityRepository.save(execute_auth);

//        Roles
        Role default_role = new Role(null, "READER", Arrays.asList(read_auth));
        roleRepository.save(default_role);

        Role user_role = new Role(null, "USER", Arrays.asList(read_auth, write_auth));
        roleRepository.save(user_role);

        Role admin_role = new Role(null, "ADMIN", Arrays.asList(read_auth, write_auth, execute_auth));
        roleRepository.save(admin_role);

        userService.saveUser(new User(null, "james", "james.bond@mi6.com", "bond", Set.of(default_role)));
        userService.addRoleToUser("james", "READ");

        userService.saveUser(new User(null, "max", "max.muster@gmail.com", "muster", Set.of(user_role)));
        userService.addRoleToUser("max", "WRITE");

        userService.saveUser(new User(null, "bob", "bob.builder@gmail.com", "builder", Set.of(admin_role)));
        userService.addRoleToUser("bob", "ALLRIGHTS");

        userService.saveUser(new User(null, "default", "default@gmail.com", "", Set.of(admin_role)));
        userService.addRoleToUser("default", "READ");

        BlogPost blogPost = new BlogPost(null, "Title", userService.getUser("max").getUsername(), "text", "category");
        BlogPost blogPost1 = new BlogPost(null, "a", userService.getUser("max").getUsername(), "a", "category");
        BlogPost blogPost2 = new BlogPost(null, "b", userService.getUser("max").getUsername(), "b", "category");
        BlogPost blogPost3 = new BlogPost(null, "c", userService.getUser("max").getUsername(), "c", "category");
        BlogPost blogPost4 = new BlogPost(null, "d", userService.getUser("max").getUsername(), "d", "category");
        BlogPost blogPost5 = new BlogPost(null, "e", userService.getUser("max").getUsername(), "e", "category");
        BlogPost blogPost6 = new BlogPost(null, "f", userService.getUser("max").getUsername(), "f", "category");
        BlogPost blogPost7 = new BlogPost(null, "g", userService.getUser("max").getUsername(), "g", "category");
        BlogPost blogPost8 = new BlogPost(null, "h", userService.getUser("max").getUsername(), "h", "category");
        BlogPost blogPost9 = new BlogPost(null, "i", userService.getUser("max").getUsername(), "i", "category");
        BlogPost blogPost10 = new BlogPost(null, "j", userService.getUser("max").getUsername(), "j", "category");
        BlogPost blogPost11 = new BlogPost(null, "k", userService.getUser("max").getUsername(), "k", "category");
        BlogPost blogPost12 = new BlogPost(null, "l", userService.getUser("max").getUsername(), "l", "category");
        BlogPost blogPost13 = new BlogPost(null, "m", userService.getUser("max").getUsername(), "m", "category");
        BlogPost blogPost14 = new BlogPost(null, "n", userService.getUser("max").getUsername(), "n", "category");
        BlogPost blogPost15 = new BlogPost(null, "o", userService.getUser("max").getUsername(), "o", "category");
        BlogPost blogPost16 = new BlogPost(null, "p", userService.getUser("max").getUsername(), "p", "category");
        BlogPost blogPost17 = new BlogPost(null, "q", userService.getUser("max").getUsername(), "q", "category");
        BlogPost blogPost18 = new BlogPost(null, "r", userService.getUser("max").getUsername(), "r", "category");
        BlogPost blogPost19 = new BlogPost(null, "s", userService.getUser("max").getUsername(), "s", "category");
        BlogPost blogPost20 = new BlogPost(null, "t", userService.getUser("max").getUsername(), "t", "category");

        blogPostService.save(blogPost);
        blogPostService.save(blogPost1);
        blogPostService.save(blogPost2);
        blogPostService.save(blogPost3);
        blogPostService.save(blogPost4);
        blogPostService.save(blogPost5);
        blogPostService.save(blogPost6);
        blogPostService.save(blogPost7);
        blogPostService.save(blogPost8);
        blogPostService.save(blogPost9);
        blogPostService.save(blogPost10);
        blogPostService.save(blogPost11);
        blogPostService.save(blogPost12);
        blogPostService.save(blogPost13);
        blogPostService.save(blogPost14);
        blogPostService.save(blogPost15);
        blogPostService.save(blogPost16);
        blogPostService.save(blogPost17);
        blogPostService.save(blogPost18);
        blogPostService.save(blogPost19);
        blogPostService.save(blogPost20);

    }
}
