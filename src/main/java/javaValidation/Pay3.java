package javaValidation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import javaValidation.groups.CreditCardPayGroup;
import javaValidation.groups.VirtualAccountPayGroup;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Range;

public class Pay3 {
    @NotBlank(groups = {CreditCardPayGroup.class, VirtualAccountPayGroup.class}, message = "order id field cant empty")
    private String orderId;
    @Range(groups = {CreditCardPayGroup.class, VirtualAccountPayGroup.class}, min = 10_000L, max = 100_000_000L, message = "amount have to 10.000 until 100.000.000")
    @NotNull(groups = {CreditCardPayGroup.class, VirtualAccountPayGroup.class}, message = "amount field cant empty")
    private Long amount;
    @CreditCardNumber(groups = {CreditCardPayGroup.class}, message = "invalid credit card number")
    @NotBlank(groups = {CreditCardPayGroup.class}, message = "credit card field cant empty")
    private String creditCard;
    @NotBlank(groups = {VirtualAccountPayGroup.class}, message = "virtual account cant empty")
    private String virtualAccount;

    @Valid
    @NotNull(groups = {CreditCardPayGroup.class, VirtualAccountPayGroup.class}, message = "customer field cant empty")
    @ConvertGroup(from = CreditCardPayGroup.class, to = Default.class)
    @ConvertGroup(from = VirtualAccountPayGroup.class, to = Default.class)
    private Customer customer;
    //disini field nested object customer terdapat dalam group CreditCardPayGroup dan VirtualAccountPayGroup untuk
    //memvalidasi field-field yang ada dalam nested object customer tersebut, maka dibutuhkan convert group field nested object
    //customer ke group pada field object customer


    @Override
    public String toString() {
        return "Pay3{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                ", customer=" + customer +
                '}';
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

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

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }
}
