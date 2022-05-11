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
                    "jdbc:mysql://localhost:3306/world","root","Lucasacero13");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT name FROM country WHERE name = 'Colombia'");
            while ( rs.next() ) {
                String Name = rs.getString("Name");
                System.out.println(Name);
            }
            con.close();        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
