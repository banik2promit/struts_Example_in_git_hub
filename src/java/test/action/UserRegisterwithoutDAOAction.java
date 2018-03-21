/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

//import test.dao.UserRegisterDAO;
import test.form.UserRegisterForm;
import java.sql.*;
import JDBCConn.DatabaseConnection;

/**
 *
 * @author Sauvik
 */
public class UserRegisterwithoutDAOAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession ses = request.getSession(true);

        UserRegisterForm registerForm = (UserRegisterForm) form;
        String firstName = registerForm.getFirstName();
        String lastName = registerForm.getLastName();
        String email = registerForm.getEmail();
        String phone = registerForm.getPhone();

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
        } catch (SQLException e) {
            if (connect != null) {
                try {
                    connect.rollback();
                    return mapping.findForward("error");
                } catch (Exception ex) {
                    return mapping.findForward("error");
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (connect != null && !connect.isClosed()) {
                    connect.close();
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
                return mapping.findForward("error");
            }
        }

        ses.setAttribute("firstName", firstName);
        ses.setAttribute("lastName", lastName);
        ses.setAttribute("email", email);
        ses.setAttribute("phone", phone);

        return mapping.findForward("success");

    }
}
