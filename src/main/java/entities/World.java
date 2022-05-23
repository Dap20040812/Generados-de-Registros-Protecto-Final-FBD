package entities;

import javafx.beans.property.SimpleStringProperty;

public class World {

    SimpleStringProperty Id;
    SimpleStringProperty CityName;
    SimpleStringProperty CountryCode;
    SimpleStringProperty District;
    SimpleStringProperty CityPopulation;
    SimpleStringProperty Code;
    SimpleStringProperty Name;
    SimpleStringProperty Continent;
    SimpleStringProperty Region;
    SimpleStringProperty SurfaceArea;
    SimpleStringProperty IndepYear;
    SimpleStringProperty Population;
    SimpleStringProperty LifeExpectancy;
    SimpleStringProperty Gnp;
    SimpleStringProperty GnpOld;
    SimpleStringProperty LocalName;
    SimpleStringProperty GovernmentForm;
    SimpleStringProperty HeadOfState;
    SimpleStringProperty Capital;
    SimpleStringProperty Code2;
    SimpleStringProperty CountryCodeL;
    SimpleStringProperty Language;
    SimpleStringProperty IsOfficial;
    SimpleStringProperty Percentage;

    /**
     * World Class constructor
     * @param id
     * @param cityName
     * @param countryCode
     * @param district
     * @param cityPopulation
     * @param code
     * @param name
     * @param continent
     * @param region
     * @param surfaceArea
     * @param indepYear
     * @param population
     * @param lifeExpectancy
     * @param GNP
     * @param GNPOld
     * @param localName
     * @param governmentForm
     * @param headOfState
     * @param capital
     * @param code2
     * @param countryCodeL
     * @param language
     * @param isOfficial
     * @param percentage
     */
    public World(String id, String cityName, String countryCode, String district, String cityPopulation, String code, String name, String continent, String region, String surfaceArea, String indepYear, String population, String lifeExpectancy, String GNP, String GNPOld, String localName, String governmentForm, String headOfState, String capital, String code2, String countryCodeL, String language, String isOfficial, String percentage) {
        this.Id = new SimpleStringProperty(id);
        this.CityName = new SimpleStringProperty(cityName);
        this.CountryCode = new SimpleStringProperty(countryCode);
        this.District = new SimpleStringProperty(district);
        this.CityPopulation = new SimpleStringProperty(cityPopulation);
        Code = new SimpleStringProperty(code);
        Name = new SimpleStringProperty(name);
        Continent = new SimpleStringProperty(continent);
        Region = new SimpleStringProperty(region);
        SurfaceArea = new SimpleStringProperty(surfaceArea);
        IndepYear = new SimpleStringProperty(indepYear);
        Population = new SimpleStringProperty(population);
        LifeExpectancy = new SimpleStringProperty(lifeExpectancy);
        Gnp = new SimpleStringProperty(GNP);
        GnpOld = new SimpleStringProperty(GNPOld);
        LocalName = new SimpleStringProperty(localName);
        GovernmentForm = new SimpleStringProperty(governmentForm);
        HeadOfState = new SimpleStringProperty(headOfState);
        Capital = new SimpleStringProperty(capital);
        Code2 = new SimpleStringProperty(code2);
        CountryCodeL = new SimpleStringProperty(countryCodeL);
        Language = new SimpleStringProperty(language);
        IsOfficial = new SimpleStringProperty(isOfficial);
        Percentage = new SimpleStringProperty(percentage);
    }

    public String getId() {
        return Id.get();
    }

    public SimpleStringProperty idProperty() {
        return Id;
    }

    public String getCityName() {
        return CityName.get();
    }

    public SimpleStringProperty cityNameProperty() {
        return CityName;
    }

    public String getCountryCode() {
        return CountryCode.get();
    }

    public SimpleStringProperty countryCodeProperty() {
        return CountryCode;
    }

    public String getDistrict() {
        return District.get();
    }

    public SimpleStringProperty districtProperty() {
        return District;
    }

    public String getCityPopulation() {
        return CityPopulation.get();
    }

    public SimpleStringProperty cityPopulationProperty() {
        return CityPopulation;
    }

    public String getCode() {
        return Code.get();
    }

    public SimpleStringProperty codeProperty() {
        return Code;
    }

    public String getName() {
        return Name.get();
    }

    public SimpleStringProperty nameProperty() {
        return Name;
    }

    public String getContinent() {
        return Continent.get();
    }

    public SimpleStringProperty continentProperty() {
        return Continent;
    }

    public String getRegion() {
        return Region.get();
    }

    public SimpleStringProperty regionProperty() {
        return Region;
    }

    public String getSurfaceArea() {
        return SurfaceArea.get();
    }

    public SimpleStringProperty surfaceAreaProperty() {
        return SurfaceArea;
    }

    public String getIndepYear() {
        return IndepYear.get();
    }

    public SimpleStringProperty indepYearProperty() {
        return IndepYear;
    }

    public String getPopulation() {
        return Population.get();
    }

    public SimpleStringProperty populationProperty() {
        return Population;
    }

    public String getLifeExpectancy() {
        return LifeExpectancy.get();
    }

    public SimpleStringProperty lifeExpectancyProperty() {
        return LifeExpectancy;
    }

    public String getGnp() {
        return Gnp.get();
    }

    public SimpleStringProperty gnpProperty() {
        return Gnp;
    }

    public String getGnpOld() {
        return GnpOld.get();
    }

    public SimpleStringProperty gnpOldProperty() {
        return GnpOld;
    }

    public String getLocalName() {
        return LocalName.get();
    }

    public SimpleStringProperty localNameProperty() {
        return LocalName;
    }

    public String getGovernmentForm() {
        return GovernmentForm.get();
    }

    public SimpleStringProperty governmentFormProperty() {
        return GovernmentForm;
    }

    public String getHeadOfState() {
        return HeadOfState.get();
    }

    public SimpleStringProperty headOfStateProperty() {
        return HeadOfState;
    }

    public String getCapital() {
        return Capital.get();
    }

    public SimpleStringProperty capitalProperty() {
        return Capital;
    }

    public String getCode2() {
        return Code2.get();
    }

    public SimpleStringProperty code2Property() {
        return Code2;
    }

    public String getCountryCodeL() {
        return CountryCodeL.get();
    }

    public SimpleStringProperty countryCodeLProperty() {
        return CountryCodeL;
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
