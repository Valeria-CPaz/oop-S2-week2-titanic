package com.val;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/titanicmanifest", "ValeriaPaz", "280585");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from passengers");

            System.out.println("before while");

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " +
                        rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5)
                        + " " + rs.getString(6) + " " + rs.getString(7) + " " + rs.getString(8)
                        + " " + rs.getString(9) + " " + rs.getString(10) + " " + rs.getString(11));
            }
            System.out.println("after while");

            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());

        } finally {
            System.out.println("finally");


        }
    }
}


