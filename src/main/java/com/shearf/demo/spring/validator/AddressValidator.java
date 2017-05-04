package com.shearf.demo.spring.validator;

import com.shearf.demo.spring.domain.Address;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by xiahaihu on 17/4/28.
 */
public class AddressValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Address.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "street", "street.empty");
        ValidationUtils.rejectIfEmpty(errors, "address", "address.empty");
    }
}
