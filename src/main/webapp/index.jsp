<html>
<head>
    <title>Maktab Booking System</title>
</head>
<body>
<h1>Maktab Booking Ticket System</h1>

<%
    if (session.getAttribute("current_user") == null) {
%>
<h2>Login</h2>
<form action="authenticate" method="post">
    <label for="username">Username:</label>
    <input type="text" name="username" id="username"/>

    <label for="password">Password:</label>
    <input type="text" name="password" id="password"/>

    <input type="submit" value="Login"/>
    <p>Don't have an account yet? <a href="<%=request.getContextPath()%>/jsp/register.jsp">Sign up.</a></p>
</form>
<%
    } else {
%>
<h2>Welcome <% session.getAttribute("current_user"); %> </h2>
<%
    }
%>
</body>
</html>
