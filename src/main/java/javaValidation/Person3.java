package javaValidation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import javaValidation.groups.UserGroup;

public class Person3 {
    private String firstName;
    private String lastName;

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

    //disini adalah contoh pembuatan validasi pada method parameter
    public void student(@NotBlank(groups = UserGroup.class, message = "field name cant empty") String name,
                        @NotBlank(groups = UserGroup.class, message = "field hoby cant empty") String hoby,
                        @NotNull(groups = UserGroup.class, message = "field age cant empty") Integer age) {
    }
    //disini adalah contoh pembuatan validasi pada method return value
    @NotBlank(message = "for get fullName, your must fill field firstName and LastName", groups = UserGroup.class)
    public String fullName () {
        return this.firstName + " " + this.lastName;
    }
}
