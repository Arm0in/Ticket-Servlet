<%@ page import="java.util.List" %>
<%@ page import="ir.maktab.ticket.domain.Flight" %>
<%@ page import="ir.maktab.ticket.util.ApplicationContext" %><%--
  Created by IntelliJ IDEA.
  User: Armin
  Date: 10/11/2021
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flights</title>
</head>
<body>
<%
    List<Flight> flightList = ApplicationContext.getFlightService().getFlightsByFromTo(request.getParameter("origin"), request.getParameter("destination"));
%>

<form action="<%=request.getContextPath()%>/purchase" method="get">
    <%
        for (Flight f : flightList) {
    %>
    <input type="radio" id="<%=f.getId()%>" name="flight" value="<%=f.getId()%>">
<%--    <input type="radio" id="<%=f.getId()%>" name="flight" value="<%=f.getId()%>">--%>
    <label for="<%=f.getId()%>"><%=f%></label><br>
    <%
        }
    %>
    <input type="submit" name="submit" value="Purchase ticket.">
</form>
</body>
</html>
