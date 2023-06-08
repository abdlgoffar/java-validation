package javaValidation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Customer {
    @NotBlank(message = "name field cant empty")
    private String name;
    @Email(message = "your email invalid")
    @NotBlank(message = "email field cant empty")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
