package javaValidation;

import javaValidation.helper.HelperValidation;
import org.junit.jupiter.api.Test;

public class CombineAnnotationValidation13 extends HelperValidation {
    @Test
    void testCombineAnnotationValidation() {
        //combine annotation adalah pengelompokan annotation validasi pada sebuah field agar lebih terlihat rapi
        //untuk melihat konsep combine annotation buka pada class Pay5
        Pay5 pay5 = new Pay5();
        pay5.setCreditCard("");
        startValidation(pay5);
    }
}
