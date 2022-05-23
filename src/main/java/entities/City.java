/**
 * @author : DAP - PAU - JAVS
 */
package entities;

import javafx.beans.property.SimpleStringProperty;

public class City {

    SimpleStringProperty Id;
    SimpleStringProperty Name;
    SimpleStringProperty CountryCode;
    SimpleStringProperty District;
    SimpleStringProperty Population;

    /**
     * City Class Constructor
     * @param id
     * @param name
     * @param countryCode
     * @param district
     * @param population
     */
    public City(String id, String name, String countryCode, String district, String population) {
        this.Id = new SimpleStringProperty(id);
        this.Name = new SimpleStringProperty(name);
        this.CountryCode = new SimpleStringProperty(countryCode);
        this.District = new SimpleStringProperty(district);
        this.Population = new SimpleStringProperty(population);
    }

    /**
     *
     * @return id city
     */
    public String getID() {
        return Id.get();
    }

    /**
     *
     * @return city name
     */
    public String getName() {
        return Name.get();
    }

    /**
     *
     * @return city CountryCode
     */
    public String getCountryCode() {
        return CountryCode.get();
    }

    /**
     *
     * @return city District
     */
    public String getDistrict() {
        return District.get();
    }

    /**
     *
     * @return city Population
     */
    public String getPopulation() {
        return Population.get();
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.Id.set(id);
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.Name.set(name);
    }

    /**
     *
     * @param countryCode
     */
    public void setCountryCode(String countryCode) {
        this.CountryCode.set(countryCode);
    }

    /**
     *
     * @param district
     */
    public void setDistrict(String district) {
        this.District.set(district);
    }

    /**
     *
     * @param population
     */
    public void setPopulation(String population) {
        this.Population.set(population);
    }
}
