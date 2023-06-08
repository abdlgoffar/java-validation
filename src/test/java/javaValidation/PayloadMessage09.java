package javaValidation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;
import javaValidation.groups.CreditCardPayGroup;
import javaValidation.helper.HelperValidation;
import javaValidation.payload.EmailErrorPayload;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class PayloadMessage09 extends HelperValidation {
    @Test
    void testPayLoad() {
        //payload biasa digunakan untuk menambahkan pesan tambahan ketika ada field dengan payload yang tidak valid
        Pay4 pay4 = new Pay4();
        pay4.setAmount(2_000L);
        pay4.setCreditCard("111111");
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(pay4, CreditCardPayGroup.class);
        for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
            System.out.println("message error: " + constraintViolation.getMessage());//untuk mendapatkan pesan errornya
            System.out.println("bean: " + constraintViolation.getLeafBean());//untuk mendapatkan object dan fieldnya yang error
            System.out.println("annotation: " + constraintViolation.getConstraintDescriptor().getAnnotation());//untuk mendapatkan ketentuan annotationnya
            System.out.println("invalid value: " + constraintViolation.getInvalidValue());//untuk menadapatkan nilai tidak validnya
            System.out.println("path or field name: " + constraintViolation.getPropertyPath());//untuk mendapatkan nama fieldnya
            //disini adalah cara untuk mendapatkan payload message
            Set<Class<? extends Payload>> payload = constraintViolation.getConstraintDescriptor().getPayload();
            for (Class<? extends Payload> payloadClassesAvailable : payload) {
                if (payloadClassesAvailable == EmailErrorPayload.class) {
                    EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
                    emailErrorPayload.sendErrorEmail(constraintViolation);
                }
            }
        }
    }
}
