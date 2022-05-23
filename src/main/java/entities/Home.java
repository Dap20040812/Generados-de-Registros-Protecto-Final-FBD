package entities;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Popup;
import javafx.stage.Window;
import javafx.util.Callback;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML public Button update;
    @FXML public Button ok;
    //City

    //Table
    @FXML
    private TableView<City> myCityTable;
    //Columns
    @FXML public TableColumn<City, String> myCityID;
    @FXML public TableColumn<City, String> myCityName;
    @FXML public TableColumn<City, String> myCityCode;
    @FXML public TableColumn<City, String> myCityDis;
    @FXML public TableColumn<City, String> myCityPopu;
    //TextFields
    @FXML public TextField cityCode;
    @FXML public TextField cityDistrict;
    @FXML public TextField cityId;
    @FXML public TextField cityName;
    @FXML public TextField cityPopulation;
    @FXML public TextField cityIDc1;
    @FXML public TextField cityNamec1;
    @FXML public TextField cityCodec1;
    @FXML public TextField cityDistc1;
    @FXML public TextField cityPopuc1;

    //checkbox
    @FXML public  CheckBox cityCheck;
    @FXML public CheckBox cityIDc;
    @FXML public CheckBox cityCodec;
    @FXML public CheckBox cityNamec;
    @FXML public CheckBox cityDistc;
    @FXML public CheckBox cityPopuc;
    //Country

    //Table
    @FXML
    private TableView<Country> myCountryTable;
    //Columns
    @FXML public TableColumn<Country, String> myCountryCode;
    @FXML public TableColumn<Country, String> myCountryName;
    @FXML public TableColumn<Country, String> myCountryContinent;
    @FXML public TableColumn<Country, String> myCountryRegion;
    @FXML public TableColumn<Country, String> myCountryArea;
    @FXML public TableColumn<Country, String> myCountryIndep;
    @FXML public TableColumn<Country, String> myCountryPopu;
    @FXML public TableColumn<Country, String> myCountryLife;
    @FXML public TableColumn<Country, String> myCountryGNP;
    @FXML public TableColumn<Country, String> myCountryGNPOld;
    @FXML public TableColumn<Country, String> myCountryLocal;
    @FXML public TableColumn<Country, String> myCountryGoverment;
    @FXML public TableColumn<Country, String> myCountryState;
    @FXML public TableColumn<Country, String> myCountryCapital;
    @FXML public TableColumn<Country, String> myCountryCode2;
    //TextFields
    @FXML public TextField countryCode;
    @FXML public TextField countryName;
    @FXML public TextField countryContinent;
    @FXML public TextField countryRegion;
    @FXML public TextField countrySurfaceArea;
    @FXML public TextField countryIndepYear;
    @FXML public TextField countryPopulation;
    @FXML public TextField countryLifeExpectancy;
    @FXML public TextField countryGNP;
    @FXML public TextField countryGNPOld;
    @FXML public TextField countryLocalName;
    @FXML public TextField countryGovernmentForm;
    @FXML public TextField countryHeadOfState;
    @FXML public TextField countryCapital;
    @FXML public TextField countryCode2;

    @FXML public TextField countryCode1;
    @FXML public TextField countryName1;
    @FXML public TextField countryContinent1;
    @FXML public TextField countryRegion1;
    @FXML public TextField countrySurfaceArea1;
    @FXML public TextField countryIndepYear1;
    @FXML public TextField countryPopulation1;
    @FXML public TextField countryLifeExpectancy1;
    @FXML public TextField countryGNP1;
    @FXML public TextField countryGNPOld1;
    @FXML public TextField countryLocalName1;
    @FXML public TextField countryGovernmentForm1;
    @FXML public TextField countryHeadOfState1;
    @FXML public TextField countryCapital1;
    @FXML public TextField countryCode21;

    //checkbox
    @FXML public CheckBox countryCheck;
    @FXML public CheckBox countryCodec;
    @FXML public CheckBox countryNamec;
    @FXML public CheckBox countryContinentc;
    @FXML public CheckBox countryRegionc;
    @FXML public CheckBox countrySurfaceAreac;
    @FXML public CheckBox countryIndepYearc;
    @FXML public CheckBox countryPopulationc;
    @FXML public CheckBox countryLifeExpectancyc;
    @FXML public CheckBox countryGNPc;
    @FXML public CheckBox countryGNPOldc;
    @FXML public CheckBox countryLocalNamec;
    @FXML public CheckBox countryGovernmentFormc;
    @FXML public CheckBox countryHeadOfStatec;
    @FXML public CheckBox countryCapitalc;
    @FXML public CheckBox countryCode2c;


    @FXML public Button update2;
    @FXML public Button ok2;


    //Language
    //Table
    @FXML
    private TableView<Language> myLanguageTable;

    //Columns
    @FXML public TableColumn<Language, String> myLanguageCode;
    @FXML public TableColumn<Language, String> myLanguageLanguage;
    @FXML public TableColumn<Language, String> myLanguageOfficial;
    @FXML public TableColumn<Language, String> myLanguagePercentage;
    //TextFields
    @FXML public TextField languageCountryCode;
    @FXML public TextField languageLanguage;
    @FXML public TextField languageIsOfficial;
    @FXML public TextField languagePercentage;
    @FXML public TextField languageCountryCode1;
    @FXML public TextField languageLanguage1;
    @FXML public TextField languageIsOfficial1;
    @FXML public TextField languagePercentage1;

    //checkbox
    @FXML public CheckBox languageCheck;
    @FXML public CheckBox languagePercentage2;
    @FXML public CheckBox languageCountryCode2;
    @FXML public CheckBox languageLanguage2;
    @FXML public CheckBox languageIsOfficial2;

    @FXML public Button update1;
    @FXML public Button ok1;



    @FXML public Tab tabR;
    @FXML public TabPane tabG;


    private final ObservableList<City> cities = FXCollections.observableArrayList();
    private final ObservableList<Country> countries = FXCollections.observableArrayList();
    private final ObservableList<Language> languages = FXCollections.observableArrayList();

    @FXML public TableView myRegistrosTable;

    public void GenerateCity() {

        try {
            int ID = 1;
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM city ");
            while (rs.next()) {
                String  Name = rs.getString("Name");
                String  CountryCode = rs.getString("CountryCode");
                String District = rs.getString("District");
                String Population = rs.getString("Population");
                City city = new City(ID+"",Name,CountryCode,District,Population);
                cities.add(city);
                ID ++;
                myCityTable.refresh();
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void GenerateLanguage() {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM countryLanguage ");
            while (rs.next()) {
                String  CountryCode = rs.getString("CountryCode");
                String  Language = rs.getString("Language");
                String  IsOfficial = rs.getString("IsOfficial");
                String  Percentage = rs.getString("Percentage");
                Language language = new Language(CountryCode,Language,IsOfficial,Percentage);
                languages.add(language);
                myLanguageTable.refresh();
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void GenerateCountry() {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM country ");
            while (rs.next()) {
                String  Code = rs.getString("Code");
                String  Name = rs.getString("Name");
                String  Continent = rs.getString("Continent");
                String  Region = rs.getString("Region");
                String  SurfaceArea = rs.getString("SurfaceArea");
                String  IndepYear = rs.getString("IndepYear");
                String  Population = rs.getString("Population");
                String  LifeExpectancy = rs.getString("LifeExpectancy");
                String  GNP = rs.getString("GNP");
                String  GNPOld = rs.getString("GNPOld");
                String  LocalName = rs.getString("LocalName");
                String  GovernmentForm = rs.getString("GovernmentForm");
                String  HeadOfState = rs.getString("HeadOfState");
                String  Capital = rs.getString("Capital");
                String  Code2 = rs.getString("Code2");
                Country country = new Country(Code,Name,Continent,Region,SurfaceArea,IndepYear,Population,LifeExpectancy,GNP,GNPOld,LocalName,GovernmentForm,HeadOfState,Capital,Code2);
                countries.add(country);
                myCountryTable.refresh();
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ok.setDisable(true);
        ok.setOpacity(0);
        ok1.setDisable(true);
        ok1.setOpacity(0);
        ok2.setDisable(true);
        ok2.setOpacity(0);
        GenerateCity();
        GenerateCountry();
        GenerateLanguage();
        cityIDc.setOpacity(0);
        cityIDc.setDisable(true);
        cityIDc1.setOpacity(0);
        cityIDc1.setDisable(true);
        cityNamec.setOpacity(0);
        cityNamec.setDisable(true);
        cityNamec1.setOpacity(0);
        cityNamec1.setDisable(true);
        cityCodec.setOpacity(0);
        cityCodec.setDisable(true);
        cityCodec1.setOpacity(0);
        cityCodec1.setDisable(true);
        cityDistc.setOpacity(0);
        cityDistc.setDisable(true);
        cityDistc1.setOpacity(0);
        cityDistc1.setDisable(true);
        cityPopuc.setOpacity(0);
        cityPopuc.setDisable(true);
        cityPopuc1.setOpacity(0);
        cityPopuc1.setDisable(true);
        myCityName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        myCityCode.setCellValueFactory(new PropertyValueFactory<>("CountryCode"));
        myCityID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        myCityDis.setCellValueFactory(new PropertyValueFactory<>("District"));
        myCityPopu.setCellValueFactory(new PropertyValueFactory<>("Population"));
        myCityTable.setItems(cities);

        myCountryCode.setCellValueFactory(new PropertyValueFactory<>("Code"));
        myCountryName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        myCountryContinent.setCellValueFactory(new PropertyValueFactory<>("Continent"));
        myCountryRegion.setCellValueFactory(new PropertyValueFactory<>("Region"));
        myCountryArea.setCellValueFactory(new PropertyValueFactory<>("SurfaceArea"));
        myCountryIndep.setCellValueFactory(new PropertyValueFactory<>("IndepYear"));
        myCountryPopu.setCellValueFactory(new PropertyValueFactory<>("Population"));
        myCountryLife.setCellValueFactory(new PropertyValueFactory<>("LifeExpectancy"));
        myCountryGNP.setCellValueFactory(new PropertyValueFactory<>("Gnp"));
        myCountryGNPOld.setCellValueFactory(new PropertyValueFactory<>("GnpOld"));
        myCountryLocal.setCellValueFactory(new PropertyValueFactory<>("LocalName"));
        myCountryGoverment.setCellValueFactory(new PropertyValueFactory<>("GovernmentForm"));
        myCountryState.setCellValueFactory(new PropertyValueFactory<>("HeadOfState"));
        myCountryCapital.setCellValueFactory(new PropertyValueFactory<>("Capital"));
        myCountryCode2.setCellValueFactory(new PropertyValueFactory<>("Code2"));
        myCountryTable.setItems(countries);
        countryCode1.setOpacity(0);
        countryCode1.setDisable(true);
        countryCodec.setOpacity(0);
        countryCodec.setDisable(true);
        countryName1.setOpacity(0);
        countryName1.setDisable(true);
        countryNamec.setOpacity(0);
        countryNamec.setDisable(true);
        countryContinent1.setOpacity(0);
        countryContinent1.setDisable(true);
        countryContinentc.setOpacity(0);
        countryContinentc.setDisable(true);
        countryRegion1.setOpacity(0);
        countryRegion1.setDisable(true);
        countryRegionc.setOpacity(0);
        countryRegionc.setDisable(true);
        countrySurfaceArea1.setOpacity(0);
        countrySurfaceArea1.setDisable(true);
        countrySurfaceAreac.setOpacity(0);
        countrySurfaceAreac.setDisable(true);
        countryIndepYear1.setOpacity(0);
        countryIndepYear1.setDisable(true);
        countryIndepYearc.setOpacity(0);
        countryIndepYearc.setDisable(true);
        countryPopulation1.setOpacity(0);
        countryPopulation1.setDisable(true);
        countryPopulationc.setOpacity(0);
        countryPopulationc.setDisable(true);
        countryLifeExpectancy1.setOpacity(0);
        countryLifeExpectancy1.setDisable(true);
        countryLifeExpectancyc.setOpacity(0);
        countryLifeExpectancyc.setDisable(true);
        countryGNP1.setOpacity(0);
        countryGNP1.setDisable(true);
        countryGNPc.setOpacity(0);
        countryGNPc.setDisable(true);
        countryGNPOld1.setOpacity(0);
        countryGNPOld1.setDisable(true);
        countryGNPOldc.setOpacity(0);
        countryGNPOldc.setDisable(true);
        countryLocalName1.setOpacity(0);
        countryLocalName1.setDisable(true);
        countryLocalNamec.setOpacity(0);
        countryLocalNamec.setDisable(true);
        countryGovernmentForm1.setOpacity(0);
        countryGovernmentForm1.setDisable(true);
        countryGovernmentFormc.setOpacity(0);
        countryGovernmentFormc.setDisable(true);
        countryHeadOfState1.setOpacity(0);
        countryHeadOfState1.setDisable(true);
        countryHeadOfStatec.setOpacity(0);
        countryHeadOfStatec.setDisable(true);
        countryCapital1.setOpacity(0);
        countryCapital1.setDisable(true);
        countryCapitalc.setOpacity(0);
        countryCapitalc.setDisable(true);
        countryCode21.setOpacity(0);
        countryCode21.setDisable(true);
        countryCode2c.setOpacity(0);
        countryCode2c.setDisable(true);




        myLanguageCode.setCellValueFactory(new PropertyValueFactory<>("CountryCode"));
        myLanguageLanguage.setCellValueFactory(new PropertyValueFactory<>("Language"));
        myLanguageOfficial.setCellValueFactory(new PropertyValueFactory<>("IsOfficial"));
        myLanguagePercentage.setCellValueFactory(new PropertyValueFactory<>("Percentage"));
        myLanguageTable.setItems(languages);

        languageCountryCode2.setOpacity(0);
        languageCountryCode2.setDisable(true);
        languageCountryCode1.setOpacity(0);
        languageCountryCode1.setDisable(true);
        languageLanguage2.setOpacity(0);
        languageLanguage2.setDisable(true);
        languageLanguage1.setOpacity(0);
        languageLanguage1.setDisable(true);
        languageIsOfficial2.setOpacity(0);
        languageIsOfficial2.setDisable(true);
        languageIsOfficial1.setOpacity(0);
        languageIsOfficial1.setDisable(true);
        languagePercentage2.setOpacity(0);
        languagePercentage2.setDisable(true);
        languagePercentage1.setOpacity(0);
        languagePercentage1.setDisable(true);




    }

    @FXML
    private void añadirCity(ActionEvent event){
        City city = new City("","","","","");
        city.CountryCode.set(cityCode.getText());
        city.District.set(cityDistrict.getText());
        city.Id.set(cityId.getText());
        city.Name.set(cityName.getText());
        city.Population.set(cityPopulation.getText());
        System.out.println(city);
        cities.add(city);
        myCityTable.setItems(cities);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO city VALUES ('"+cityId.getText()+"','"+cityName.getText()+"','"+cityCode.getText()+"','"+cityDistrict.getText()+"','"+cityPopulation.getText()+"')");
            con.close();
            System.out.println("ok");
        }
        catch (Exception e){
            System.out.println(e);
        }
        myCityTable.refresh();
        cityCode.setText("");
        cityDistrict.setText("");
        cityId.setText("");
        cityName.setText("");
        cityPopulation.setText("");
    }

    @FXML
    private void deleteCity(ActionEvent event){
        final City c = myCityTable.getSelectionModel().getSelectedItems().get(0);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            stmt.execute("DELETE FROM city WHERE ID = "+"'"+c.Id.getValue()+"'");
            con.close();
            System.out.println("ok");
        }
        catch (Exception e){
            System.out.println(e);
        }
        cities.remove(c);
        myCityTable.setItems(cities);
        myCityTable.refresh();

    }

    @FXML
    private void updateCity(ActionEvent event){
        final City c = myCityTable.getSelectionModel().getSelectedItems().get(0);
        cityName.setText(c.Name.getValue());
        cityId.setText(c.Id.getValue());
        cityCode.setText(c.CountryCode.getValue());
        cityDistrict.setText(c.District.getValue());
        cityPopulation.setText(c.Population.getValue());
        update.setDisable(true);
        ok.setDisable(false);
        ok.setOpacity(1);
        update.setOpacity(0);
    }
    @FXML
    private void updateCity1(ActionEvent event){

        City city = new City("","","","","");
        city.CountryCode.set(cityCode.getText());
        city.District.set(cityDistrict.getText());
        city.Id.set(cityId.getText());
        city.Name.set(cityName.getText());
        city.Population.set(cityPopulation.getText());
        for (City citi:cities) {
            if (citi.Id.getValue().equals(city.Id.getValue())) {
                citi.setCountryCode(city.CountryCode.getValue());
                citi.setName(city.Name.getValue());
                citi.setDistrict(city.District.getValue());
                citi.setId(city.Id.getValue());
                citi.setPopulation(city.Population.getValue());
            }
        }
        myCityTable.setItems(cities);
        myCityTable.refresh();
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE city SET ID = "+"'"+city.Id.getValue()+"', Name = '"+city.Name.getValue()+"',CountryCode = '"+city.CountryCode.getValue()+"', District = '"+city.District.getValue()+"', Population = '"+city.Population.getValue()+"' WHERE ID = '"+city.Id.getValue()+"'");
            con.close();
            System.out.println("ok");
        }
        catch (Exception e){
            System.out.println(e);
        }
        cityName.setText("");
        cityId.setText("");
        cityPopulation.setText("");
        cityDistrict.setText("");
        cityCode.setText("");
        update.setDisable(false);
        ok.setDisable(true);
        ok.setOpacity(0);
        update.setOpacity(1);
    }



    @FXML
    private void añadirLanguage(ActionEvent event){
        Language language = new Language("","","","");
        language.CountryCode.set(languageCountryCode.getText());
        language.Language.set(languageLanguage.getText());
        language.IsOfficial.set(languageIsOfficial.getText());
        language.Percentage.set(languagePercentage.getText());
        System.out.println(language);
        languages.add(language);
        myLanguageTable.setItems(languages);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO countryLanguage VALUES ('"+languageCountryCode.getText()+"','"+languageLanguage.getText()+"','"+languageIsOfficial.getText()+"','"+languagePercentage.getText()+"')");
            con.close();
            System.out.println("ok");
        }
        catch (Exception e){
            System.out.println(e);
        }
        myLanguageTable.refresh();
        languageCountryCode.setText("");
        languageLanguage.setText("");
        languageIsOfficial.setText("");
        languagePercentage.setText("");
    }

    @FXML
    private void deleteLanguage(ActionEvent event){
        final Language l = myLanguageTable.getSelectionModel().getSelectedItems().get(0);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            stmt.execute("DELETE FROM countryLanguage WHERE CountryCode = "+"'"+l.CountryCode.getValue()+"'");
            con.close();
            System.out.println("ok");
        }
        catch (Exception e){
            System.out.println(e);
        }
        languages.remove(l);
        myLanguageTable.setItems(languages);
        myLanguageTable.refresh();

    }

    @FXML
    private void updateLanguage(ActionEvent event){
        final Language l = myLanguageTable.getSelectionModel().getSelectedItems().get(0);
        languageCountryCode.setText(l.CountryCode.getValue());
        languageLanguage.setText(l.Language.getValue());
        languageIsOfficial.setText(l.IsOfficial.getValue());
        languagePercentage.setText(l.Percentage.getValue());
        update1.setDisable(true);
        ok1.setDisable(false);
        ok1.setOpacity(1);
        update1.setOpacity(0);
    }
    @FXML
    private void updateLanguage1(ActionEvent event){

        Language language = new Language("","","","");
        language.CountryCode.set(languageCountryCode.getText());
        language.Language.set(languageLanguage.getText());
        language.IsOfficial.set(languageIsOfficial.getText());
        language.Percentage.set(languagePercentage.getText());
        for (Language languagee:languages) {
            if (languagee.CountryCode.getValue().equals(language.CountryCode.getValue())) {
                languagee.setCountryCode(language.CountryCode.getValue());
                languagee.setLanguage(language.CountryCode.getValue());
                languagee.setIsOfficial(language.IsOfficial.getValue());
                languagee.setPercentage(language.Percentage.getValue());
            }
        }
        myLanguageTable.setItems(languages);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE CountryLanguage SET CountryCode = "+"'"+language.CountryCode.getValue()+"',CountryCode = '"+language.CountryCode.getValue()+"', Language = '"+language.Language.getValue()+"', IsOfficial = '"+language.IsOfficial.getValue()+", Percentage = '"+language.Percentage.getValue()+"' WHERE CountryCode = '"+language.CountryCode.getValue()+"'");
            con.close();
            System.out.println("ok");
        }
        catch (Exception e){
            System.out.println(e);
        }
        myLanguageTable.refresh();
        languageCountryCode.setText("");
        languageLanguage.setText("");
        languageIsOfficial.setText("");
        languagePercentage.setText("");
        update1.setDisable(false);
        ok1.setDisable(true);
        ok1.setOpacity(0);
        update1.setOpacity(1);
    }

    // Country

    @FXML
    private void añadirCountry(ActionEvent event){
        Country country = new Country("","","","","","","","","","","","","","","");
        country.Code.set(countryCode.getText());
        country.Name.set(countryName.getText());
        country.Continent.set(countryContinent.getText());
        country.Region.set(countryRegion.getText());
        country.SurfaceArea.set(countrySurfaceArea.getText());
        country.IndepYear.set(countryIndepYear.getText());
        country.Population.set(countryPopulation.getText());
        country.LifeExpectancy.set(countryLifeExpectancy.getText());
        country.Gnp.set(countryGNP.getText());
        country.GnpOld.set(countryGNPOld.getText());
        country.LocalName.set(countryLocalName.getText());
        country.GovernmentForm.set(countryGovernmentForm.getText());
        country.HeadOfState.set(countryHeadOfState.getText());
        country.Capital.set(countryCapital.getText());
        country.Code2.set(countryCode2.getText());
        System.out.println(country);
        countries.add(country);
        myCountryTable.setItems(countries);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO country VALUES ('"+country.Code.getValue()+"','"+country.Name.getValue()+"','"+country.Continent.getValue()+"','"+country.Region.getValue()+"','"+country.SurfaceArea.getValue()+"','"+country.IndepYear.getValue()+"','"+country.Population.getValue()+"','"+country.LifeExpectancy.getValue()+"','"+country.Gnp.getValue()+"','"+country.GnpOld.getValue()+"','"+country.LocalName.getValue()+"','"+country.GovernmentForm.getValue()+"','"+country.HeadOfState.getValue()+"','"+country.Capital.getValue()+"','"+country.Code2.getValue()+"')");
            con.close();
            System.out.println("ok");
        }
        catch (Exception e){
            System.out.println(e);
        }
        myCountryTable.refresh();
        countryCode.setText("");
        countryName.setText("");
        countryContinent.setText("");
        countryRegion.setText("");
        countrySurfaceArea.setText("");
        countryIndepYear.setText("");
        countryPopulation.setText("");
        countryLifeExpectancy.setText("");
        countryGNP.setText("");
        countryGNPOld.setText("");
        countryLocalName.setText("");
        countryGovernmentForm.setText("");
        countryHeadOfState.setText("");
        countryCapital.setText("");
        countryCode2.setText("");

    }

    @FXML
    private void deleteCountry(ActionEvent event){
        final Country co = myCountryTable.getSelectionModel().getSelectedItems().get(0);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            stmt.execute("DELETE FROM county WHERE Code = "+"'"+co.Code.getValue()+"'");
            con.close();
            System.out.println("ok");
        }
        catch (Exception e){
            System.out.println(e);
        }
        countries.remove(co);
        myCountryTable.setItems(countries);
        myCountryTable.refresh();

    }

    @FXML
    private void updateCountry(ActionEvent event){
        final Country co = myCountryTable.getSelectionModel().getSelectedItems().get(0);
        countryCode.setText(co.Code.getValue());
        countryName.setText(co.Name.getValue());
        countryContinent.setText(co.Continent.getValue());
        countryRegion.setText(co.Region.getValue());
        countrySurfaceArea.setText(co.SurfaceArea.getValue());
        countryIndepYear.setText(co.IndepYear.getValue());
        countryPopulation.setText(co.Population.getValue());
        countryLifeExpectancy.setText(co.LifeExpectancy.getValue());
        countryGNP.setText(co.Gnp.getValue());
        countryGNPOld.setText(co.GnpOld.getValue());
        countryLocalName.setText(co.LocalName.getValue());
        countryGovernmentForm.setText(co.GovernmentForm.getValue());
        countryHeadOfState.setText(co.HeadOfState.getValue());
        countryCapital.setText(co.Capital.getValue());
        countryCode2.setText(co.Code2.getValue());

        update2.setDisable(true);
        ok2.setDisable(false);
        ok2.setOpacity(1);
        update2.setOpacity(0);
    }
    @FXML
    private void updateCountry1(ActionEvent event){

        Country country = new Country("","","","","","","","","","","","","","","");
        country.Code.set(countryCode.getText());
        country.Name.set(countryName.getText());
        country.Continent.set(countryContinent.getText());
        country.Region.set(countryRegion.getText());
        country.SurfaceArea.set(countrySurfaceArea.getText());
        country.IndepYear.set(countryIndepYear.getText());
        country.Population.set(countryPopulation.getText());
        country.LifeExpectancy.set(countryLifeExpectancy.getText());
        country.Gnp.set(countryGNP.getText());
        country.GnpOld.set(countryGNPOld.getText());
        country.LocalName.set(countryLocalName.getText());
        country.GovernmentForm.set(countryGovernmentForm.getText());
        country.HeadOfState.set(countryHeadOfState.getText());
        country.Capital.set(countryCapital.getText());
        country.Code2.set(countryCode2.getText());
        for (Country countri:countries) {
            if (countri.Code.getValue().equals(country.Code.getValue())) {
                countri.setCode(country.Code.getValue());
                countri.setName(country.Name.getValue());
                countri.setContinent(country.Continent.getValue());
                countri.setRegion(country.Region.getValue());
                countri.setSurfaceArea(country.SurfaceArea.getValue());
                countri.setIndepYear(country.IndepYear.getValue());
                countri.setPopulation(country.Population.getValue());
                countri.setLifeExpectancy(country.LifeExpectancy.getValue());
                countri.setGnp(country.Gnp.getValue());
                countri.setGnpOld(country.GnpOld.getValue());
                countri.setLocalName(country.LocalName.getValue());
                countri.setGovernmentForm(country.GovernmentForm.getValue());
                countri.setHeadOfState(country.HeadOfState.getValue());
                countri.setCapital(country.Capital.getValue());
                countri.setCode2(country.Code2.getValue());
            }
        }
        myCountryTable.setItems(countries);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE country SET Code = "+"'"+country.Code.getValue()+"', Name = '"+country.Name.getValue()+"',Continent = '"+country.Continent.getValue()+"', Region = '"+country.Region.getValue()+"', SurfaceArea = '"+country.SurfaceArea.getValue()+"', IndepYear = '"+country.IndepYear.getValue()+"',Population = '"+country.Population.getValue()+"', LifeExpectancy = '"+country.LifeExpectancy.getValue()+"' , GNP = '"+country.Gnp.getValue()+"' , GNPOld = '"+country.GnpOld.getValue()+"',LocalName = '"+country.LocalName.getValue()+"', GovernmentForm = '"+country.GovernmentForm.getValue()+"' , HeadOfState = '"+country.HeadOfState.getValue()+"' , Capital = '"+country.Capital.getValue()+"' , Code2 = '"+country.Code2.getValue()+"' WHERE Code = '"+country.Code.getValue()+"'");
            con.close();
            System.out.println("ok");
        }
        catch (Exception e){
            System.out.println(e);
        }
        myCountryTable.refresh();
        countryCode.setText("");
        countryName.setText("");
        countryContinent.setText("");
        countryRegion.setText("");
        countrySurfaceArea.setText("");
        countryIndepYear.setText("");
        countryPopulation.setText("");
        countryLifeExpectancy.setText("");
        countryGNP.setText("");
        countryGNPOld.setText("");
        countryLocalName.setText("");
        countryGovernmentForm.setText("");
        countryHeadOfState.setText("");
        countryCapital.setText("");
        countryCode2.setText("");
        update2.setDisable(false);
        ok2.setDisable(true);
        ok2.setOpacity(0);
        update2.setOpacity(1);
    }

    @FXML
    private void checkCity(ActionEvent event){

        if(cityCheck.isSelected())
        {
            cityIDc.setOpacity(1);
            cityIDc.setDisable(false);
            cityIDc1.setOpacity(1);
            cityIDc1.setDisable(false);
            cityNamec.setOpacity(1);
            cityNamec.setDisable(false);
            cityNamec1.setOpacity(1);
            cityNamec1.setDisable(false);
            cityCodec.setOpacity(1);
            cityCodec.setDisable(false);
            cityCodec1.setOpacity(1);
            cityCodec1.setDisable(false);
            cityDistc.setOpacity(1);
            cityDistc.setDisable(false);
            cityDistc1.setOpacity(1);
            cityDistc1.setDisable(false);
            cityPopuc.setOpacity(1);
            cityPopuc.setDisable(false);
            cityPopuc1.setOpacity(1);
            cityPopuc1.setDisable(false);
        } else{
            cityIDc.setOpacity(0);
            cityIDc.setDisable(true);
            cityIDc1.setOpacity(0);
            cityIDc1.setDisable(true);
            cityNamec.setOpacity(0);
            cityNamec.setDisable(true);
            cityNamec1.setOpacity(0);
            cityNamec1.setDisable(true);
            cityCodec.setOpacity(0);
            cityCodec.setDisable(true);
            cityCodec1.setOpacity(0);
            cityCodec1.setDisable(true);
            cityDistc.setOpacity(0);
            cityDistc.setDisable(true);
            cityDistc1.setOpacity(0);
            cityDistc1.setDisable(true);
            cityPopuc.setOpacity(0);
            cityPopuc.setDisable(true);
            cityPopuc1.setOpacity(0);
            cityPopuc1.setDisable(true);
        }




    }
    @FXML
    private void checkLanguage(ActionEvent event) {

        if (languageCheck.isSelected()) {
            languageCountryCode2.setOpacity(1);
            languageCountryCode2.setDisable(false);
            languageCountryCode1.setOpacity(1);
            languageCountryCode1.setDisable(false);
            languageLanguage2.setOpacity(1);
            languageLanguage2.setDisable(false);
            languageLanguage1.setOpacity(1);
            languageLanguage1.setDisable(false);
            languageIsOfficial2.setOpacity(1);
            languageIsOfficial2.setDisable(false);
            languageIsOfficial1.setOpacity(1);
            languageIsOfficial1.setDisable(false);
            languagePercentage2.setOpacity(1);
            languagePercentage2.setDisable(false);
            languagePercentage1.setOpacity(1);
            languagePercentage1.setDisable(false);

        } else {

            languageCountryCode2.setOpacity(0);
            languageCountryCode2.setDisable(true);
            languageCountryCode1.setOpacity(0);
            languageCountryCode1.setDisable(true);
            languageLanguage2.setOpacity(0);
            languageLanguage2.setDisable(true);
            languageLanguage1.setOpacity(0);
            languageLanguage1.setDisable(true);
            languageIsOfficial2.setOpacity(0);
            languageIsOfficial2.setDisable(true);
            languageIsOfficial1.setOpacity(0);
            languageIsOfficial1.setDisable(true);
            languagePercentage2.setOpacity(0);
            languagePercentage2.setDisable(true);
            languagePercentage1.setOpacity(0);
            languagePercentage1.setDisable(true);

        }
    }

    @FXML
    private void checkCountry(ActionEvent event) {

        if(countryCheck.isSelected())
        {
            countryCode1.setOpacity(1);
            countryCode1.setDisable(false);
            countryCodec.setOpacity(1);
            countryCodec.setDisable(false);
            countryName1.setOpacity(1);
            countryName1.setDisable(false);
            countryNamec.setOpacity(1);
            countryNamec.setDisable(false);
            countryContinent1.setOpacity(1);
            countryContinent1.setDisable(false);
            countryContinentc.setOpacity(1);
            countryContinentc.setDisable(false);
            countryRegion1.setOpacity(1);
            countryRegion1.setDisable(false);
            countryRegionc.setOpacity(1);
            countryRegionc.setDisable(false);
            countrySurfaceArea1.setOpacity(1);
            countrySurfaceArea1.setDisable(false);
            countrySurfaceAreac.setOpacity(1);
            countrySurfaceAreac.setDisable(false);
            countryIndepYear1.setOpacity(1);
            countryIndepYear1.setDisable(false);
            countryIndepYearc.setOpacity(1);
            countryIndepYearc.setDisable(false);
            countryPopulation1.setOpacity(1);
            countryPopulation1.setDisable(false);
            countryPopulationc.setOpacity(1);
            countryPopulationc.setDisable(false);
            countryLifeExpectancy1.setOpacity(1);
            countryLifeExpectancy1.setDisable(false);
            countryLifeExpectancyc.setOpacity(1);
            countryLifeExpectancyc.setDisable(false);
            countryGNP1.setOpacity(1);
            countryGNP1.setDisable(false);
            countryGNPc.setOpacity(1);
            countryGNPc.setDisable(false);
            countryGNPOld1.setOpacity(1);
            countryGNPOld1.setDisable(false);
            countryGNPOldc.setOpacity(1);
            countryGNPOldc.setDisable(false);
            countryLocalName1.setOpacity(1);
            countryLocalName1.setDisable(false);
            countryLocalNamec.setOpacity(1);
            countryLocalNamec.setDisable(false);
            countryGovernmentForm1.setOpacity(1);
            countryGovernmentForm1.setDisable(false);
            countryGovernmentFormc.setOpacity(1);
            countryGovernmentFormc.setDisable(false);
            countryHeadOfState1.setOpacity(1);
            countryHeadOfState1.setDisable(false);
            countryHeadOfStatec.setOpacity(1);
            countryHeadOfStatec.setDisable(false);
            countryCapital1.setOpacity(1);
            countryCapital1.setDisable(false);
            countryCapitalc.setOpacity(1);
            countryCapitalc.setDisable(false);
            countryCode21.setOpacity(1);
            countryCode21.setDisable(false);
            countryCode2c.setOpacity(1);
            countryCode2c.setDisable(false);
        }
        else{
            countryCode1.setOpacity(0);
            countryCode1.setDisable(true);
            countryCodec.setOpacity(0);
            countryCodec.setDisable(true);
            countryName1.setOpacity(0);
            countryName1.setDisable(true);
            countryNamec.setOpacity(0);
            countryNamec.setDisable(true);
            countryContinent1.setOpacity(0);
            countryContinent1.setDisable(true);
            countryContinentc.setOpacity(0);
            countryContinentc.setDisable(true);
            countryRegion1.setOpacity(0);
            countryRegion1.setDisable(true);
            countryRegionc.setOpacity(0);
            countryRegionc.setDisable(true);
            countrySurfaceArea1.setOpacity(0);
            countrySurfaceArea1.setDisable(true);
            countrySurfaceAreac.setOpacity(0);
            countrySurfaceAreac.setDisable(true);
            countryIndepYear1.setOpacity(0);
            countryIndepYear1.setDisable(true);
            countryIndepYearc.setOpacity(0);
            countryIndepYearc.setDisable(true);
            countryPopulation1.setOpacity(0);
            countryPopulation1.setDisable(true);
            countryPopulationc.setOpacity(0);
            countryPopulationc.setDisable(true);
            countryLifeExpectancy1.setOpacity(0);
            countryLifeExpectancy1.setDisable(true);
            countryLifeExpectancyc.setOpacity(0);
            countryLifeExpectancyc.setDisable(true);
            countryGNP1.setOpacity(0);
            countryGNP1.setDisable(true);
            countryGNPc.setOpacity(0);
            countryGNPc.setDisable(true);
            countryGNPOld1.setOpacity(0);
            countryGNPOld1.setDisable(true);
            countryGNPOldc.setOpacity(0);
            countryGNPOldc.setDisable(true);
            countryLocalName1.setOpacity(0);
            countryLocalName1.setDisable(true);
            countryLocalNamec.setOpacity(0);
            countryLocalNamec.setDisable(true);
            countryGovernmentForm1.setOpacity(0);
            countryGovernmentForm1.setDisable(true);
            countryGovernmentFormc.setOpacity(0);
            countryGovernmentFormc.setDisable(true);
            countryHeadOfState1.setOpacity(0);
            countryHeadOfState1.setDisable(true);
            countryHeadOfStatec.setOpacity(0);
            countryHeadOfStatec.setDisable(true);
            countryCapital1.setOpacity(0);
            countryCapital1.setDisable(true);
            countryCapitalc.setOpacity(0);
            countryCapitalc.setDisable(true);
            countryCode21.setOpacity(0);
            countryCode21.setDisable(true);
            countryCode2c.setOpacity(0);
            countryCode2c.setDisable(true);
        }

    }

    @FXML
    private void search(ActionEvent event) throws IOException {

        String Code;
        String Code1;
        String Name;
        String Name1;
        String ID;
        String ID1;
        String Population;
        String Population1;
        String District;
        String District1;
        String Codel;
        String Codel1;
        String Language;
        String Language1;
        String IsOfficial;
        String IsOfficial1;
        String Percentage;
        String Percentage1;
        String Codec;
        String Codec1;
        String Namec;
        String Namec1;
        String Continent;
        String Continent1;
        String Region;
        String Region1;
        String Surface;
        String Surface1;
        String IndepYear;
        String IndepYear1;
        String Popu;
        String Popu1;
        String Life;
        String Life1;
        String GNP;
        String GNP1;
        String GNPOld;
        String GNPOld1;
        String Local;
        String Local1;
        String Government;
        String Government1;
        String State;
        String State1;
        String Capital;
        String Capital1;
        String Code2;
        String Code21;
        String union;
        String table1;
        String table2;
        String table3;

        TableColumn cCode = new TableColumn("CountryCode");
        TableColumn cName = new TableColumn("CityName");
        TableColumn cID = new TableColumn("City ID");
        TableColumn cDistrict = new TableColumn("District");
        TableColumn cPopulation = new TableColumn("City Population");
        TableColumn cCodel = new TableColumn("CountryCode");
        TableColumn cLanguage = new TableColumn("Language");
        TableColumn cIsOffi = new TableColumn("IsOfficial");
        TableColumn cPercentage = new TableColumn("Percentage");
        TableColumn cCodeC = new TableColumn("Code");
        TableColumn cNameC = new TableColumn("Name");
        TableColumn cContinent = new TableColumn("Continent");
        TableColumn cRegion = new TableColumn("Region");
        TableColumn cSurface = new TableColumn("SurfaceArea");
        TableColumn cIndepYear = new TableColumn("IndepYear");
        TableColumn cPopulationC = new TableColumn("Population");
        TableColumn cLife = new TableColumn("LifeExpectancy");
        TableColumn cGNP = new TableColumn("GNP");
        TableColumn cGNPOld = new TableColumn("GNPOld");
        TableColumn cLocal = new TableColumn("LocalName");
        TableColumn cGovernment = new TableColumn("GovernmentForm");
        TableColumn cState = new TableColumn("HeadOfState");
        TableColumn cCapital = new TableColumn("Capital");
        TableColumn cCode2 = new TableColumn("Code2");

        myRegistrosTable.getColumns().clear();
        myRegistrosTable.refresh();
        ObservableList<World> data = FXCollections.observableArrayList();
        int h = 0;
        int g = 0;
        int j = 0;

        if(cityCheck.isSelected())
        {
            table1 = "city as c";
            j++;
        }
        else table1 ="";
        if(countryCheck.isSelected()){
            if(j > 0)
            {
                table2 = ",country as p";
                j++;
            }else{
                table2 ="country as p";
                j++;
            }
        }else{
            table2 ="";
        }
        if(languageCheck.isSelected()){
            if(j > 0)
            {
                table3 = ",countryLanguage as l";
                j++;
            }else{
                table3 ="countryLanguage as l";
                j++;
            }
        }else{
            table3 ="";
        }
        if(cityCheck.isSelected() || countryCheck.isSelected() || languageCheck.isSelected())
        {
            union = "";
            if(cityCheck.isSelected() && countryCheck.isSelected()) {union = "c.countrycode = p.code"; h++;}
            else if(cityCheck.isSelected() && languageCheck.isSelected()) {union = "c.countrycode = l.CountryCode"; h++;}
            else if(countryCheck.isSelected() && languageCheck.isSelected()) {union = "p.code = l.CountryCode"; h++;}
        } else union="";
        if(cityCodec.isSelected())
        {
           Code1 = "c.CountryCode";
           myRegistrosTable.getColumns().add(cCode);
           g++;
        }else
        {
            Code1 ="";
        }
        if(cityNamec.isSelected())
        {
            if (g > 0)
            {
                Name1 = ",c.name";
                myRegistrosTable.getColumns().add(cName);
                g++;
            }else{
                Name1 = "c.name";
                myRegistrosTable.getColumns().add(cName);
                g++;
            }
            
        }else
        {
            Name1 ="";
        }
        if(cityIDc.isSelected())
        {
            if (g > 0)
            {
                ID1 = ",c.ID";
                myRegistrosTable.getColumns().add(cID);
                g++;
            }else{
                ID1 = "c.ID";
                myRegistrosTable.getColumns().add(cID);
                g++;
            }

        }else
        {
            ID1 ="";
        }
        if(cityDistc.isSelected())
        {
            if (g > 0)
            {
                District1 = ",c.district";
                myRegistrosTable.getColumns().add(cDistrict);
                g++;
            }else{
                District1 = "c.district";
                myRegistrosTable.getColumns().add(cDistrict);
                g++;
            }

        }else
        {
            District1 ="";
        }
        if(cityPopuc.isSelected())
        {
            if (g > 0)
            {
                Population1 = ",c.population";
                myRegistrosTable.getColumns().add(cPopulation);
                g++;
            }else{
                Population1 = "c.population";
                myRegistrosTable.getColumns().add(cPopulation);
                g++;
            }
        }else
        {
            Population1 ="";
        }
        if(countryCodec.isSelected())
        {
            if(g > 0)
            {
                Codec1 = ",p.code";
                myRegistrosTable.getColumns().add(cCodeC);
                g++;
            }else {
                Codec1 = "p.code";
                myRegistrosTable.getColumns().add(cCodeC);
                g++;
            }
        }
        else
        {
            Codec1 ="";
        }
        if(countryNamec.isSelected())
        {
            if(g > 0)
            {
                Namec1 = ",p.name";
                myRegistrosTable.getColumns().add(cNameC);
                g++;
            }else {
                Namec1 = "p.name";
                myRegistrosTable.getColumns().add(cNameC);
                g++;
            }
        }
        else
        {
            Namec1 ="";
        }
        if(countryContinentc.isSelected())
        {
            if(g > 0)
            {
                Continent1 = ",p.continent";
                myRegistrosTable.getColumns().add(cContinent);
                g++;
            }else {
                Continent1 = "p.continent";
                myRegistrosTable.getColumns().add(cContinent);
                g++;
            }
        }
        else
        {
            Continent1 ="";
        }
        if(countryRegionc.isSelected())
        {
            if(g > 0)
            {
                Region1 = ",p.region";
                myRegistrosTable.getColumns().add(cRegion);
                g++;
            }else {
                Region1 = "p.region";
                myRegistrosTable.getColumns().add(cRegion);
                g++;
            }
        }
        else
        {
            Region1 ="";
        }
        if(countrySurfaceAreac.isSelected())
        {
            if(g > 0)
            {
                Surface1 = ",p.SurfaceArea";
                myRegistrosTable.getColumns().add(cSurface);
                g++;
            }else {
                Surface1= "p.SurfaceArea";
                myRegistrosTable.getColumns().add(cSurface);
                g++;
            }
        }
        else
        {
            Surface1 ="";
        }
        if(countryIndepYearc.isSelected())
        {
            if(g > 0)
            {
                IndepYear1 = ",p.IndepYear";
                myRegistrosTable.getColumns().add(cIndepYear);
                g++;
            }else {
                IndepYear1 = "p.IndepYear";
                myRegistrosTable.getColumns().add(cIndepYear);
                g++;
            }
        }
        else
        {
            IndepYear1 ="";
        }
        if(countryPopulationc.isSelected())
        {
            if(g > 0)
            {
                Popu1 = ",p.population";
                myRegistrosTable.getColumns().add(cPopulationC);
                g++;
            }else {
                Popu1 = "p.population";
                myRegistrosTable.getColumns().add(cPopulationC);
                g++;
            }
        }
        else
        {
            Popu1 ="";
        }
        if(countryLifeExpectancyc.isSelected())
        {
            if(g > 0)
            {
                Life1 = ",p.LifeExpectancy";
                myRegistrosTable.getColumns().add(cLife);
                g++;
            }else {
                Life1 = "p.LifeExpectancy";
                myRegistrosTable.getColumns().add(cLife);
                g++;
            }
        }
        else
        {
            Life1 ="";
        }
        if(countryGNPc.isSelected())
        {
            if(g > 0)
            {
                GNP1 = ",p.GNP";
                myRegistrosTable.getColumns().add(cGNP);
                g++;
            }else {
                GNP1 = "p.GNP";
                myRegistrosTable.getColumns().add(cGNP);
                g++;
            }
        }
        else
        {
            GNP1 ="";
        }
        if(countryGNPOldc.isSelected())
        {
            if(g > 0)
            {
                GNPOld1 = ",p.GNPOld";
                myRegistrosTable.getColumns().add(cGNPOld);
                g++;
            }else {
                GNPOld1 = "p.GNPOld";
                myRegistrosTable.getColumns().add(cGNPOld);
                g++;
            }
        }
        else
        {
            GNPOld1 ="";
        }
        if(countryLocalNamec.isSelected())
        {
            if(g > 0)
            {
                Local1 = ",p.LocalName";
                myRegistrosTable.getColumns().add(cLocal);
                g++;
            }else {
                Local1 = "p.LocalName";
                myRegistrosTable.getColumns().add(cLocal);
                g++;
            }
        }
        else
        {
            Local1 ="";
        }
        if(countryGovernmentFormc.isSelected())
        {
            if(g > 0)
            {
                Government1 = ",p.government";
                myRegistrosTable.getColumns().add(cGovernment);
                g++;
            }else {
                Government1 = "p.government";
                myRegistrosTable.getColumns().add(cGovernment);
                g++;
            }
        }
        else
        {
            Government1 ="";
        }
        if(countryHeadOfStatec.isSelected())
        {
            if(g > 0)
            {
                State1 = ",p.HeadOfState";
                myRegistrosTable.getColumns().add(cState);
                g++;
            }else {
                State1 = "p.HeadOfState";
                myRegistrosTable.getColumns().add(cState);
                g++;
            }
        }
        else
        {
            State1 ="";
        }
        if(countryCapitalc.isSelected())
        {
            if(g > 0)
            {
                Capital1 = ",p.capital";
                myRegistrosTable.getColumns().add(cCapital);
                g++;
            }else {
                Capital1 = "p.capital";
                myRegistrosTable.getColumns().add(cCapital);
                g++;
            }
        }
        else
        {
            Capital1 ="";
        }
        if(countryCode2c.isSelected())
        {
            if(g > 0)
            {
                Code21 = ",p.code2";
                myRegistrosTable.getColumns().add(cCode2);
                g++;
            }else {
                Code21 = "p.code2";
                myRegistrosTable.getColumns().add(cCode2);
                g++;
            }
        }
        else
        {
            Code21 ="";
        }
        if(languageCountryCode2.isSelected())
        {
            if(g > 0)
            {
                Codel1 = ",l.CountryCode";
                myRegistrosTable.getColumns().add(cCodel);
                g++;
            }else {
                Codel1 = "l.CountryCode";
                myRegistrosTable.getColumns().add(cCodel);
                g++;
            }
        }
        else
        {
            Codel1 ="";
        }
        if(languageLanguage2.isSelected())
        {
            if(g > 0)
            {
                Language1 = ",l.language";
                myRegistrosTable.getColumns().add(cLanguage);
                g++;
            }else {
                Language1 = "l.language";
                myRegistrosTable.getColumns().add(cLanguage);
                g++;
            }
        }
        else
        {
            Language1 ="";
        }
        if(languageIsOfficial2.isSelected())
        {
            if(g > 0)
            {
                IsOfficial1 = ",l.IsOfficial";
                myRegistrosTable.getColumns().add(cIsOffi);
                g++;
            }else {
                IsOfficial1 = "l.IsOfficial";
                myRegistrosTable.getColumns().add(cIsOffi);
                g++;
            }
        }
        else
        {
            IsOfficial1 ="";
        }
        if(languagePercentage2.isSelected())
        {
            if(g > 0)
            {
                Percentage1 = ",l.Percentage";
                myRegistrosTable.getColumns().add(cPercentage);
                g++;
            }else {
                Percentage1 = "l.Percentage";
                myRegistrosTable.getColumns().add(cPercentage);
                g++;
            }
        }
        else
        {
            Percentage1 ="";
        }
        if(cityCodec1.getText().equals(""))
        {
            Code = "";
        }else if (h > 0)
        {
            Code = "and c.CountryCode like '"+ cityCodec1.getText()+"'";
            h++;
        }else
        {
            Code = "c.CountryCode like '"+ cityCodec1.getText()+"'";
            h++;
        }
        if(cityNamec1.getText().equals("")) {
            Name = "";
        }else if (h > 0)
        {
            Name = "and c.Name like '"+ cityNamec1.getText()+"'";
            h++;

        }else{
            Name = "c.Name like '"+ cityNamec1.getText()+"'";
            h++;
        }
        if(cityIDc1.getText().equals("")) {
            ID = "";
        }else if (h > 0)
        {
            ID = "and c.ID like '"+ cityIDc1.getText()+"'";
            h++;

        }else{
            ID = "c.ID like '"+ cityIDc1.getText()+"'";
            h++;
        }
        if(cityDistc1.getText().equals("")) {
            District = "";
        }else if (h > 0)
        {
            District = "and c.District like '"+ cityDistc1.getText()+"'";
            h++;

        }else{
            District = "c.District like '"+ cityDistc1.getText()+"'";
            h++;
        }
        if(cityPopuc1.getText().equals("")) {
            Population = "";
        }else if (h > 0)
        {
            Population = "and c.Population like '"+ cityPopuc1.getText()+"'";
            h++;

        }else{
            Population = "c.Population like '"+ cityPopuc1.getText()+"'";
            h++;
        }
        if(countryCode1.getText().equals("")) {
            Codec = "";
        }else if (h > 0)
        {
            Codec = "and p.code like '"+ countryCode1.getText()+"'";
            h++;

        }else{
            Codec = "p.code like '"+ countryCode1.getText()+"'";
            h++;
        }
        if(countryName1.getText().equals("")) {
            Namec = "";
        }else if (h > 0)
        {
            Namec = "and p.name like '"+ countryName1.getText()+"'";
            h++;

        }else{
            Namec = "p.name like '"+ countryName1.getText()+"'";
            h++;
        }
        if(countryContinent1.getText().equals("")) {
            Continent = "";
        }else if (h > 0)
        {
            Continent = "and p.continent like '"+ countryContinent1.getText()+"'";
            h++;

        }else{
            Continent = "p.continent like '"+ countryContinent1.getText()+"'";
            h++;
        }
        if(countryRegion1.getText().equals("")) {
            Region = "";
        }else if (h > 0)
        {
            Region = "and p.region like '"+ countryRegion1.getText()+"'";
            h++;

        }else{
            Region = "p.region like '"+ countryRegion1.getText()+"'";
            h++;
        }
        if(countrySurfaceArea1.getText().equals("")) {
            Surface = "";
        }else if (h > 0)
        {
            Surface = "and p.SurfaceArea like '"+ countrySurfaceArea1.getText()+"'";
            h++;

        }else{
            Surface = "p.SurfaceArea like '"+ countrySurfaceArea1.getText()+"'";
            h++;
        }
        if(countryIndepYear1.getText().equals("")) {
            IndepYear = "";
        }else if (h > 0)
        {
            IndepYear = "and p.IndepYear like '"+ countryIndepYear1.getText()+"'";
            h++;

        }else{
            IndepYear = "p.IndepYear like '"+ countryIndepYear1.getText()+"'";
            h++;
        }
        if(countryPopulation1.getText().equals("")) {
            Popu = "";
        }else if (h > 0)
        {
            Popu = "and p.population like '"+ countryPopulation1.getText()+"'";
            h++;

        }else{
            Popu = "p.population like '"+ countryPopulation1.getText()+"'";
            h++;
        }
        if(countryLifeExpectancy1.getText().equals("")) {
            Life = "";
        }else if (h > 0)
        {
            Life = "and p.LifeExpectancy like '"+ countryLifeExpectancy1.getText()+"'";
            h++;

        }else{
            Life = "p.LifeExpectancy like '"+ countryLifeExpectancy1.getText()+"'";
            h++;
        }
        if(countryGNP1.getText().equals("")) {
            GNP = "";
        }else if (h > 0)
        {
            GNP = "and p.GNP like '"+ countryGNP1.getText()+"'";
            h++;

        }else{
            GNP = "p.GNP like '"+ countryGNP1.getText()+"'";
            h++;
        }
        if(countryGNPOld1.getText().equals("")) {
            GNPOld = "";
        }else if (h > 0)
        {
            GNPOld = "and p.GNPOld like '"+ countryGNPOld1.getText()+"'";
            h++;

        }else{
            GNPOld = "p.GNPOld like '"+ countryGNPOld1.getText()+"'";
            h++;
        }
        if(countryLocalName1.getText().equals("")) {
            Local = "";
        }else if (h > 0)
        {
            Local = "and p.LocalName like '"+ countryLocalName1.getText()+"'";
            h++;

        }else{
            Local = "p.LocalName like '"+ countryLocalName1.getText()+"'";
            h++;
        }
        if(countryGovernmentForm1.getText().equals("")) {
            Government = "";
        }else if (h > 0)
        {
            Government = "and p.government like '"+ countryGovernmentForm1.getText()+"'";
            h++;

        }else{
            Government = "p.government like '"+ countryGovernmentForm1.getText()+"'";
            h++;
        }
        if(countryHeadOfState1.getText().equals("")) {
            State = "";
        }else if (h > 0)
        {
            State = "and p.HeadOfState like '"+ countryHeadOfState1.getText()+"'";
            h++;

        }else{
            State = "p.HeadOfState like '"+ countryHeadOfState1.getText()+"'";
            h++;
        }
        if(countryCapital1.getText().equals("")) {
            Capital = "";
        }else if (h > 0)
        {
            Capital = "and p.capital like '"+ countryCapital1.getText()+"'";
            h++;

        }else{
            Capital = "p.capital like '"+ countryCapital1.getText()+"'";
            h++;
        }
        if(countryCode21.getText().equals("")) {
            Code2 = "";
        }else if (h > 0)
        {
            Code2 = "and p.code2 like '"+ countryCode21.getText()+"'";
            h++;

        }else{
            Code2 = "p.code2 like '"+ countryCode21.getText()+"'";
            h++;
        }
        if(languageCountryCode1.getText().equals("")) {
            Codel = "";
        }else if (h > 0)
        {
            Codel = "and l.CountryCode like '"+ languageCountryCode1.getText()+"'";
            h++;

        }else{
            Codel = "l.CountryCode like '"+ languageCountryCode1.getText()+"'";
            h++;
        }
        if(languageLanguage1.getText().equals("")) {
            Language = "";
        }else if (h > 0)
        {
            Language = "and l.language like '"+ languageLanguage1.getText()+"'";
            h++;

        }else{
            Language = "l.language like '"+ languageLanguage1.getText()+"'";
            h++;
        }
        if(languageIsOfficial1.getText().equals("")) {
            IsOfficial = "";
        }else if (h > 0)
        {
            IsOfficial = "and l.IsOfficial like '"+ languageIsOfficial1.getText()+"'";
            h++;

        }else{
            IsOfficial = "l.IsOfficial like '"+ languageIsOfficial1.getText()+"'";
            h++;
        }
        if(languagePercentage1.getText().equals("")) {
            Percentage = "";
        }else if (h > 0)
        {
            Percentage = "and l.percentage like '"+ languagePercentage1.getText()+"'";
            h++;

        }else{
            Percentage = "l.percentage like '"+ languagePercentage1.getText()+"'";
            h++;
        }
        try {
            System.out.println("SELECT "+Code1+Name1+ID1+District1+Population1+Codec1+Namec1+Continent1+Region1+Surface1+IndepYear1+Population+Life1+GNP1+GNPOld1+Local1+Government1+State1+Capital1+Code21+Codel1+Language1+IsOfficial1+Percentage1+" FROM "+table1+table2+table3+" WHERE "+union+" "+Code+" "+Name+" "+ID+" "+District+" "+Population+" "+Codec+" "+Namec+" "+Continent+" "+Region+" "+Surface+" "+IndepYear+" "+Popu+" "+Life+" "+GNP+" "+GNPOld+" "+Local+" "+Government+" "+State+" "+Capital+" "+Code2+" "+Codel+" "+Language+" "+IsOfficial+" "+Percentage);
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            if(h > 0){
                ResultSet rs = stmt.executeQuery("SELECT "+Code1+Name1+ID1+District1+Population1+Codec1+Namec1+Continent1+Region1+Surface1+IndepYear1+Population+Life1+GNP1+GNPOld1+Local1+Government1+State1+Capital1+Code21+Codel1+Language1+IsOfficial1+Percentage1+" FROM "+table1+table2+table3+" WHERE "+union+" "+Code+" "+Name+" "+ID+" "+District+" "+Population+" "+Codec+" "+Namec+" "+Continent+" "+Region+" "+Surface+" "+IndepYear+" "+Popu+" "+Life+" "+GNP+" "+GNPOld+" "+Local+" "+Government+" "+State+" "+Capital+" "+Code2+" "+Codel+" "+Language+" "+IsOfficial+" "+Percentage);
                while (rs.next()) {
                    String  code;
                    String name;
                    String district;
                    String id;
                    String population;
                    String codeC;
                    String nameC;
                    String continent;
                    String region;
                    String surface;
                    String indepYear;
                    String popu;
                    String life;
                    String gnp;
                    String gnpold;
                    String local;
                    String government;
                    String state;
                    String capital;
                    String code2;
                    String codeL;
                    String language;
                    String isOfficial;
                    String percentage;

                    if(cityCodec.isSelected()){
                        code = rs.getString("CountryCode");
                        cCode.setCellValueFactory(new PropertyValueFactory<>("CountryCode"));
                    }
                    else code = "";
                    if(cityNamec.isSelected()){
                        name = rs.getString("Name");
                        cName.setCellValueFactory(new PropertyValueFactory<>("CityName"));
                    }
                    else name = "";
                    if(cityDistc.isSelected()){
                        district = rs.getString("District");
                        cDistrict.setCellValueFactory(new PropertyValueFactory<>("District"));
                    }
                    else district = "";
                    if(cityIDc.isSelected()) {
                        id = rs.getString("ID");
                        cID.setCellValueFactory(new PropertyValueFactory<>("Id"));
                    }
                    else id = "";
                    if(cityPopuc.isSelected()){
                        population = rs.getString("Population");
                        cPopulation.setCellValueFactory(new PropertyValueFactory<>("CityPopulation"));
                    }
                    else population = "";
                    if(countryCodec.isSelected()){
                        codeC = rs.getString("Code");
                        cCodeC.setCellValueFactory(new PropertyValueFactory<>("Code"));
                    }
                    else codeC = "";
                    if(countryNamec.isSelected()){
                        nameC = rs.getString("Name");
                        cNameC.setCellValueFactory(new PropertyValueFactory<>("Name"));
                    }
                    else nameC = "";
                    if(countryContinentc.isSelected()){
                        continent = rs.getString("Continent");
                        cContinent.setCellValueFactory(new PropertyValueFactory<>("Continent"));
                    }
                    else continent = "";
                    if(countryRegionc.isSelected()){
                        region = rs.getString("Region");
                        cRegion.setCellValueFactory(new PropertyValueFactory<>("Region"));
                    }
                    else region = "";
                    if(countrySurfaceAreac.isSelected()){
                        surface = rs.getString("SurfaceArea");
                        cSurface.setCellValueFactory(new PropertyValueFactory<>("SurfaceArea"));
                    }
                    else surface = "";
                    if(countryIndepYearc.isSelected()){
                        indepYear = rs.getString("IndepYear");
                        cIndepYear.setCellValueFactory(new PropertyValueFactory<>("IndepYear"));
                    }
                    else indepYear = "";
                    if(countryPopulationc.isSelected()){
                        popu = rs.getString("Population");
                        cPopulationC.setCellValueFactory(new PropertyValueFactory<>("Population"));
                    }
                    else popu = "";
                    if(countryLifeExpectancyc.isSelected()){
                        life = rs.getString("LifeExpectancy");
                        cLife.setCellValueFactory(new PropertyValueFactory<>("LifeExpectancy"));
                    }
                    else life = "";
                    if(countryGNPc.isSelected()){
                        gnp = rs.getString("GNP");
                        cGNP.setCellValueFactory(new PropertyValueFactory<>("GNP"));
                    }
                    else gnp = "";
                    if(countryGNPOldc.isSelected()){
                        gnpold = rs.getString("GNPOld");
                        cGNPOld.setCellValueFactory(new PropertyValueFactory<>("GNPOld"));
                    }
                    else gnpold = "";
                    if(countryLocalNamec.isSelected()){
                        local = rs.getString("LocalName");
                        cLocal.setCellValueFactory(new PropertyValueFactory<>("LocalName"));
                    }
                    else local = "";
                    if(countryGovernmentFormc.isSelected()){
                        government = rs.getString("GovernmentForm");
                        cGovernment.setCellValueFactory(new PropertyValueFactory<>("GovernmentForm"));
                    }
                    else government = "";
                    if(countryHeadOfStatec.isSelected()){
                        state = rs.getString("HeadOfState");
                        cState.setCellValueFactory(new PropertyValueFactory<>("HeadOfState"));
                    }
                    else state = "";
                    if(countryCapitalc.isSelected()){
                        capital = rs.getString("Capital");
                        cCapital.setCellValueFactory(new PropertyValueFactory<>("Capital"));
                    }
                    else capital = "";
                    if(countryCode2c.isSelected()){
                        code2 = rs.getString("Code2");
                        cCode2.setCellValueFactory(new PropertyValueFactory<>("Code2"));
                    }
                    else code2 = "";
                    if(languageCountryCode2.isSelected()){
                        codeL = rs.getString("CountryCode");
                        cCodel.setCellValueFactory(new PropertyValueFactory<>("CountryCodeL"));
                    }
                    else codeL = "";
                    if(languageLanguage2.isSelected()){
                        language = rs.getString("Language");
                        cLanguage.setCellValueFactory(new PropertyValueFactory<>("Language"));
                    }
                    else language = "";
                    if(languageIsOfficial2.isSelected()){
                        isOfficial = rs.getString("IsOfficial");
                        cIsOffi.setCellValueFactory(new PropertyValueFactory<>("IsOfficial"));
                    }
                    else isOfficial = "";
                    if(languagePercentage2.isSelected()){
                        percentage = rs.getString("Percentage");
                        cPercentage.setCellValueFactory(new PropertyValueFactory<>("Percentage"));
                    }
                    else percentage = "";
                    data.add(new World(id,name,code,district,population,codeC,nameC,continent,region,surface,indepYear,popu,life,gnp,gnpold,local,government,state,capital,code2,codeL,language,isOfficial,percentage));
                }
            }
            con.close();

            System.out.println("ok");

        }
        catch (Exception e){
            System.out.println(e);
        }
        cityCodec.setSelected(false);
        cityCodec1.setText("");
        cityNamec.setSelected(false);
        cityNamec1.setText("");
        cityIDc.setSelected(false);
        cityIDc1.setText("");
        cityDistc.setSelected(false);
        cityDistc1.setText("");
        cityPopuc.setSelected(false);
        cityPopuc1.setText("");
        countryCodec.setSelected(false);
        countryCode1.setText("");
        countryNamec.setSelected(false);
        countryName1.setText("");
        countryContinentc.setSelected(false);
        countryContinent1.setText("");
        countryRegionc.setSelected(false);
        countryRegion1.setText("");
        countrySurfaceAreac.setSelected(false);
        countrySurfaceArea1.setText("");
        countryIndepYearc.setSelected(false);
        countryIndepYear1.setText("");
        countryPopulationc.setSelected(false);
        countryPopulation1.setText("");
        countryLifeExpectancyc.setSelected(false);
        countryLifeExpectancy1.setText("");
        countryGNPc.setSelected(false);
        countryGNP1.setText("");
        countryGNPOldc.setSelected(false);
        countryGNPOld1.setText("");
        countryLocalNamec.setSelected(false);
        countryLocalName1.setText("");
        countryGovernmentFormc.setSelected(false);
        countryGovernmentForm1.setText("");
        countryHeadOfStatec.setSelected(false);
        countryHeadOfState1.setText("");
        countryCapitalc.setSelected(false);
        countryCapital1.setText("");
        countryCode2c.setSelected(false);
        countryCode21.setText("");
        languageCountryCode2.setSelected(false);
        languageCountryCode1.setText("");
        languageLanguage2.setSelected(false);
        languageLanguage1.setText("");
        languageIsOfficial2.setSelected(false);
        languageIsOfficial1.setText("");
        languagePercentage2.setSelected(false);
        languagePercentage1.setText("");
        myRegistrosTable.setItems(data);
    }
}

