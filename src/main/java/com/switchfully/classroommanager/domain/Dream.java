package com.switchfully.classroommanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dream", schema = "switchfullymanager")
public class Dream {
@Id private int id;

}
