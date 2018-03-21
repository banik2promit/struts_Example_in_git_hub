/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCConn;

import java.sql.*;
import javax.sql.*;
import java.io.*;

/**
 *
 * @author Sayan
 */
public class DatabaseConnection {

    //driver name & URL
    final String driver = "com.mysql.jdbc.Driver";
    final String url = "jdbc:mysql://localhost:3306/struts_example_db";

    //DB credentials
    final String user = "root";
    final String datapass = "abcdefgh";

    public Connection DataConn() {
        Connection connect = null;
        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(url, user, datapass);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return connect;
    }
}
