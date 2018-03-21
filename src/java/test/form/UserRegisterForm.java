/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.form;
import javax.servlet.http.HttpServletRequest;
 
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
 
public class UserRegisterForm extends ActionForm {
 
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
 
    /**
     *
     * @param mapping
     * @param request
     * @return
     */
    @Override
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (firstName == null || firstName.length() < 1) {
            errors.add("firstName", new ActionMessage(
                    "error.firstName.required"));
 
        }
        if (lastName == null || lastName.length() < 1) {
            errors.add("lastName", new ActionMessage("error.lastName.required"));
 
        }
        if (email == null || email.length() < 1) {
            errors.add("email", new ActionMessage("error.email.required"));
 
        }
        if (phone == null || phone.length() < 1) {
            errors.add("phone", new ActionMessage("error.phone.required"));
 
        }
        return errors;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPhone() {
        return phone;
    }
 
    public void setPhone(String phone) {
        this.phone = phone;
    }
 
}