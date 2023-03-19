package org.ac.cst8277.ching.james.ums.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignedRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID assignedRoleID;
    private UUID roleID;
    private UUID userID;
}
