package org.ac.cst8277.ching.james.ums.controller;

import org.ac.cst8277.ching.james.ums.entity.AssignedRole;
import org.ac.cst8277.ching.james.ums.service.AssignedRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assignrole")
public class AssignedRoleController {

    @Autowired
    private AssignedRoleService assignedRoleService;

    @PostMapping("/")
    public AssignedRole assignRole(@RequestBody AssignedRole assignedRole){
        return assignedRoleService.assignRole(assignedRole);
    }
}
