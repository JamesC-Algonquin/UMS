package org.ac.cst8277.ching.james.ums.controller;

import org.ac.cst8277.ching.james.ums.entity.User;
import org.ac.cst8277.ching.james.ums.entity.UserRoleTemplate;
import org.ac.cst8277.ching.james.ums.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){

        return userService.saveUser(user);
    }

    @GetMapping("/")
    public @ResponseBody Iterable<UserRoleTemplate> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserRoleTemplate findUserById(@PathVariable("id") UUID userID){
        return userService.findUserById(userID);
    }

    @DeleteMapping("/{id}")
    public String deleteByID(@PathVariable("id") UUID userID){
        long num = userService.deleteByID(userID);
        if(num>=1) {
            return "Deleted User.";
        }
        return "No User Found.";
    }

    @GetMapping("/isProducer/{id}")
    public boolean isProducer(@PathVariable("id")UUID userID){
        return userService.isProducer(userID);
    }

}
