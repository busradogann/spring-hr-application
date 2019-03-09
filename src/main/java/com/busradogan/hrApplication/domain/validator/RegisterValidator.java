package com.busradogan.hrApplication.domain.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.busradogan.hrApplication.service.UserService;
import com.busradogan.hrApplication.domain.User;


@Component
public class RegisterValidator implements Validator {
    private final UserService userService;

    @Autowired
    public RegisterValidator(UserService userService) {
        this.userService = userService;
    }

    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    public void validate(Object o, Errors errors) {
        User form = (User) o;
        validateName(errors, form);
    }
    
    private void validateName(Errors errors, User form) {
    if (userService.getUserByName(form.getName()) != null) {
        errors.reject("name.exists", "User with this name already exists");
        }
    }
}