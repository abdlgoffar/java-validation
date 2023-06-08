package javaValidation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import javaValidation.groups.CreditCardPayGroup;
import javaValidation.groups.VirtualAccountPayGroup;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Range;

public class Pay2 {
    //disini contoh penggunaan grouping pada saat melakukan validasi
    //contoh disini aadalah penggroupan field mana yg dibutuhkan validasi pada saat pembayaran lewat metode kartu credit atau metode virtual account
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

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount)  {
        this.virtualAccount = virtualAccount;
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

}
