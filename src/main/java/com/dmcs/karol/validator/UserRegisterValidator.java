package com.dmcs.karol.validator;

import com.dmcs.karol.domain.AppUser;
import com.dmcs.karol.utils.AppDemoConstans;
import com.dmcs.karol.utils.AppDemoUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserRegisterValidator implements Validator {

    @Override
    public boolean supports(Class<?> cls) {
        return AppUser.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        AppUser u = (AppUser) obj;

        ValidationUtils.rejectIfEmpty(errors, "firstName", "error.userName.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "error.userLastName.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "error.userPassword.empty");

        if (!u.getEmail().equals(null)) {
            boolean isMatch = AppDemoUtils.checkEmailOrPassword(AppDemoConstans.EMAIL_PATTERN, u.getEmail());
            if(!isMatch) {
                errors.rejectValue("email", "error.userEmailIsNotMatch");
            }
        }

        if (!u.getPassword().equals(null)) {
            boolean isMatch = AppDemoUtils.checkEmailOrPassword(AppDemoConstans.PASSWORD_PATTERN, u.getPassword());
            if(!isMatch) {
                errors.rejectValue("password", "error.userPasswordIsNotMatch");
            }
        }

    }

    public void validateEmailExist(AppUser appUser, Errors errors) {
        if (appUser != null) {
            errors.rejectValue("email", "error.userEmailExist");
        }
    }

}
