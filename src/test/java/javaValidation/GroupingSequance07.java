package javaValidation;

import javaValidation.groups.PayGroup;
import javaValidation.helper.HelperValidation;
import org.junit.jupiter.api.Test;

public class GroupingSequance07 extends HelperValidation {
    @Test
    void testSequence() {
        //disini contoh pengurutan group yg mana akan divalidasi terlebih dahulu, jika disuatu group terdapat validasi yg error
        //maka proses validasi di urutan group selanjutnya tidak akan dilakukan
        Pay2 pay2 = new Pay2();
        startValidationWithGrouping(pay2, PayGroup.class);
    }
}
