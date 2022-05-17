package entities;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML
    private TableView<City> myCityTable;

    @FXML public TableColumn<City, String> myCityID;
    @FXML public TableColumn<City, String> myCityName;
    @FXML public TableColumn<City, String> myCityCode;
    @FXML public TableColumn<City, String> myCityDis;
    @FXML public TableColumn<City, String> myCityPopu;

    @FXML
    private TableView<City> myCountryTable;

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




    private final ObservableList<City> cities = FXCollections.observableArrayList();

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
                System.out.println(city.Id);
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
                String  Name = rs.getString("Name");
                String  CountryCode = rs.getString("CountryCode");
                String District = rs.getString("District");
                String Population = rs.getString("Population");
                City city = new City("",Name,CountryCode,District,Population);
                cities.add(city);
                myCityTable.refresh();
                System.out.println(city.Id);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        GenerateCity();
        myCityName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        myCityCode.setCellValueFactory(new PropertyValueFactory<>("CountryCode"));
        myCityID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        myCityDis.setCellValueFactory(new PropertyValueFactory<>("District"));
        myCityPopu.setCellValueFactory(new PropertyValueFactory<>("Population"));

        myCityTable.setItems(cities);

        GenerateCountry();
        myCountryCode.setCellValueFactory(new PropertyValueFactory<>("Code"));
        myCountryName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        myCountryContinent.setCellValueFactory(new PropertyValueFactory<>("Continent"));
        myCountryRegion.setCellValueFactory(new PropertyValueFactory<>("Region"));
        myCountryArea.setCellValueFactory(new PropertyValueFactory<>("SurfaceArea"));
        myCountryIndep.setCellValueFactory(new PropertyValueFactory<>("IndepYear"));
        myCountryCode.setCellValueFactory(new PropertyValueFactory<>("Code"));

    }
}
