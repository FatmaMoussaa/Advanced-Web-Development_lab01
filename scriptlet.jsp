
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP Scriptlet</title>
</head>
<body>

    <h1>JSP Scriptlet</h1>

    <%
        java.util.Date currentTime = new java.util.Date();
        String clientHost = request.getRemoteHost();
    %>

    <p>Current time: <%= currentTime %></p>

    <p>Client host: <%= clientHost %></p>

</body>
</html>
