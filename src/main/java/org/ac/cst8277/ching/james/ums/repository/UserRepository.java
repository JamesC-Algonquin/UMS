package org.ac.cst8277.ching.james.ums.repository;


import org.ac.cst8277.ching.james.ums.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUserID(UUID userID);

    long deleteByUserID(UUID userID);
}
