package javaValidation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class GetMessageValidation03 {
    private ValidatorFactory validatorFactory;
    private Validator validator;
    @BeforeEach
    void constructForGetDriverValidation() {
        this.validatorFactory = Validation.buildDefaultValidatorFactory();
        this.validator = this.validatorFactory.getValidator();
    }
    @Test
    void testValidationFieldObjectPersonNotBlank() {
        //contoh melakukan validasi field pada object class person
        Person person = new Person();
        Set<ConstraintViolation<Person>> constraintViolations = this.validator.validate(person);
        //contoh loop semua message pada validations
        for (ConstraintViolation<Person> constraintViolation : constraintViolations) {
            System.out.println("message error: " + constraintViolation.getMessage());//untuk mendapatkan pesan errornya
            System.out.println("bean: " + constraintViolation.getLeafBean());//untuk mendapatkan object dan fieldnya yang error
            System.out.println("annotation: " + constraintViolation.getConstraintDescriptor().getAnnotation());//untuk mendapatkan ketentuan annotationnya
            System.out.println("invalid value: " + constraintViolation.getInvalidValue());//untuk menadapatkan nilai tidak validnya
            System.out.println("path or field name: " + constraintViolation.getPropertyPath());//untuk mendapatkan nama fieldnya
        }
    }
    @Test
    void testValidationFieldObjectPersonSize() {
        //contoh melakukan validasi field pada object class person
        Person person = new Person();
        //set character sizxe field pada object person
        person.setFirstName("abdul goffar sampang jawa timur indonesia");
        person.setLastName("abdul goffar hoby sepak bola");
        Set<ConstraintViolation<Person>> constraintViolations = this.validator.validate(person);
        //contoh loop semua message pada validations
        for (ConstraintViolation<Person> constraintViolation : constraintViolations) {
            System.out.println("message error: " + constraintViolation.getMessage());//untuk mendapatkan pesan errornya
            System.out.println("bean: " + constraintViolation.getLeafBean());//untuk mendapatkan object dan fieldnya yang error
            System.out.println("annotation: " + constraintViolation.getConstraintDescriptor().getAnnotation());//untuk mendapatkan ketentuan annotationnya
            System.out.println("invalid value: " + constraintViolation.getInvalidValue());//untuk menadapatkan nilai tidak validnya
            System.out.println("path or field name: " + constraintViolation.getPropertyPath());//untuk mendapatkan nama fieldnya
        }
    }

}
