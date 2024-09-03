package org.example;

import java.time.LocalDateTime;

public class User {
    public enum Gender {
        NOT_SPECIFIED, MALE, FEMALE
    }

    private Integer id;
    private String surname;
    private String name;
    private Gender gender;
    private LocalDateTime authorizationTime;

    public User() {
    }

    public User(Integer id, String surname, String name, Gender gender, LocalDateTime authorizationTime) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.gender = gender;
        this.authorizationTime = authorizationTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDateTime getAuthorizationTime() {
        return authorizationTime;
    }

    public void setAuthorizationTime(LocalDateTime authorizationTime) {
        this.authorizationTime = authorizationTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", authorizationTime=" + authorizationTime +
                '}';
    }
}
