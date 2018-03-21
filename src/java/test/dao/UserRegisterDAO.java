/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

/**
 *
 * @author Sauvik
 */
import java.sql.*;
import JDBCConn.DatabaseConnection;

public class UserRegisterDAO {

    public String insertData(String firstName, String lastName, String email, String phone) throws Exception {
        Statement pstm = null;
        PreparedStatement prest = null;
        Connection connect = new DatabaseConnection().DataConn();        
        try {
            connect.setAutoCommit(false);
            pstm = connect.createStatement();

            PreparedStatement pre_st = connect.prepareStatement("INSERT INTO user_details(`first_name`,`last_name`,`email`,`phone`,`create_date`) "
                    + "VALUES(?,?,?,?,now())");
            pre_st.setString(1, firstName);
            pre_st.setString(2, lastName);
            pre_st.setString(3, email);
            pre_st.setString(4, phone);

            pre_st.executeUpdate();

            connect.commit();
            pstm.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
            if (connect != null) {
                try {
                    connect.rollback();
                } 
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return "sql_error";
        } 
        finally {
            try {
                if(pstm!=null)
                {
                    pstm.close();
                }
                if (connect != null && !connect.isClosed()) {
                    connect.close();
                }
            } 
            catch (Exception ex) {
                System.out.println(ex.toString());                
                return "sql_error";
            }            
        }
        return "ok";
    }
}
