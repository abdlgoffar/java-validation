package javaValidation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Person5 {
    //EXAMPLE CREATE GETTER MESSAGE
    //ini adalah contoh message interpolation, dimana pesan validation langsung diambil dari parameter variable
    //dengan tanda kurung kurawal sebagai syarat pengambilan message secara interpolation
    @Size(min = 3, max = 20, message = "min length name field is {min}, and max length is {max}")
    @NotBlank(message = "name field cant empty")
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}
