package org.ac.cst8277.ching.james.ums.controller;

import org.ac.cst8277.ching.james.ums.entity.AssignedRole;
import org.ac.cst8277.ching.james.ums.entity.Session;
import org.ac.cst8277.ching.james.ums.service.SessionService;
import org.ac.cst8277.ching.james.ums.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ac.cst8277.ching.james.ums.service.AssignedRoleService;

import java.util.UUID;

@RestController
@RequestMapping("/")
public class SessionController {

    @Autowired
    private SessionService sessionService;
    @Autowired
    private UserService userService;
    @Autowired
    private AssignedRoleService assignedRoleServiceoleService;

    @GetMapping("/")
    public Session startSession(@AuthenticationPrincipal OAuth2User principal){
        String email = principal.getAttribute("email");
        UUID userID = userService.findUserByEmail(email).getUserID();
        Session session = new Session(userID);

        return sessionService.startSession(session);
    }

    @GetMapping("/log_out")
    public void endSession(@AuthenticationPrincipal OAuth2User principal){
        String email = principal.getAttribute("email");
        UUID userID = userService.findUserByEmail(email).getUserID();
        sessionService.endSession(userID);
    }

    @GetMapping("/{id}")
    public Iterable<AssignedRole> getRoleFromSessionID(@PathVariable("id")UUID sessionID){
        UUID userID = sessionService.findByID(sessionID).getUserID();
        if (userID == null){
            return null;
        }
        else {
            Iterable<AssignedRole> roles = assignedRoleServiceoleService.findByUserID(userID);
            return roles;
        }
    }
}
