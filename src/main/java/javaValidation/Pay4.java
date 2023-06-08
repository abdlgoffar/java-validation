package javaValidation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import javaValidation.groups.CreditCardPayGroup;
import javaValidation.payload.EmailErrorPayload;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Range;

public class Pay4 {
    @NotNull(groups = CreditCardPayGroup.class, message = "amount field cant empty")
    @Range(groups = CreditCardPayGroup.class, min = 1_000L, max = 1_00_000_000L)
    private Long amount;
    @NotBlank(groups = CreditCardPayGroup.class, message = "field credit card cant empty")
    @CreditCardNumber(groups = CreditCardPayGroup.class, message = "credit card number invalid", payload = EmailErrorPayload.class)
    private String creditCard;
    //disini contoh penggunaan payload pada suatu annotation pada field yg divalidasi
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
