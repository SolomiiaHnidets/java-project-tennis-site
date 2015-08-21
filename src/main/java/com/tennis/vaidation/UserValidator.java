package com.tennis.vaidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tennis.domain.User;

@Component
public class UserValidator implements Validator {
	 private Pattern pattern;  
	 private Matcher matcher;  
	  
	 private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
	   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
	 String ID_PATTERN = "[0-9]+";  
	 String STRING_PATTERN = "[a-zA-Z]+";  
	 String MOBILE_PATTERN = "[0-9]{10}";  
	 
	   public boolean supports(Class<?> clazz) {
	        return User.class.equals(clazz);
	    }
	 
	 public void validate(Object target, Errors errors) {
		 User user = (User) target;  
		 // input string contains characters only  
		 if (!(user.getUserName() != null && user.getUserName().isEmpty())) {  
			 pattern = Pattern.compile(STRING_PATTERN);  
			 matcher = pattern.matcher(user.getUserName());  
			 if (!matcher.matches()) {  
				 errors.rejectValue("name", "name.containNonChar",  
						 "Enter a valid name");  
				 System.out.println( "Enter a valid name");
			 }
		 }  
		// email validation in spring  
		 if (!(user.getEmail() != null && user.getEmail().isEmpty())) {  
			 pattern = Pattern.compile(EMAIL_PATTERN);  
			 matcher = pattern.matcher(user.getEmail());  
			 if (!matcher.matches()) {  
				 errors.rejectValue("email", "email.incorrect",  
						 "Enter a correct email");  
				 System.out.println( "Enter a valid email");
			 }  
		 } 
	 }
}
