package javaValidation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class GetMessageNestedValidation04 {


    private ValidatorFactory validatorFactory;
    private Validator validator;

    @BeforeEach
    void constructForGetDriverValidation() {
        this.validatorFactory = Validation.buildDefaultValidatorFactory();
        this.validator = this.validatorFactory.getValidator();
    }

    @Test
    void testValidationFieldObjectAddressNotBlank() {
        //contoh melakukan validasi field pada object class person
        Person2 person2 = new Person2();
        person2.setAddress(new Address());
        Set<ConstraintViolation<Person2>> constraintViolations = this.validator.validate(person2);
        //loop message validation
        for (ConstraintViolation<Person2> constraintViolation : constraintViolations) {
            System.out.println("message error: " + constraintViolation.getMessage());//untuk mendapatkan pesan errornya
            System.out.println("bean: " + constraintViolation.getLeafBean());//untuk mendapatkan object dan fieldnya yang error
            System.out.println("annotation: " + constraintViolation.getConstraintDescriptor().getAnnotation());//untuk mendapatkan ketentuan annotationnya
            System.out.println("invalid value: " + constraintViolation.getInvalidValue());//untuk menadapatkan nilai tidak validnya
            System.out.println("path or field name: " + constraintViolation.getPropertyPath());//untuk mendapatkan nama fieldnya
        }
    }
}
