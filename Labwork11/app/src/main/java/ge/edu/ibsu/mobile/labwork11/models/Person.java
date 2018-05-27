package ge.edu.ibsu.mobile.labwork11.models;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String reason;

    public Person() {
    }

    public Person(String firstName, String lastName, String reason) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.reason = reason;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
