<%--
  Created by IntelliJ IDEA.
  User: Armin
  Date: 10/11/2021
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h2>Register Passenger</h2>
<form action="/Ticket_Servlet_war/create" style="margin-top: 20px" method="post">
    <table>
        <tr>
            <td><label for="username">Username:</label></td>
            <td><input type="text" name="username" id="username"/></td>
        </tr>
        <tr>
            <td><label for="password">Password:</label></td>
            <td><input type="text" name="password" id="password"/></td>
        </tr>
        <tr>
            <td><label for="firstname">Firstname:</label></td>
            <td><input type="text" name="firstname" id="firstname"/></td>
        </tr>
        <tr>
            <td><label for="lastname">Lastname:</label></td>
            <td><input type="text" name="lastname" id="lastname"/></td>
        </tr>
        <tr>
            <td><label for="email">E-mail:</label></td>
            <td><input type="text" name="email" id="email"/></td>
        </tr>
        <tr>
            <td><label for="mobilenumber">Mobile Number:</label></td>
            <td><input type="text" name="mobilenumber" id="mobilenumber"/></td>
        </tr>
        <tr>
            <td><label for="birthdate">Birth Date:</label></td>
            <td><input type="date" name="birthdate" id="birthdate"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input
                        type="submit"
                        name="submit"
                        id="submit-key"
                        value="Create Account"
                />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
