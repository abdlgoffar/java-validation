package javaValidation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class Person2 {
    //ini adalah contoh nested validation, dimana memvalidasikan field object pada object lain, disini ada object pada class
    //Address yg dijadikan field type object pada class Person2 untuk mencoba divalidasi.
    //CATATN...! untuk melakukan nested validation maka di butuhkan annotation @Valid dan annotation @NotNull karena field ini typenya object
    @NotNull
    @Valid
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
