package org.ac.cst8277.ching.james.ums.entity;

import lombok.Data;

@Data
public class UserRoleTemplate {

    private User user;
    private Iterable<Role> role;
}
