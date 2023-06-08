package javaValidation;

import jakarta.validation.constraints.NotBlank;
import javaValidation.annotations.ChekCase;
import javaValidation.enums.CaseMode;

public class Person6 {
    @ChekCase(mode = CaseMode.LOWER, message = " field username must lower case")
    @NotBlank(message = "field username cant empty")
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }
}
