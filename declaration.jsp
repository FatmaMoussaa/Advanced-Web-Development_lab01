
<%@ page contentType="text/html;charset=UTF-8" %>

<%!
    private int numEntries = 10;

    private int randomInt(int range) {
        return (1 + ((int)(Math.random() * range)));
    }
%>

<html>
<head>
    <title>JSP Declaration</title>
</head>
<body>

    <h2>A random list from 1 to 100:</h2>

    <ul>
        <%
            for(int i = 0; i < numEntries; i++) {
                out.println("<li>" + randomInt(100) + "</li>");
            }
        %>
    </ul>

</body>
</html>
