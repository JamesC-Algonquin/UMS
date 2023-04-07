package org.ac.cst8277.ching.james.ums.service;

import jakarta.transaction.Transactional;
import org.ac.cst8277.ching.james.ums.entity.AssignedRole;
import org.ac.cst8277.ching.james.ums.entity.Role;
import org.ac.cst8277.ching.james.ums.entity.User;
import org.ac.cst8277.ching.james.ums.entity.UserRoleTemplate;
import org.ac.cst8277.ching.james.ums.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AssignedRoleService assignedRoleService;
    @Autowired
    private RoleService roleService;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public UserRoleTemplate findUserById(UUID userID) {
        UserRoleTemplate userRoleTemplate = new UserRoleTemplate();
        userRoleTemplate.setUser(userRepository.findByUserID(userID));
        Iterable<AssignedRole> assignedRoles = assignedRoleService.findByUserID(userID);
        ArrayList<Role> roles = new ArrayList<Role>();
        for(AssignedRole assign : assignedRoles){
            roles.add(roleService.getRoleByID(assign.getRoleID()));
        }

        userRoleTemplate.setRole(roles);
        return userRoleTemplate;

    }

    public Iterable<UserRoleTemplate> getUsers() {
        ArrayList<UserRoleTemplate> userData = new ArrayList<>();
        Iterable<User> users = userRepository.findAll();
        for(User user: users){
            UserRoleTemplate userRoleTemplate = new UserRoleTemplate();
            userRoleTemplate.setUser(user);
            Iterable<AssignedRole> assignedRoles = assignedRoleService.findByUserID(user.getUserID());
            ArrayList<Role> roles = new ArrayList<Role>();
            for(AssignedRole assign : assignedRoles){
                roles.add(roleService.getRoleByID(assign.getRoleID()));
            }
            userRoleTemplate.setRole(roles);
            userData.add(userRoleTemplate);
        }

        return userData;
    }

    @Transactional
    public long deleteByID(UUID userID) {
        return userRepository.deleteByUserID(userID);
    }

    public boolean isProducer(UUID userID) {
        Iterable<AssignedRole> roles = assignedRoleService.findByUserID(userID);
        Role prod = roleService.findByRole("Producer");
        UUID prodID = prod.getRoleID();
        for (AssignedRole role: roles){
            if(role.getRoleID().toString() .equals(prodID.toString())){
                return true;
            }
        }
        return false;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
