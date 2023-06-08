package javaValidation;

import javaValidation.helper.HelperValidation;
import org.junit.jupiter.api.Test;

public class GetterMessage11 extends HelperValidation {
    @Test
    void testGetterMessage() {
        //untuk memahami konsep getter message maka lihat di class Person5, disana terdapat konsep getter message tersebut
        Person5 person5 = new Person5();
        person5.setName("al");
        startValidation(person5);
    }
}
