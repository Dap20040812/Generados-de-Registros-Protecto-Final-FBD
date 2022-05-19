package entities;

import javafx.beans.property.SimpleStringProperty;

public class Language {

    SimpleStringProperty CountryCode = new SimpleStringProperty();
    SimpleStringProperty Language;
    SimpleStringProperty IsOfficial;
    SimpleStringProperty Percentage;

    public Language(String countryCode, String language, String isOfficial, String percentage) {
       this.CountryCode = new SimpleStringProperty(countryCode);
       this.Language = new SimpleStringProperty(language);
       this.IsOfficial = new SimpleStringProperty(isOfficial);
       this.Percentage = new SimpleStringProperty(percentage);
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

    public void setCountryCode(String countryCode) {
        this.CountryCode.set(countryCode);
    }

    public void setLanguage(String language) {
        this.Language.set(language);
    }

    public void setIsOfficial(String isOfficial) {
        this.IsOfficial.set(isOfficial);
    }

    public void setPercentage(String percentage) {
        this.Percentage.set(percentage);
    }
}