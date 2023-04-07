package org.ac.cst8277.ching.james.ums.repository;

import jakarta.transaction.Transactional;
import org.ac.cst8277.ching.james.ums.entity.Session;
import org.ac.cst8277.ching.james.ums.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SessionRepository extends JpaRepository<Session, UUID> {

    @Transactional
    void deleteByUserID(UUID userID);

    Session findBySessionID(UUID sessionID);
}
