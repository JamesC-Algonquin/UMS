package org.ac.cst8277.ching.james.ums.repository;

import org.ac.cst8277.ching.james.ums.entity.AssignedRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AssignedRoleRepository extends JpaRepository<AssignedRole, UUID> {
    Iterable<AssignedRole> findByUserID(UUID userID);
}
