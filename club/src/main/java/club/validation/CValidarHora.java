package club.validation;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.Time;

public class CValidarHora implements ConstraintValidator<ValidarHora, String> {
	
	@Override
	public void initialize(ValidarHora hora) {	
	}
	
	@Override
	public boolean isValid(String hora, ConstraintValidatorContext cxt) {
		
		boolean valido = true;
		Time time = null;
		
        try {
    		time = (Time.valueOf(hora+":00"));      
        } 
        catch (Exception ex) {
            valido = false;
        }
        
        if (hora.length()>5) {
        	valido = false;
        }
        
        return valido;
    }
}
