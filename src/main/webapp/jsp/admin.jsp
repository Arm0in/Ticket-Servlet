<%@ page import="ir.maktab.ticket.domain.User" %>
<%@ page import="ir.maktab.ticket.domain.Flight" %>
<%@ page import="ir.maktab.ticket.util.ApplicationContext" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Armin
  Date: 10/12/2021
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <%User currentUser = (User) session.getAttribute("current_user");%>
        <%= currentUser.getUsername() %>'s admin Account
    </title>
</head>
<body>
<%
    List<Flight> flightList = ApplicationContext.getFlightService().findAll();
%>
<form action="<%=request.getContextPath()%>/adddiscount" method="post">
    <p>Enter amount of discount(fractional):</p>
    <%
        for (Flight f : flightList) {
    %>
    <input type="text" id="" name="discount">
    <input type="hidden" name="flightId" value="<%=f.getId()%>">
    <label for="<%=f.getId()%>"><%=f%></label><br>
    <%
        }
    %>
    <input type="submit" name="submit" value="Add discount.">
</form>
</body>
</html>
