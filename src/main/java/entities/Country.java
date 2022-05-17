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
    SimpleStringProperty GNP;
    SimpleStringProperty GNPOld;
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
        this.GNP = new SimpleStringProperty(GNP);
        this.GNPOld = new SimpleStringProperty(GNPOld);
        LocalName = new SimpleStringProperty(localName);
        GovernmentForm = new SimpleStringProperty(governmentForm);
        HeadOfState = new SimpleStringProperty(headOfState);
        Capital = new SimpleStringProperty(capital);
        Code2 = new SimpleStringProperty(code2);
    }
}
