package entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {

    public static void main(String[] args) {
        try
        {
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world","root","Dap20040812");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
