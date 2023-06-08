package javaValidation;

import jakarta.validation.constraints.NotBlank;
import javaValidation.merging.CreditCardValidationAnnotation;
import org.hibernate.validator.constraints.CreditCardNumber;

public class Pay5 {
    //untuk melihat cara pembuatan konsep combine annotation lihat di package marging annotation CreditCardValidationAnnotation
    @CreditCardValidationAnnotation
    private String creditCard;

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
