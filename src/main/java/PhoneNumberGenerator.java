import lombok.SneakyThrows;

import java.util.List;
import java.util.Random;

public class PhoneNumberGenerator {
    private Country country;
    private final List<String> prefixList;
    private final Random random = new Random();

    @SneakyThrows
    public PhoneNumberGenerator() {
        this.country = Country.RU;
        prefixList = Utils.convertCodesToList(country.getOperatorsCodesPath());
    }

    @SneakyThrows
    public PhoneNumberGenerator(Country country) {
        this.country = country;
        prefixList = Utils.convertCodesToList(country.getOperatorsCodesPath());
    }


    private String generatePrefix() {
        var randomPrefixIndex = random.nextInt(0, prefixList.size() - 1);
        return prefixList.get(randomPrefixIndex);
    }

    public String generatePhoneNumber() {
        StringBuilder number = new StringBuilder();
        if (this.country != Country.RU_INTERNAL) {
            number.append("+");
        }

        number.append(this.country.getCountryCode())
                .append(generatePrefix());

        for (int i = 0; i < 7; i++) {
            number.append(random.nextInt(0, 9));
        }
        return number.toString();
    }
}