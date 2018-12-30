<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CocktailsList</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/animationAndStyle/styles/css.css">
</head>
<body>
    <%
        ArrayList<String> cocktailsList = (ArrayList<String>)request.getAttribute("cocktailsList");
        for (String str : cocktailsList)
        {
            %>
                <div class="cocktail" >  <% out.println(str); %>  </div>
            <%
        }
    %>
</body>
</html>
