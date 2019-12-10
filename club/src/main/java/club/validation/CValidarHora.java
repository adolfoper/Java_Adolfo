package club.validation;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CValidarHora implements ConstraintValidator<ValidarHora, String> {
	
	private Pattern pattern;
	private Matcher matcher;
	
	@Override
	public void initialize(ValidarHora hora) {	
	}
	
	@Override
	public boolean isValid(String hora, ConstraintValidatorContext cxt) {
		
		final String TIME24HOURS_PATTERN = 
                "([01]?[0-9]|2[0-3]):[0-5][0-9]";
		
		if (hora.length()< 5) {
			hora = "0"+ hora;
		} 
		
		pattern = Pattern.compile(TIME24HOURS_PATTERN);
		matcher = pattern.matcher(hora);
		return matcher.matches();
		
    }
}
