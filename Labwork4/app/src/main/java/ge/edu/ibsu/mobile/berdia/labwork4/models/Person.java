package ge.edu.ibsu.mobile.berdia.labwork4.models;

import java.io.Serializable;

/**
 * Created by rogel on 3/16/2018.
 */

public class Person implements Serializable {

    private String name;

    private String surname;

    private int monthOfBirth;

    private String season;

    private String favouriteLecture;

    public Person() {
        this.name = "name";
        this.surname = "surname";
        this.monthOfBirth = 1;
        this.season = "season";
        this.favouriteLecture = "android";
    }

    public Person(String name, String surname, int monthOfBirth, String season, String favouriteLecture) {
        this.name = name;
        this.surname = surname;
        this.monthOfBirth = monthOfBirth;
        this.season = season;
        this.favouriteLecture = favouriteLecture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getmonthOfBirth() {
        return monthOfBirth;
    }

    public void setmonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getFavouriteLecture() {
        return favouriteLecture;
    }

    public void setFavouriteLecture(String favouriteLecture) {
        this.favouriteLecture = favouriteLecture;
    }

}
