package javaValidation;

import javaValidation.groups.CreditCardPayGroup;
import javaValidation.helper.HelperValidation;
import org.junit.jupiter.api.Test;

public class GroupingConvertNestedValidation08 extends HelperValidation {
    @Test
    void testConvert() {
        //untuk memvalidasi field yg merupakan nested object di dalam object lain yg sudah di group, maka dibutuhkan convert
        //group telebih dahulu agar field nested object itu ikut bisa tervalidasi
        Pay3 pay3 = new Pay3();
        pay3.setOrderId("500");
        pay3.setAmount(33_000L);
        pay3.setCreditCard("5555555555554444");
        Customer customer = new Customer();
        customer.setName("goffar");
        customer.setEmail("goffar@gmail");
        pay3.setCustomer(customer);
        //seperti contoh disini, kita akan mencoba memvalidasi object pay3 yg didalamnya terdapat field nested object customer
        //jika nested object customer tidak diconvert dahulu groupnya maka apapun validasi yg ada pada object customer tidak akan
        //pernah divalidasi oleh object pay3
        startValidationWithGrouping(pay3, CreditCardPayGroup.class);
    }
}
