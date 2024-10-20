import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.regex.Pattern;

public class PhoneGeneratorTests {

    @RepeatedTest(1000)
    public void generatePhoneWithoutCountry() {
        PhoneNumberGenerator phoneNumberGenerator = new PhoneNumberGenerator();
        var number = phoneNumberGenerator.generatePhoneNumber();
        Pattern pattern = Pattern.compile("^(\\+7)9([0-9]{2})([0-9]{7})$");

        Assertions.assertTrue(pattern.matcher(number).matches(),
                String.format("Phone number do not match with regular expression:\nPhone number:%s\nRegular expression:%s",
                        number, pattern.pattern()));
    }

    @RepeatedTest(1000)
    public void generatePhoneWithUSCountry() {
        PhoneNumberGenerator phoneNumberGenerator = new PhoneNumberGenerator(Country.US);
        var number = phoneNumberGenerator.generatePhoneNumber();
        Pattern pattern = Pattern.compile("^(\\+1)([2-9][0-9]{2})([0-9]{7})$");

        Assertions.assertTrue(pattern.matcher(number).matches(),
                String.format("Phone number do not match with regular expression:\nPhone number:%s\nRegular expression:%s",
                        number, pattern.pattern()));
    }

    @RepeatedTest(1000)
    public void generatePhoneWithRuInternalCountry() {
        PhoneNumberGenerator phoneNumberGenerator = new PhoneNumberGenerator(Country.RU_INTERNAL);
        var number = phoneNumberGenerator.generatePhoneNumber();
        Pattern pattern = Pattern.compile("^(8)9([0-9]{2})([0-9]{7})$");

        Assertions.assertTrue(pattern.matcher(number).matches(),
                String.format("Phone number do not match with regular expression:\nPhone number:%s\nRegular expression:%s",
                        number, pattern.pattern()));
    }
}
