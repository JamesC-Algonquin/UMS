package org.ac.cst8277.ching.james.ums.service;

import org.ac.cst8277.ching.james.ums.entity.AssignedRole;
import org.ac.cst8277.ching.james.ums.repository.AssignedRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AssignedRoleService {

    @Autowired
    private AssignedRoleRepository assignedRoleRepository;

    public AssignedRole assignRole(AssignedRole assignedRole) {
        return assignedRoleRepository.save(assignedRole);
    }

    public Iterable<AssignedRole> findByUserID(UUID userID) {
        return assignedRoleRepository.findByUserID(userID);
    }
}
