package entities;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Home implements Initializable {


    @FXML
    public Button update;
    @FXML
    public Button ok;
    //City

    //Table
    @FXML
    private TableView<City> myCityTable;
    //Columns
    @FXML
    public TableColumn<City, String> myCityID;
    @FXML
    public TableColumn<City, String> myCityName;
    @FXML
    public TableColumn<City, String> myCityCode;
    @FXML
    public TableColumn<City, String> myCityDis;
    @FXML
    public TableColumn<City, String> myCityPopu;
    //TextFields
    @FXML
    public TextField cityCode;
    @FXML
    public TextField cityDistrict;
    @FXML
    public TextField cityId;
    @FXML
    public TextField cityName;
    @FXML
    public TextField cityPopulation;
    @FXML
    public TextField cityIDc1;
    @FXML
    public TextField cityNamec1;
    @FXML
    public TextField cityCodec1;
    @FXML
    public TextField cityDistc1;
    @FXML
    public TextField cityPopuc1;

    //labels
    @FXML
    public Label cityIDc;
    @FXML
    public Label cityCodec;
    @FXML
    public Label cityNamec;
    @FXML
    public Label cityDistc;
    @FXML
    public Label cityPopuc;

    //checkbox
    @FXML
    public CheckBox cityCheck;
    //Country

    //Table
    @FXML
    private TableView<Country> myCountryTable;
    //Columns
    @FXML
    public TableColumn<Country, String> myCountryCode;
    @FXML
    public TableColumn<Country, String> myCountryName;
    @FXML
    public TableColumn<Country, String> myCountryContinent;
    @FXML
    public TableColumn<Country, String> myCountryRegion;
    @FXML
    public TableColumn<Country, String> myCountryArea;
    @FXML
    public TableColumn<Country, String> myCountryIndep;
    @FXML
    public TableColumn<Country, String> myCountryPopu;
    @FXML
    public TableColumn<Country, String> myCountryLife;
    @FXML
    public TableColumn<Country, String> myCountryGNP;
    @FXML
    public TableColumn<Country, String> myCountryGNPOld;
    @FXML
    public TableColumn<Country, String> myCountryLocal;
    @FXML
    public TableColumn<Country, String> myCountryGoverment;
    @FXML
    public TableColumn<Country, String> myCountryState;
    @FXML
    public TableColumn<Country, String> myCountryCapital;
    @FXML
    public TableColumn<Country, String> myCountryCode2;
    //TextFields
    @FXML
    public TextField countryCode;
    @FXML
    public TextField countryName;
    @FXML
    public TextField countryContinent;
    @FXML
    public TextField countryRegion;
    @FXML
    public TextField countrySurfaceArea;
    @FXML
    public TextField countryIndepYear;
    @FXML
    public TextField countryPopulation;
    @FXML
    public TextField countryLifeExpectancy;
    @FXML
    public TextField countryGNP;
    @FXML
    public TextField countryGNPOld;
    @FXML
    public TextField countryLocalName;
    @FXML
    public TextField countryGovernmentForm;
    @FXML
    public TextField countryHeadOfState;
    @FXML
    public TextField countryCapital;
    @FXML
    public TextField countryCode2;

    @FXML
    public Button update2;
    @FXML
    public Button ok2;


    //Language
    //Table
    @FXML
    private TableView<Language> myLanguageTable;

    //Columns
    @FXML
    public TableColumn<Language, String> myLanguageCode;
    @FXML
    public TableColumn<Language, String> myLanguageLanguage;
    @FXML
    public TableColumn<Language, String> myLanguageOfficial;
    @FXML
    public TableColumn<Language, String> myLanguagePercentage;
    //TextFields
    @FXML
    public TextField languageCountryCode;
    @FXML
    public TextField languageLanguage;
    @FXML
    public TextField languageIsOfficial;
    @FXML
    public TextField languagePercentage;
    @FXML
    public TextField languageCountryCode1;
    @FXML
    public TextField languageLanguage1;
    @FXML
    public TextField languageIsOfficial1;
    @FXML
    public TextField languagePercentage1;

    @FXML
    public Button update1;
    @FXML
    public Button ok1;

    //labels

    @FXML
    public Label languagePercentage2;
    @FXML
    public Label languageCountryCode2;
    @FXML
    public Label languageLanguage2;
    @FXML
    public Label languageIsOfficial2;

    @FXML
    public CheckBox languageCheck;

    private final ObservableList<City> cities = FXCollections.observableArrayList();
    private final ObservableList<Country> countries = FXCollections.observableArrayList();
    private final ObservableList<Language> languages = FXCollections.observableArrayList();


    public void GenerateCity() {

        try {
            int ID = 1;
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM city ");
            while (rs.next()) {
                String Name = rs.getString("Name");
                String CountryCode = rs.getString("CountryCode");
                String District = rs.getString("District");
                String Population = rs.getString("Population");
                City city = new City(ID + "", Name, CountryCode, District, Population);
                cities.add(city);
                ID++;
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
                String CountryCode = rs.getString("CountryCode");
                String Language = rs.getString("Language");
                String IsOfficial = rs.getString("IsOfficial");
                String Percentage = rs.getString("Percentage");
                Language language = new Language(CountryCode, Language, IsOfficial, Percentage);
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
                String Code = rs.getString("Code");
                String Name = rs.getString("Name");
                String Continent = rs.getString("Continent");
                String Region = rs.getString("Region");
                String SurfaceArea = rs.getString("SurfaceArea");
                String IndepYear = rs.getString("IndepYear");
                String Population = rs.getString("Population");
                String LifeExpectancy = rs.getString("LifeExpectancy");
                String GNP = rs.getString("GNP");
                String GNPOld = rs.getString("GNPOld");
                String LocalName = rs.getString("LocalName");
                String GovernmentForm = rs.getString("GovernmentForm");
                String HeadOfState = rs.getString("HeadOfState");
                String Capital = rs.getString("Capital");
                String Code2 = rs.getString("Code2");
                Country country = new Country(Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2);
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

        myLanguageCode.setCellValueFactory(new PropertyValueFactory<>("CountryCode"));
        myLanguageLanguage.setCellValueFactory(new PropertyValueFactory<>("Language"));
        myLanguageOfficial.setCellValueFactory(new PropertyValueFactory<>("IsOfficial"));
        myLanguagePercentage.setCellValueFactory(new PropertyValueFactory<>("Percentage"));
        myLanguageTable.setItems(languages);


    }

    @FXML
    private void añadirCity(ActionEvent event) {
        City city = new City("", "", "", "", "");
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
            stmt.execute("INSERT INTO city VALUES ('" + cityId.getText() + "','" + cityName.getText() + "','" + cityCode.getText() + "','" + cityDistrict.getText() + "','" + cityPopulation.getText() + "')");
            con.close();
            System.out.println("ok");
        } catch (Exception e) {
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
    private void deleteCity(ActionEvent event) {
        final City c = myCityTable.getSelectionModel().getSelectedItems().get(0);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            stmt.execute("DELETE FROM city WHERE ID = " + "'" + c.Id.getValue() + "'");
            con.close();
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println(e);
        }
        cities.remove(c);
        myCityTable.setItems(cities);
        myCityTable.refresh();

    }

    @FXML
    private void updateCity(ActionEvent event) {
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
    private void updateCity1(ActionEvent event) {

        City city = new City("", "", "", "", "");
        city.CountryCode.set(cityCode.getText());
        city.District.set(cityDistrict.getText());
        city.Id.set(cityId.getText());
        city.Name.set(cityName.getText());
        city.Population.set(cityPopulation.getText());
        for (City citi : cities) {
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
            stmt.execute("UPDATE city SET ID = " + "'" + city.Id.getValue() + "', Name = '" + city.Name.getValue() + "',CountryCode = '" + city.CountryCode.getValue() + "', District = '" + city.District.getValue() + "', Population = '" + city.Population.getValue() + "' WHERE ID = '" + city.Id.getValue() + "'");
            con.close();
            System.out.println("ok");
        } catch (Exception e) {
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
    private void añadirLanguage(ActionEvent event) {
        Language language = new Language("", "", "", "");
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
            stmt.execute("INSERT INTO countryLanguage VALUES ('" + languageCountryCode.getText() + "','" + languageLanguage.getText() + "','" + languageIsOfficial.getText() + "','" + languagePercentage.getText() + "')");
            con.close();
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println(e);
        }
        myLanguageTable.refresh();
        languageCountryCode.setText("");
        languageLanguage.setText("");
        languageIsOfficial.setText("");
        languagePercentage.setText("");
    }

    @FXML
    private void deleteLanguage(ActionEvent event) {
        final Language l = myLanguageTable.getSelectionModel().getSelectedItems().get(0);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            stmt.execute("DELETE FROM countryLanguage WHERE CountryCode = " + "'" + l.CountryCode.getValue() + "'");
            con.close();
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println(e);
        }
        languages.remove(l);
        myLanguageTable.setItems(languages);
        myLanguageTable.refresh();

    }

    @FXML
    private void updateLanguage(ActionEvent event) {
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
    private void updateLanguage1(ActionEvent event) {

        Language language = new Language("", "", "", "");
        language.CountryCode.set(languageCountryCode.getText());
        language.Language.set(languageLanguage.getText());
        language.IsOfficial.set(languageIsOfficial.getText());
        language.Percentage.set(languagePercentage.getText());
        for (Language languagee : languages) {
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
            stmt.execute("UPDATE CountryLanguage SET CountryCode = " + "'" + language.CountryCode.getValue() + "',CountryCode = '" + language.CountryCode.getValue() + "', Language = '" + language.Language.getValue() + "', IsOfficial = '" + language.IsOfficial.getValue() + ", Percentage = '" + language.Percentage.getValue() + "' WHERE CountryCode = '" + language.CountryCode.getValue() + "'");
            con.close();
            System.out.println("ok");
        } catch (Exception e) {
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
    private void añadirCountry(ActionEvent event) {
        Country country = new Country("", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
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
            stmt.execute("INSERT INTO country VALUES ('" + country.Code.getValue() + "','" + country.Name.getValue() + "','" + country.Continent.getValue() + "','" + country.Region.getValue() + "','" + country.SurfaceArea.getValue() + "','" + country.IndepYear.getValue() + "','" + country.Population.getValue() + "','" + country.LifeExpectancy.getValue() + "','" + country.Gnp.getValue() + "','" + country.GnpOld.getValue() + "','" + country.LocalName.getValue() + "','" + country.GovernmentForm.getValue() + "','" + country.HeadOfState.getValue() + "','" + country.Capital.getValue() + "','" + country.Code2.getValue() + "')");
            con.close();
            System.out.println("ok");
        } catch (Exception e) {
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
    private void deleteCountry(ActionEvent event) {
        final Country co = myCountryTable.getSelectionModel().getSelectedItems().get(0);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            stmt.execute("DELETE FROM county WHERE Code = " + "'" + co.Code.getValue() + "'");
            con.close();
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println(e);
        }
        countries.remove(co);
        myCountryTable.setItems(countries);
        myCountryTable.refresh();

    }

    @FXML
    private void updateCountry(ActionEvent event) {
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
    private void updateCountry1(ActionEvent event) {

        Country country = new Country("", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
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
        for (Country countri : countries) {
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
            stmt.execute("UPDATE country SET Code = " + "'" + country.Code.getValue() + "', Name = '" + country.Name.getValue() + "',Continent = '" + country.Continent.getValue() + "', Region = '" + country.Region.getValue() + "', SurfaceArea = '" + country.SurfaceArea.getValue() + "', IndepYear = '" + country.IndepYear.getValue() + "',Population = '" + country.Population.getValue() + "', LifeExpectancy = '" + country.LifeExpectancy.getValue() + "' , GNP = '" + country.Gnp.getValue() + "' , GNPOld = '" + country.GnpOld.getValue() + "',LocalName = '" + country.LocalName.getValue() + "', GovernmentForm = '" + country.GovernmentForm.getValue() + "' , HeadOfState = '" + country.HeadOfState.getValue() + "' , Capital = '" + country.Capital.getValue() + "' , Code2 = '" + country.Code2.getValue() + "' WHERE Code = '" + country.Code.getValue() + "'");
            con.close();
            System.out.println("ok");
        } catch (Exception e) {
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
    private void checkCity(ActionEvent event) {

        if (cityCheck.isSelected()) {
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
        } else {
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
    private void search(ActionEvent event) {

        String Code;
        String Name;
        String ID;
        String Population;
        String District;
        String CountryCode;
        int h = 0;

        if (cityCodec1.getText() == null) {
            Code = null;
        } else {
            Code = "CountryCode like '" + cityCodec1.getText() + "'";
            h++;
        }

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            if (h != 0) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM city WHERE " + Code);
                while (rs.next()) {
                    String code = rs.getString("CountryCode");
                    String name = rs.getString("Name");
                    String district = rs.getString("District");
                    String id = rs.getString("ID");
                    String population = rs.getString("Population");
                    System.out.println(code + " " + name + " " + district + " " + id + " " + population);
                }
            }
            con.close();

            System.out.println("ok");
        } catch (Exception e) {
            System.out.println(e);
        }


        String Code2;
        String CountryCode2;
        String Language;
        String IsOfficial;
        String Percentage;

        int l = 0;

        if (languageCountryCode1.getText() == null) {
            Code2 = null;
        } else {
            Code2 = "CountryCode like '" + languageCountryCode1.getText() + "'";
            l++;
        }

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", Login.user, Login.password);
            Statement stmt = con.createStatement();
            if (l != 0) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM countryLanguage WHERE " + Code2);
                while (rs.next()) {
                    String countryCode = rs.getString("CountryCode");
                    String language = rs.getString("Language");
                    String isOfficial = rs.getString("IsOfficial");
                    String percentage = rs.getString("Percentage");
                    System.out.println(countryCode + " " + language + " " + isOfficial + " " + percentage + "");
                }
            }
            con.close();

            System.out.println("ok");
        } catch (Exception e) {
            System.out.println(e);
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

}