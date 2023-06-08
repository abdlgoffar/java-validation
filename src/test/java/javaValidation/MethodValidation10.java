package javaValidation;

import jakarta.validation.ConstraintViolation;
import javaValidation.groups.UserGroup;
import javaValidation.helper.HelperValidation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class MethodValidation10 extends HelperValidation {
    @Test
    void testMethodParameterValidation() throws NoSuchMethodException {
        Person3 person3 = new Person3();
        String name = "";
        String hoby = "";
        Object[] parameterMethodValue = {name, hoby, null};
        Method method = Person3.class.getMethod("student", String.class, String.class, Integer.class);
        //parameter kesatu pada method parameter validation adalah object nya, kedua method nya, ketiga value parameter method nya, keempat groupnya
        Set<ConstraintViolation<Person3>> constraintViolations = executableValidator.validateParameters(person3, method, parameterMethodValue, UserGroup.class);
        //iteration method validation 
        for (ConstraintViolation<Person3> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getMessage());
        }

    }
    @Test
    void testMethodReturnValueValidation() throws NoSuchMethodException {
        Person3 person3 = new Person3();
        person3.setFirstName("");
        person3.setLastName("");
        String returnValue = person3.fullName();
        Method method = Person3.class.getMethod("fullName");
        Set<ConstraintViolation<Person3>> constraintViolations = executableValidator.validateReturnValue(person3, method, returnValue, UserGroup.class);
        for (ConstraintViolation<Person3> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getMessage());
        }
        if (constraintViolations.isEmpty() == false) {
            System.out.println("THERE ERROR");
        }
    }
}
