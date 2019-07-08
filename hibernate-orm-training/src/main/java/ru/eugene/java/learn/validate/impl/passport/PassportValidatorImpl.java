package ru.eugene.java.learn.validate.impl.passport;

import org.springframework.stereotype.Service;
import ru.eugene.java.learn.data.Passport;
import ru.eugene.java.learn.exception.ValidateException;

@Service
@Deprecated
public class PassportValidatorImpl implements PassportValidator {
    @Override
    public void validate(Passport passport) throws ValidateException {
        String uin = passport.getUin();
        if(uin == null){
            throw new ValidateException("Идентификационный номер паспорта должен быть задан");
        }
        assetContainsUINSymbols(uin);
        assertContainsFirstSixDigits(uin);
        int lastSplit = assertArbitrarySymbols(uin);
        assertLastFourDigits(uin, lastSplit);
    }

    private void assetContainsUINSymbols(String uin) throws ValidateException {
        if(uin.length() < 17){
            throw new ValidateException(
                    "Длина идентификационного номера паспорта должна быть не менее 17 символов"
            );
        }
        char firstSymbol = uin.charAt(0);
        char secondSymbol = uin.charAt(1);
        char thirdSymbol = uin.charAt(2);
        char split = uin.charAt(3);
        if(firstSymbol != 'u' || secondSymbol != 'i' || thirdSymbol != 'n'){
            throw new ValidateException("Идентификационный номер паспорта должен начинаться с символов 'uin'");
        }
        if(split != '-'){
            throw new ValidateException(
                    "В идентификационном номере паспорта упущен разделительный знак '-' после 'uin'"
            );
        }
    }

    private void assertContainsFirstSixDigits(String uin) throws ValidateException {
        String firstSixDigits = uin.substring(4, 10);
        boolean matches = firstSixDigits.matches("\\d{6}");
        if(!matches){
            throw new ValidateException(
                    "В идентификационном номере паспорта пропущены первые шесть цифр"
            );
        }
        char split = uin.charAt(10);
        if(split != '-'){
            throw new ValidateException(
                    "В идентификационном номере паспорта упущен разделительный знак '-'" +
                            " после первых шести цифр"
            );
        }
    }

    private int assertArbitrarySymbols(String uin) throws ValidateException {
        int lastSplit = uin.indexOf("-", 11);
        if(lastSplit == -1 || uin.charAt(lastSplit) != '-'){
            throw new ValidateException("В идентификационном номере паспорта не найден последний разделительный символ ");
        }
        String arbitrarySymbols = uin.substring(11, lastSplit);
        int lengthArbitrary = arbitrarySymbols.length();
        if(lengthArbitrary < 5 || lengthArbitrary > 15){
            throw new ValidateException(
                    "В идентификационном номере паспорта длина промежуточных символово " +
                            "должна быть не менее 5 и не болле 15"
            );
        }
        return lastSplit + 1;
    }

    private void assertLastFourDigits(String uin, int lastDigit) throws ValidateException {
        String lastFourDigits = uin.substring(lastDigit);
        boolean matches = lastFourDigits.matches("\\d{4}");
        if(!matches){
            throw new ValidateException(
                    "В идентификационном номере паспорта пропущены последние четыре цифры"
            );
        }
    }
}
