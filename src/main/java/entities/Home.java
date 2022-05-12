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

    private final ObservableList<City> cities = FXCollections.observableArrayList();

    public void GenerateCity() {

        try {
            int ID = 1;
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world", "root", "Dap20040812");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        GenerateCity();
        myCityName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        myCityCode.setCellValueFactory(new PropertyValueFactory<>("CountryCode"));
        myCityID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        myCityDis.setCellValueFactory(new PropertyValueFactory<>("District"));
        myCityPopu.setCellValueFactory(new PropertyValueFactory<>("Population"));

        myCityTable.setItems(cities);

    }
}
