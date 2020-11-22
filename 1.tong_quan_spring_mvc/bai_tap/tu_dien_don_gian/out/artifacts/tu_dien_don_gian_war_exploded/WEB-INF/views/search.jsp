<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 11/22/2020
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${result != null}">
    <h3>Result:${result}</h3>
</c:if>
<c:if test="${result == null}">
    <h3>Không tìm thấy </h3>
</c:if>
</body>
</html>
