/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;

import JDBCConn.DatabaseConnection;
import java.sql.*;

import admin.form.ChangePasswordForm;

/**
 *
 * @author Sauvik
 */
public class ChangePasswordAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ChangePasswordForm loginForm = (ChangePasswordForm) form;

        HttpSession hs = request.getSession();

        int val = 0;

        Statement pstm = null;
        PreparedStatement prest = null;
        Connection connect = new DatabaseConnection().DataConn();
        try {
            connect.setAutoCommit(false);
            pstm = connect.createStatement();

            PreparedStatement pre_st = connect.prepareStatement("UPDATE users_login_details SET pass=? where username=? and pass=?");

            pre_st.setString(1, loginForm.getnewpassword());
            pre_st.setString(2, "a");
            pre_st.setString(3, loginForm.getoldpassword());

            val = pre_st.executeUpdate();

            connect.commit();
            pstm.close();
        } catch (SQLException e) {
            if (connect != null) {
                try {
                    connect.rollback();
                    return (mapping.findForward("error"));
                } catch (Exception ex) {
                    return (mapping.findForward("error"));
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
                return (mapping.findForward("error"));
            }
        }
        if (val > 0) {
            return (mapping.findForward("success"));
        } else {
            ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.oldpassword.didnotmatch"));
            saveErrors(request, errors);
            return (mapping.getInputForward());
        }
    }
}
