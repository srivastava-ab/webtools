<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome to home page</title>
    </head>
    <body>
        <table align="center">
            <tr>
                <td><a href="login" id="login">Login</a>
                </td>
                <td><a href="register" id="register">Register</a>
                </td>

            </tr>
            <tr>

                <td>
                    <form id="searchMail" action="search" method="post" >

                        <label>Search email:</label><br>
                        <input type="text" id="searchEmail" name="searchEmail" size="10" maxlength="140"><br>
                        <input id="search" type="submit" tabindex="6" value="Search">
                    </form>
                </td>

            </tr>
        </table>
    </body>
    </html>