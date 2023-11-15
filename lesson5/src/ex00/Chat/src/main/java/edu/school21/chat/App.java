package edu.school21.chat;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );


        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/chatserver", "postgres", "postgres");
            Statement stmt1 = con.createStatement();
            Statement stmt2 = con.createStatement();
            ResultSet rs = stmt1.executeQuery("SELECT * FROM users");
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            System.out.println("Columns:");
            for(int i = 1; i < resultSetMetaData.getColumnCount() + 1; ++i) {
                System.out.println("column " + i + " - " +  resultSetMetaData.getColumnName(i));
                System.out.println("resultSetMetaData.getColumnTypeName() - " + resultSetMetaData.getColumnTypeName(i));
                System.out.println("resultSetMetaData.getColumnClassName() - " + resultSetMetaData.getColumnClassName(i));
                System.out.println("resultSetMetaData.isNullable(i) - " + resultSetMetaData.isNullable(i));
            }
            
            int changedCols = stmt2.executeUpdate("UPDATE users SET id = id + 100");

            System.out.println("Data:");
            while(rs.next()) {
                System.out.println("id = " + rs.getString(1) + "\nfull name: " + rs.getString(2) + " " +  rs.getString(3));
            }
            rs.close();
            stmt1.close();
            stmt2.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
