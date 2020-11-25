<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 11/24/2020
  Time: 1:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="index" method="post">
    <label style="font-weight: bold">Languages:</label>
    <select name="languages">
        <option value="English" >English</option>
        <option value="Vietnamese">Vietnamese</option>
        <option value="Japanese">Japanese</option>
        <option value="Chinese">Chinese</option>
    </select><br><br>
    <label style="font-weight: bold">Page Size:</label>
    <label style="margin-left: 20px">Show</label>
    <select name="pageSize">
        <option value="5">5</option>
        <option value="10">10</option>
        <option value="15">15</option>
        <option value="25">25</option>
        <option value="50">50</option>
        <option value="100">100</option>
    </select>
    <label>emails per page</label><br><br>
    <label style="font-weight: bold">Spams filter:</label>
    <input type ="checkbox" name="spamsFilter" value="true"/>Enable spams filter<br><br>
    <label style="font-weight: bold">Signature:</label><br>
    <textarea name="signature" cols="20px" rows="5px"></textarea><br><br>
    <input style="background: aqua" type="submit" value="Update">
    <input type="button" value="Cancel">
</form:form>
</body>
</html>
<%--    <label style="font-weight: bold">Languages:</label>--%>
<%--    <form:select path="languages">--%>
<%--        <form:option value="English">English</form:option>--%>
<%--        <form:option value="Vietnamese">Vietnamese</form:option>--%>
<%--        <form:option value="Japanese">Japanese</form:option>--%>
<%--        <form:option value="Chinese">Chinese</form:option>--%>
<%--    </form:select><br><br>--%>
<%--    <label style="font-weight: bold">Page Size:</label>--%>
<%--    <label style="margin-left: 20px">Show</label>--%>
<%--    <form:select path="pageSize">--%>
<%--        <form:option value="5">5</form:option>--%>
<%--        <form:option value="10">10</form:option>--%>
<%--        <form:option value="15">15</form:option>--%>
<%--        <form:option value="25">25</form:option>--%>
<%--        <form:option value="50">50</form:option>--%>
<%--        <form:option value="100">100</form:option>--%>
<%--    </form:select>--%>
<%--    <label>emails per page</label><br><br>--%>
<%--    <label style="font-weight: bold">Spams filter:</label>--%>
<%--    <form:input type ="checkbox" path="spamsFilter"/>Enable spams filter<br><br>--%>
<%--    <label style="font-weight: bold">Signature:</label>--%>
<%--    <t type = "" path="signature"/>--%>
<%--    <input style="background: aqua" type="submit" value="Update">--%>
<%--    <input type="button" value="Cancel">--%>

