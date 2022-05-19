package entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.logging.SimpleFormatter;

public class City {
    SimpleStringProperty Id = new SimpleStringProperty();
    SimpleStringProperty Name = new SimpleStringProperty();
    SimpleStringProperty CountryCode;
    SimpleStringProperty District;
    SimpleStringProperty Population;

    public City(String id, String name, String countryCode, String district, String population) {
        this.Id = new SimpleStringProperty(id);
        this.Name = new SimpleStringProperty(name);
        this.CountryCode = new SimpleStringProperty(countryCode);
        this.District = new SimpleStringProperty(district);
        this.Population = new SimpleStringProperty(population);
    }

    public String getID() {
        return Id.get();
    }

    public String getName() {
        return Name.get();
    }

    public String getCountryCode() {
        return CountryCode.get();
    }

    public String getDistrict() {
        return District.get();
    }

    public String getPopulation() {
        return Population.get();
    }

    public void setId(String id) {
        this.Id.set(id);
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public void setCountryCode(String countryCode) {
        this.CountryCode.set(countryCode);
    }

    public void setDistrict(String district) {
        this.District.set(district);
    }

    public void setPopulation(String population) {
        this.Population.set(population);
    }
}