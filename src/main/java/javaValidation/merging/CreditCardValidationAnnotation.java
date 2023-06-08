package javaValidation.merging;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.lang.annotation.*;

//PENGGABUNGAN ANNOTATION VALIDASI PADA SEBUAH FIELD DIGUNAKAM AGAR SEBUAH FIELD TERLIHAT RAPI ATAU BERSIH, ITU MERUPAKAN
//SALAH SATU TUJUAN PENGGABUNGAN ANNOTATION VALIDASI FIELD



//@CreditCardNumber, @NotBlank adalah annotation validasi yang dikelompokkan
@CreditCardNumber(message = "invalid credit card number")
@NotBlank(message = "credit card field cant empty")
////NOTES: BERIKUT CARA PEMBUATAN ANNOTATION UNTUK MENGELOMPOKKAN ANNOTATION VALIDASI YANG LAIN
@Documented
@Constraint(validatedBy = {})//constraint adalah class yang berisi logic annotation yg akan dibuat manual
@Target({ElementType.METHOD, ElementType.FIELD})//target adalah target yang akan divalidasi misal field dan method
@Retention(RetentionPolicy.RUNTIME)
//@ReportAsSingleViolation
public @interface CreditCardValidationAnnotation {
    String message() default "invalid credit card";// untuk membuat message ini yang dieksekusi, artinya bukan semua message error setiap
    //annotation maka pada atas interface CreditCardValidationAnnotation ditambahkan annotation @ReportAsSingleViolation
    Class<?>[] groups() default { };
    Class<? extends Payload[]>[] payload() default { };

}
