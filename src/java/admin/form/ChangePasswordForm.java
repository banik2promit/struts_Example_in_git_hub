/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admin.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author User
 */
public class ChangePasswordForm extends ActionForm{
private String oldpassword = null;
private String newpassword = null;
private String confpassword = null;

    public String getoldpassword(){
        return oldpassword;
    }
    public void setoldpassword(String oldpassword){
        this.oldpassword=oldpassword;
    }
    public String getnewpassword(){
        return newpassword;
    }
    public void setnewpassword(String newpassword){
        this.newpassword=newpassword;
    }
    public String getconfpassword(){
        return confpassword;
    }
    public void setconfpassword(String confpassword){
        this.confpassword=confpassword;
    }

    
 @Override
    public ActionErrors validate(ActionMapping mapping,
     HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if(this.oldpassword == null || this.oldpassword.trim().equals(""))
            errors.add("oldpassword", new ActionMessage("error.password.required","Old"));
        if(this.newpassword == null || this.newpassword.trim().equals(""))
            errors.add("newpassword", new ActionMessage("error.password.required","New"));
        if(this.confpassword == null || this.confpassword.trim().equals(""))
            errors.add("confpassword", new ActionMessage("error.password.required","Confirm"));
        if(this.newpassword.length()<6 || this.newpassword.length()>12)
            errors.add("newpassword", new ActionMessage("error.password.range","New","6","12"));
        if(this.oldpassword.equals(this.newpassword))
            errors.add("oldpassword", new ActionMessage("error.oldpassword.match"));
        if(!this.newpassword.equals(this.confpassword))
            errors.add("confpassword", new ActionMessage("error.confpassword.didnotmatch"));
        
        return errors;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.oldpassword = null;
        this.newpassword = null;
        super.reset(mapping, request);
    }
}
