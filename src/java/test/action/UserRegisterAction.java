/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.action;

/**
 *
 * @author Sauvik
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
 
import test.dao.UserRegisterDAO;
import test.form.UserRegisterForm;
 
public class UserRegisterAction extends Action {
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
        UserRegisterDAO dao = new UserRegisterDAO();
        String return_string=dao.insertData(firstName, lastName, email, phone);
        
        if(!return_string.equals("ok")){
            return mapping.findForward("error");
        }
        
        ses.setAttribute("firstName", firstName);
        ses.setAttribute("lastName", lastName);
        ses.setAttribute("email", email);
        ses.setAttribute("phone", phone);
        
        return mapping.findForward("success");
 
    }
}