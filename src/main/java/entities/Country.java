package entities;

import javafx.beans.property.SimpleStringProperty;

public class Country {

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

    public Country(String code, String name, String continent, String region, String surfaceArea, String indepYear, String population, String lifeExpectancy, String GNP, String GNPOld, String localName, String governmentForm, String headOfState, String capital, String code2) {
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
    }

    public String getCode() {
        return Code.get();
    }

    public String getName() {
        return Name.get();
    }

    public String getContinent() {
        return Continent.get();
    }

    public String getRegion() {
        return Region.get();
    }

    public String getSurfaceArea() {
        return SurfaceArea.get();
    }

    public String getIndepYear() {
        return IndepYear.get();
    }

    public String getPopulation() {
        return Population.get();
    }

    public String getLifeExpectancy() {
        return LifeExpectancy.get();
    }

    public String getGnp() {
        return Gnp.get();
    }

    public String getGnpOld() {
        return GnpOld.get();
    }

    public String getLocalName() {
        return LocalName.get();
    }

    public String getGovernmentForm() {
        return GovernmentForm.get();
    }

    public String getHeadOfState() {
        return HeadOfState.get();
    }

    public String getCapital() {
        return Capital.get();
    }

    public String getCode2() {
        return Code2.get();
    }
}
