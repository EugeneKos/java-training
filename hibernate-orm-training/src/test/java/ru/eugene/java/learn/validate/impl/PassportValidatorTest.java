package ru.eugene.java.learn.validate.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.eugene.java.learn.context.TestSpringConfiguration;
import ru.eugene.java.learn.data.Passport;
import ru.eugene.java.learn.exception.ValidateException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestSpringConfiguration.class})
public class PassportValidatorTest {
    @Autowired
    private PassportValidator passportValidator;

    private Passport createPassport(String uin){
        Passport passport = new Passport();
        passport.setUin(uin);
        return passport;
    }

    @Test
    public void testNormalPassport() throws ValidateException {
        Passport passport = createPassport("uin-120845-kosinov-0879");
        passportValidator.validate(passport);
    }

    @Test(expected = ValidateException.class)
    public void testPassportWithoutStartSplit() throws ValidateException {
        Passport passport = createPassport("uin/120845-kosinov-0879");
        passportValidator.validate(passport);
    }

    @Test(expected = ValidateException.class)
    public void testPassportWithoutMiddleSplit() throws ValidateException {
        Passport passport = createPassport("uin-120845/kosinov-0879");
        passportValidator.validate(passport);
    }

    @Test(expected = ValidateException.class)
    public void testPassportWithoutFinalSplit() throws ValidateException {
        Passport passport = createPassport("uin-120845-kosinov/0879");
        passportValidator.validate(passport);
    }

    @Test(expected = ValidateException.class)
    public void testPassportBadFirstSixDigits() throws ValidateException {
        Passport passport = createPassport("uin-12a845-kosinov-0879");
        passportValidator.validate(passport);
    }

    @Test(expected = ValidateException.class)
    public void testPassportBadLastFourDigits() throws ValidateException {
        Passport passport = createPassport("uin-120845-kosinov-0q79");
        passportValidator.validate(passport);
    }

    @Test(expected = ValidateException.class)
    public void testPassportBadUIN() throws ValidateException {
        Passport passport = createPassport("u9n-120845-kosinov-0879");
        passportValidator.validate(passport);
    }

    @Test(expected = ValidateException.class)
    public void testPassportBadArbitrarySymbolLength_1() throws ValidateException {
        Passport passport = createPassport("uin-120845-kos-0879");
        passportValidator.validate(passport);
    }

    @Test(expected = ValidateException.class)
    public void testPassportBadArbitrarySymbolLength_2() throws ValidateException {
        Passport passport = createPassport("uin-120845-kosdaafacmal356fjaosjf-0879");
        passportValidator.validate(passport);
    }
}