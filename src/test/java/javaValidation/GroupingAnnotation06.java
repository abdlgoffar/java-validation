package javaValidation;

import javaValidation.groups.CreditCardPayGroup;
import javaValidation.groups.VirtualAccountPayGroup;
import javaValidation.helper.HelperValidation;
import org.junit.jupiter.api.Test;

public class GroupingAnnotation06 extends HelperValidation {
    @Test
    void testGroupingAnnotationCreditCardGroup() {
        //untuk memvalidasi field yang sudah di gouping maka juga dibutuhkan nama groupnya pada saat divalidasi
        Pay2 pay2 = new Pay2();
        pay2.setOrderId("300");
        pay2.setAmount(1_000_000L);
        pay2.setCreditCard("9204");
        //disini virtual account field tidak akan divalidasi karena tidak masuk dalam group CreditCardPayGroup
        startValidationWithGrouping(pay2, CreditCardPayGroup.class);
    }
    @Test
    void testGroupingAnnotationVirtualAccountGroup() {
        //untuk memvalidasi field yang sudah di gouping maka juga dibutuhkan nama groupnya pada saat divalidasi
        Pay2 pay2 = new Pay2();
        pay2.setOrderId("400");
        pay2.setAmount(2_000_000L);
        pay2.setVirtualAccount("");
        //disini credit card field tidak akan divalidasi karena tidak masuk dalam group VirtualAccountPayGroup
        startValidationWithGrouping(pay2, VirtualAccountPayGroup.class);
    }
}
