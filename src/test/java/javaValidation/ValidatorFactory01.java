package javaValidation;

import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

public class ValidatorFactory01 {
    //validator factory digunakan untuk registration validation ke driver java validationnya contoh salah satu drivernya
    // adalah hibernate validation, object validator factory lebih baik dibuat sekali karena objectnya terlalu berat
    @Test
    void testValidatorFactory() {
        //membuat interface validator factory
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    }
}
