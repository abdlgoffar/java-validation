package javaValidation;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

public class Validator02 {
    @Test
    void testValidator() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        //validator interface digunakan untuk mendapatkan connection ke interface validator factory
        Validator validator = validatorFactory.getValidator();
    }
}
