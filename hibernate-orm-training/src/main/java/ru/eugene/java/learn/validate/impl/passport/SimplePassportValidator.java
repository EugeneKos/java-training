package ru.eugene.java.learn.validate.impl.passport;

import org.springframework.stereotype.Service;
import ru.eugene.java.learn.data.Passport;
import ru.eugene.java.learn.exception.ValidateException;

@Service
public class SimplePassportValidator implements PassportValidator {
    @Override
    public void validate(Passport passport) throws ValidateException {
        String uin = passport.getUin();
        String regexp = "uin-\\d{6}-[a-z]{5,15}-\\d{4}";
        if(!uin.matches(regexp)){
            throw new ValidateException("Идентификационный номер пасспорта не соответствует формату.");
        }
    }
}
