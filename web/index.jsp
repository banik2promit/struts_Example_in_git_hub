<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/jqueryui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/jqueryui/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/jqueryui/demo.css">
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/jqueryui/jquery.min.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/jqueryui/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/validation_rules.js"></script>
        <title>Index</title>
    </head>
    <!--<body bgcolor="silver">
        <br></br>-->
    <body>
        <html:html>
            <div style="color:red">
                <html:errors />
            </div>
            <html:form action="/register.do" method="post">

                Enter your First Name:
                <html:text property="firstName" styleId="firstName" styleClass="easyui-textbox"/><br><br>
                Enter your Last Name:
                <html:text property="lastName"  /><br><br>
                Enter your Email:
                <html:text property="email" /><br><br>
                Enter your Phone No:
                <html:text property="phone" /><br><br>
                <html:submit>Submit</html:submit>
                    <br><br>
            </html:form>
        </html:html>


        <script>

            $('#firstName').textbox({
                required: "true",
                validType: 'length[0,5]'
            });
        </script>        
    </body>
</html>