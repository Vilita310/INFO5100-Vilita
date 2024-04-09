package hwtochapters13;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLServerConnector {
    public static void main(String[] args) {
        // Connection details
        String serverName = "boyce.coe.neu.edu";
        String database = "Lab4_JingCao"; 
        String username = "INFO6210";
        String password = "NEUHusky!";
        String url = "jdbc:sqlserver://" + serverName + ";databaseName=" + database + ";trustServerCertificate=true";


        // Load the JDBC driver class
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {    
            System.out.println("JDBC driver not found.");
            e.printStackTrace();
            return; // Exit if there is no JDBC driver found
        }

        // Establish a connection to the database
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the SQL Server database successfully.");
            // You can now perform database operations here

            // Load from database and read Advisor table
            String sql="select * from Lab4_JingCao.dbo.Advisor";
            PreparedStatement p=connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
 
            // print table content
            System.out.println("Original Table:");
            System.out.println("advisorid\t\tadvisorlastname\t\tadvisorfirstname");
            while (rs.next()) {
 
                int advisorid = rs.getInt("advisorid");
                String advisorlastname = rs.getString("adviorlastname");
                String advisorfirstname = rs.getString("advisorfirstname");
                System.out.println(advisorid + "\t\t" + advisorlastname
                                   + "\t\t" + advisorfirstname);
            }

            // get advisorid=1 and advisorlastname=Smith. Now modify the advisorlastname to Snow
            String sql2="update Lab4_JingCao.dbo.Advisor set adviorlastname='Snow' where advisorid=1";
            PreparedStatement p2=connection.prepareStatement(sql2);
            p2.executeUpdate();

            // Load from database and read Advisor table
            rs = p.executeQuery();

            // print table content
            System.out.println("Modified Table:");
            System.out.println("advisorid\t\tadvisorlastname\t\tadvisorfirstname");
            while (rs.next()) {
 
                int advisorid = rs.getInt("advisorid");
                String advisorlastname = rs.getString("adviorlastname");
                String advisorfirstname = rs.getString("advisorfirstname");
                System.out.println(advisorid + "\t\t" + advisorlastname
                                   + "\t\t" + advisorfirstname);
            }

            // Now rollback change
            String sql3="update Lab4_JingCao.dbo.Advisor set adviorlastname='Smith' where advisorid=1";
            PreparedStatement p3=connection.prepareStatement(sql3);
            p3.executeUpdate();
            System.out.println("Modification rolled back.");

        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}