package entities;

import javafx.beans.property.SimpleStringProperty;

public class Language {

    SimpleStringProperty CountryCode;
    SimpleStringProperty Language;
    SimpleStringProperty IsOfficial;
    SimpleStringProperty Percentage;

    public Language(String countryCode, String language, String isOfficial, String percentage) {
        CountryCode = new SimpleStringProperty(countryCode);
        Language = new SimpleStringProperty(language);
        IsOfficial = new SimpleStringProperty(isOfficial);
        Percentage = new SimpleStringProperty(percentage);
    }

    public String getCountryCode() {
        return CountryCode.get();
    }

    public SimpleStringProperty countryCodeProperty() {
        return CountryCode;
    }

    public String getLanguage() {
        return Language.get();
    }

    public SimpleStringProperty languageProperty() {
        return Language;
    }

    public String getIsOfficial() {
        return IsOfficial.get();
    }

    public SimpleStringProperty isOfficialProperty() {
        return IsOfficial;
    }

    public String getPercentage() {
        return Percentage.get();
    }

    public SimpleStringProperty percentageProperty() {
        return Percentage;
    }
}
