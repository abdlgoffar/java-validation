package javaValidation.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import javaValidation.enums.CaseMode;

import java.lang.annotation.*;
//NOTES: DIBAWAH INI ADALAH HAL-HAL WAJIB YG HARUS DILENGKAPI APABILA INGIN MEMBUAT ANNOTATION SECARA MANUAL
@Documented
@Constraint(validatedBy = {ChekCaseValidator.class})//constraint adalah class yang berisi logic annotation yg akan dibuat manual
@Target({ElementType.METHOD, ElementType.FIELD})//target adalah target yang akan divalidasi misal field dan method
@Retention(RetentionPolicy.RUNTIME)
public @interface ChekCase {
    //SETIAP BARIS KODE DIBAWAH, ADALAH PARAMETER-PARAMETER YANG TERSEDIA PADA ANNOTATIONS NANTI
    //pada kode pertama misal CaseMode, String, Class<?>[], dan Class<? extends Payload[]>[] adalah object logicnya
    //dan pada kode kedua misal mode(), message(), groups(), dan payload() adalah nama parameter dia annotation nanti
    CaseMode mode();
    String message() default "invalid character format";//message kesalahan pada annotation
    Class<?>[] groups() default { }; //group default annotation
    Class<? extends Payload[]>[] payload() default { }; //payload default annotation

}
