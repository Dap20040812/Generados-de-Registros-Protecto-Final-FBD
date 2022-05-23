/**
 * @author : DAP - PAU - JAVS
 */
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

    /**
     * Country class constructor
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
     */
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

    public void setCode(String code) {
        this.Code.set(code);
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public void setContinent(String continent) {
        this.Continent.set(continent);
    }

    public void setRegion(String region) {
        this.Region.set(region);
    }

    public void setSurfaceArea(String surfaceArea) {
        this.SurfaceArea.set(surfaceArea);
    }

    public void setIndepYear(String indepYear) {
        this.IndepYear.set(indepYear);
    }

    public void setPopulation(String population) {
        this.Population.set(population);
    }

    public void setLifeExpectancy(String lifeExpectancy) {
        this.LifeExpectancy.set(lifeExpectancy);
    }

    public void setGnp(String gnp) {
        this.Gnp.set(gnp);
    }

    public void setGnpOld(String gnpOld) {
        this.GnpOld.set(gnpOld);
    }

    public void setLocalName(String localName) {
        this.LocalName.set(localName);
    }

    public void setGovernmentForm(String governmentForm) {
        this.GovernmentForm.set(governmentForm);
    }

    public void setHeadOfState(String headOfState) {
        this.HeadOfState.set(headOfState);
    }

    public void setCapital(String capital) {
        this.Capital.set(capital);
    }

    public void setCode2(String code2) {
        this.Code2.set(code2);
    }
}
