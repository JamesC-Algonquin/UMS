package org.ac.cst8277.ching.james.ums.repository;

import org.ac.cst8277.ching.james.ums.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByRoleID(UUID roleID);

    Role findByRole(String role);


}
