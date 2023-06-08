package javaValidation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.CreditCardNumber;

import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public class Pay {
    //disini contoh penggunaan annotation yg dimiliki hibernate, yg dicoba disini adalah @Range, @CreditCardNumber
    @NotBlank(message = "order id field cant empty")
    private String orderId;
    @Range(min = 10_000L, max = 100_000_000L, message = "amount have to 10.000 until 100.000.000")
    @NotNull(message = "amount field cant empty")
    private Long amount;
    @CreditCardNumber(message = "invalid credit card number")
    @NotBlank(message = "credit card field cant empty")
    private String creditCard;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

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
