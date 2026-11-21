<%@ page contentType="text/html ;charset=UTF-8"%>
<html>
<head>
<title>Person Information</title>
</head>
<body>
<h2>Person Information</h2>
    <jsp:useBean id="person" class="isep.Lab01.bean.Person" scope="page" />
    <jsp:setProperty name="person" property="*" />
   <p>First Name:
    <jsp:getProperty name="person" property="firstName" />
    </p>
   <p>Last Name :
    <jsp:getProperty name="person" property="lastName" />
    </p>
    <p>Birth Day:
    <jsp:getProperty name="person" property="birthDay" />
    </p>
  <p>Sex:
    <jsp:getProperty name="person" property="sex" />
    </p>
</body>
</html>
