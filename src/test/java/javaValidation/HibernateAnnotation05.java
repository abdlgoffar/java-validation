package javaValidation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class HibernateAnnotation05 {
    private ValidatorFactory validatorFactory;
    private Validator validator;
    @BeforeEach
    void constructForGetDriverValidation() {
        this.validatorFactory = Validation.buildDefaultValidatorFactory();
        this.validator = this.validatorFactory.getValidator();
    }
    @Test
    void testAnnotation() {
        Pay pay = new Pay();
        pay.setOrderId("100");
        pay.setAmount(10_000L);
        pay.setCreditCard("5555555555554444");
        Set<ConstraintViolation<Pay>> constraintViolations = this.validator.validate(pay);
        //contoh loop semua message pada validations
        for (ConstraintViolation<Pay> constraintViolation : constraintViolations) {
            System.out.println("message error: " + constraintViolation.getMessage());//untuk mendapatkan pesan errornya
            System.out.println("bean: " + constraintViolation.getLeafBean());//untuk mendapatkan object dan fieldnya yang error
            System.out.println("annotation: " + constraintViolation.getConstraintDescriptor().getAnnotation());//untuk mendapatkan ketentuan annotationnya
            System.out.println("invalid value: " + constraintViolation.getInvalidValue());//untuk menadapatkan nilai tidak validnya
            System.out.println("path or field name: " + constraintViolation.getPropertyPath());//untuk mendapatkan nama fieldnya
        }
    }
}
