package entities;

import javax.swing.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.stage.Stage;


public class Login {
    private static Stage stage;
    private static Scene scene;
    private static Parent root;

    public static boolean sign = false;
    @FXML private TextField myUserField;
    @FXML private TextField myPasswordText;

    public static String user;
    public static String password;

    public void switchToHome(ActionEvent event) throws IOException {
        user = myUserField.getText();
        password = myPasswordText.getText();
        connect(user,password);
        if(sign)
        {
            root = FXMLLoader.load(Login.class.getResource("Home.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.setFullScreenExitHint("Exit");
            stage.show();
        }
    }

    public void connect(String user, String password){
        try
        {
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world",user,password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("show databases");
            JOptionPane.showMessageDialog(null, "Bienvenido");
            sign = true;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Datos incorrectos");
            sign = false;
        }
    }


}
