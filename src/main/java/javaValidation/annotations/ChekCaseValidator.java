package javaValidation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import javaValidation.enums.CaseMode;

//UNTUK MEMBUAT SEBUAH CLASS YANG BISA MELAKUKAN VALIDASI MAKA DIPERLUKAN:...
//01. harus implements interface  ConstraintValidator, yg mana pada parameter generic pertama interface  ConstraintValidator
//adalah annotation yang sudah dibuat secara menual, dan parameter kedua adalah type data yang bisa divalidasi
public class ChekCaseValidator implements ConstraintValidator<ChekCase, String> {
    private CaseMode caseMode;
    @Override
    public void initialize(ChekCase constraintAnnotation) {
        //------------------
        this.caseMode = constraintAnnotation.mode();
    }

    //METHOD isValid() biasanya berisi parameter value yg akan divalidasi
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        //parameter value adalah nilai dari data yang akan divalidasi
        if (value == null) return true;//skip validasi jika valuenya null
        if (caseMode == caseMode.UPPER) {
            return value.equals(value.toUpperCase());
        }else if (caseMode == caseMode.LOWER){
            return value.equals(value.toLowerCase());
        }
        return false;
    }
}
