package com.switchfully.classroommanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Secret {
    @Id
    private int id;
    private String secretText;

    public Secret() {
    }
}
