<%@ page import="ir.maktab.ticket.domain.User" %>
<%@ page import="ir.maktab.ticket.util.ApplicationContext" %>
<%@ page import="ir.maktab.ticket.domain.Flight" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Armin
  Date: 10/11/2021
  Time: 5:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <%User currentUser = (User) session.getAttribute("current_user");%>
        <%= currentUser.getUsername() %>'s Account
    </title>
</head>
<body>
<%
    List<Flight> flightList = ApplicationContext.getFlightService().findAll();
%>
<form action="<%=request.getContextPath()%>/jsp/flights.jsp" method="get">
    <h3>Search Flights from/to: </h3>
    <table>
        <tr>
            <td><label for="origin">Origin: </label></td>
            <td><input list="origins" name="origin" id="origin"/></td>
            <datalist id="origins">
                <%
                    for (Flight flight : flightList) {
                %>
                <option value="<%=flight.getOrigin()%>">
                        <%
                    }
                %>
            </datalist>
            <td><label for="destination">Destination: </label></td>
            <td><input list="destinations" name="destination" id="destination"/></td>
            <datalist id="destinations">
                <%
                    for (Flight flight : flightList) {
                %>
                <option value="<%=flight.getDestination()%>">
                        <%
                    }
                %>
            </datalist>
            <td><input type="submit" name="submit" value="Search"></td>
        </tr>
    </table>
</form>
<form action="<%=request.getContextPath()%>/addbalance" method="post">
    <h3>Add to your balance:</h3>
    <table>
        <tr>
            <td><label for="amount">Add amount to balance:</label></td>
            <td><input type="text" name="amount" id="amount"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input
                        type="submit"
                        name="submit"
                        id="submit-key"
                        value="Add!"
                />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
