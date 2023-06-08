package javaValidation.payload;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;

public class EmailErrorPayload implements Payload {
    //disini akan dibuat method dengan parameter constraintViolation karena nanti pada saat ada validasi
    //error pada payload maka akan di get dengan constraintViolation data
    public void sendErrorEmail(ConstraintViolation<?> constraintViolation) {
        System.out.println("there error in email: "+ constraintViolation.getMessage());
    }
}
