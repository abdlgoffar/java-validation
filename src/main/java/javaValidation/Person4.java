package javaValidation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import javaValidation.groups.UserGroup;

public class Person4 {
    private String name;
    private String hoby;
    private Integer age;
    private Address address;

    //disini adalah contoh validasi constructor
    @Valid
    public Person4() {;
    }
    @Valid
    public Person4(@NotBlank(groups = UserGroup.class, message = "field name cant empty") String name,
                   @NotBlank(groups = UserGroup.class, message = "field hoby cant empty") String hoby,
                   @NotNull(groups = UserGroup.class, message = "field age cant empty") Integer age,
                   @NotNull(groups = UserGroup.class, message = "field address cant empty") Address address) {
        this.name = name;
        this.hoby = hoby;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHoby() {
        return hoby;
    }

    public void setHoby(String hoby) {
        this.hoby = hoby;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
