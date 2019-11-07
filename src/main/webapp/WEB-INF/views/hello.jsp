<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<head>
    <meta charset="UTF-8">
    <title>Hello ${name}!</title>
   
    <link href="${contextPath}resources/css/main.css" rel="stylesheet">
</head>
<body>
    <h2 class="hello-title">Hello ${name}!</h2>
    <p>Contextpath: ${pageContext.request.contextPath}</p>
</body>
</html>
