package com.backend.model;

import com.backend.enums.RoleTypes;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(generator = "optimized-sequence")
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleTypes name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleTypes getName() {
        return name;
    }

    public void setName(RoleTypes name) {
        this.name = name;
    }
}
