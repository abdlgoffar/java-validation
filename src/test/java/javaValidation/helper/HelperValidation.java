package javaValidation.helper;

import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.BeforeEach;
import java.util.Set;

public class HelperValidation {
    private ValidatorFactory validatorFactory;
    protected Validator validator;
    protected ExecutableValidator executableValidator;
    @BeforeEach
    void constructForGetDriverValidation() {
        this.validatorFactory = Validation.buildDefaultValidatorFactory();
        this.validator = validatorFactory.getValidator();
        this.executableValidator = validator.forExecutables();
    }
    public void startValidation(Object o) {
        //validasi object
        Set<ConstraintViolation<Object>> constraintViolations = this.validator.validate(o);
        //contoh loop semua message pada validations
        for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
            System.out.println("message error: " + constraintViolation.getMessage());//untuk mendapatkan pesan errornya
            System.out.println("bean: " + constraintViolation.getLeafBean());//untuk mendapatkan object dan fieldnya yang error
            System.out.println("annotation: " + constraintViolation.getConstraintDescriptor().getAnnotation());//untuk mendapatkan ketentuan annotationnya
            System.out.println("invalid value: " + constraintViolation.getInvalidValue());//untuk menadapatkan nilai tidak validnya
            System.out.println("path or field name: " + constraintViolation.getPropertyPath());//untuk mendapatkan nama fieldnya
        }
        this.validatorFactory.close();
    }
    public void startValidationWithGrouping(Object o, Class<?>... classes) {
        //validasi object
        Set<ConstraintViolation<Object>> constraintViolations = this.validator.validate(o, classes);
        //contoh loop semua message pada validations
        for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
            System.out.println("message error: " + constraintViolation.getMessage());//untuk mendapatkan pesan errornya
            System.out.println("bean: " + constraintViolation.getLeafBean());//untuk mendapatkan object dan fieldnya yang error
            System.out.println("annotation: " + constraintViolation.getConstraintDescriptor().getAnnotation());//untuk mendapatkan ketentuan annotationnya
            System.out.println("invalid value: " + constraintViolation.getInvalidValue());//untuk menadapatkan nilai tidak validnya
            System.out.println("path or field name: " + constraintViolation.getPropertyPath());//untuk mendapatkan nama fieldnya
        }
        this.validatorFactory.close();
    }
}
