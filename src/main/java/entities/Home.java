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

    @FXML
    private TableView<Country> myCountryTable;

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

    @FXML
    private TableView<Language> myLanguageTable;

    @FXML public TableColumn<Language, String> myLanguageCode;
    @FXML public TableColumn<Language, String> myLanguageLanguage;
    @FXML public TableColumn<Language, String> myLanguageOfficial;
    @FXML public TableColumn<Language, String> myLanguagePercentage;


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
        GenerateCity();
        GenerateCountry();
        GenerateLanguage();

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

        myLanguageCode.setCellValueFactory(new PropertyValueFactory<>("CountryCode"));
        myLanguageLanguage.setCellValueFactory(new PropertyValueFactory<>("Language"));
        myLanguageOfficial.setCellValueFactory(new PropertyValueFactory<>("IsOfficial"));
        myLanguagePercentage.setCellValueFactory(new PropertyValueFactory<>("Percentage"));
        myLanguageTable.setItems(languages);




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
        update.setDisable(false);
        ok.setDisable(true);
        ok.setOpacity(0);
        update.setOpacity(1);
    }

}
