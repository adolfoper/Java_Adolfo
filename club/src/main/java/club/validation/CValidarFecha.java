package club.validation;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.text.ParseException;

public class CValidarFecha implements ConstraintValidator<ValidarFecha, String> {
	
	@Override
	public void initialize(ValidarFecha fecha) {	
	}
	
	@Override
	public boolean isValid(String fecha, ConstraintValidatorContext cxt) {
		
		Date date = null;
		boolean valido = true;
		
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");       
            date = sdf.parse(fecha);
        } 
        catch (ParseException ex) {
            valido = false;
        }
        
        if (valido) {
        	Date hoy = convertToDate(LocalDate.now());
        	if (hoy.compareTo(date) > 0) {
        		valido = false;
        	}
        }
        
        return valido;
    }
	
	public Date convertToDate(LocalDate dateToConvert) {
	    return java.sql.Date.valueOf(dateToConvert);
	}
}
