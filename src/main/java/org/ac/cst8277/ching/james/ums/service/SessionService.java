package org.ac.cst8277.ching.james.ums.service;

import org.ac.cst8277.ching.james.ums.entity.Role;
import org.ac.cst8277.ching.james.ums.entity.Session;
import org.ac.cst8277.ching.james.ums.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.UUID;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private RestTemplate restTemplate;


    public Session startSession(Session session) {
                return sessionRepository.save(session);
    }

    public void endSession(UUID userID) {
        sessionRepository.deleteByUserID(userID);
    }


    public Session findByID(UUID sessionID) {
        return sessionRepository.findBySessionID(sessionID);
    }
}
