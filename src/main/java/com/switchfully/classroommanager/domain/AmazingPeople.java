package com.switchfully.classroommanager.domain;

import javax.persistence.*;

@Entity
@Table(schema = "switchfullymanager", name = "amazing_people")
public class AmazingPeople { // => amazing_peoplez
    @Id
    private int id; // => id
    private String name; // => name

    @ManyToOne
    private Employer employer;

    @Transient
    private int totalSecretScore;

    public AmazingPeople() {

    }

    public int getTotalSecretScore() {
        return totalSecretScore;
    }

    public void setTotalSecretScore(int totalSecretScore) {
        this.totalSecretScore = totalSecretScore;
    }

    public AmazingPeople(Employer employer) {

        this.employer = employer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AmazingPeople(int id, String name, Employer employer, Employer employer1) {
        this.id = id;
        this.name = name;
        this.employer = employer1;
    }

    public AmazingPeople(int id, String name, Employer employer) {
        this.id = id;
        this.name = name;
        this.employer = employer;
    }

    @Override
    public String toString() {
        return "AmazingPeople{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employer=" + employer +
                ", totalSecretScore=" + totalSecretScore +
                '}';
    }
}
