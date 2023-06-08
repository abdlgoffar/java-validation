package javaValidation;

import javaValidation.helper.HelperValidation;
import org.junit.jupiter.api.Test;

public class CreateAnnotationValidation12 extends HelperValidation {
    @Test
    void testCreateAnnotation() {
        //untuk melihat lebih detail tentang konsep cara membuat annotation secara manual, maka amati package annotatios dan enums
        Person6 person6 = new Person6();
        person6.setUsername("ronaldo");
        startValidation(person6);
    }
}
