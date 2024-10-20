import lombok.Getter;

@Getter
public enum Country {

    RU("7", "operator_codes/russia.txt"),
    RU_INTERNAL("8", "operator_codes/russia.txt"),
    US("1", "operator_codes/united_states.txt");

    private final String countryCode;
    private final String operatorsCodesPath;

    Country(String countryCode, String operatorsCodesPath) {
        this.countryCode = countryCode;
        this.operatorsCodesPath = operatorsCodesPath;
    }
}
