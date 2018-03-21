<%--
    Document   : changepassword
    Created on : Jul 3, 2016, 8:40:45 PM
    Author     : Sauvik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div style="color:red">
    	<html:errors />
    </div>
    <html:form action="/changepassword.do" >
        Old Password :<html:password name="ChangePassword" property="oldpassword" />
        <br><br>
        New Password  :<html:password name="ChangePassword" property="newpassword" />
        <br><br>
        Confirm Password  :<html:password name="ChangePassword" property="confpassword" />
        <br><br>
        <html:submit value="Change" />
    </html:form>

    </body>
</html>
