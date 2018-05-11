package ge.edu.ibsu.mobile.labwork10;

import java.io.Serializable;

public class Technology implements Serializable {
    private String name;
    private int year;
    private String developer;
    private String secondFavourite;

    public Technology() {

    }

    public Technology(String name, int year, String developer, String secondFavourite) {
        this.name = name;
        this.year = year;
        this.developer = developer;
        this.secondFavourite = secondFavourite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getSecondFavourite() {
        return secondFavourite;
    }

    public void setSecondFavourite(String secondFavourite) {
        this.secondFavourite = secondFavourite;
    }
}
