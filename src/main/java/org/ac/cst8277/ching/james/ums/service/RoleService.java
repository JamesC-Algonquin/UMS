package org.ac.cst8277.ching.james.ums.service;

import org.ac.cst8277.ching.james.ums.entity.Role;
import org.ac.cst8277.ching.james.ums.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
    public Iterable<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public Role getRoleByID(UUID roleID){
        return roleRepository.findByRoleID(roleID);
    }

    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }
}
