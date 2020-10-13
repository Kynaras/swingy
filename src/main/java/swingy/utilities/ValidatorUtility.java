package swingy.utilities;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidatorUtility {

   private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public static boolean checkValidity (Object object){
        Validator validator = factory.getValidator();
  
        Set<ConstraintViolation<Object>> constraintViolations =
        validator.validate(object);
        
        if (!constraintViolations.isEmpty()) {
           System.out.println(constraintViolations.iterator().next().getMessage());
           return false;
        }
        else {
           return true;
        }
    }

    public static boolean checkFieldValidty (Object object, String field){
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> constraintViolations =
        validator.validateProperty(object, field);
        
        if (!constraintViolations.isEmpty()) {
           System.out.println(constraintViolations.iterator().next().getMessage());
           return false;
        }
        else {
           return true;
        }
    }
    
}
