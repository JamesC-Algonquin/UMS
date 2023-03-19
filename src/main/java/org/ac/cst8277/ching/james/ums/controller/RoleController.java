package org.ac.cst8277.ching.james.ums.controller;

import org.ac.cst8277.ching.james.ums.entity.Role;
import org.ac.cst8277.ching.james.ums.entity.User;
import org.ac.cst8277.ching.james.ums.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/")
    public Role saveUser(@RequestBody Role role){

        return roleService.saveRole(role);
    }

    @GetMapping("/")
    public Iterable<Role> getRoles(){
        return roleService.getRoles();
    }
}
