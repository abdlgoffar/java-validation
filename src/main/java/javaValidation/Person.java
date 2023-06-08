package javaValidation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Person {
    //ini adalah contoh penggunaan constraint atau annotation pada field dalam class
    @NotBlank(message = "firstName field cant empty")
    @Size(max = 10, message = "max length firstName field is 10 character")
    private String firstName;
    @NotBlank(message = "lastName field cant empty")
    @Size(max = 10, message = "max length lastName field is 10 character")
    private String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}
