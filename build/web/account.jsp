<%-- 
    Document   : account.jsp
    Created on : Nov 21, 2016, 8:41:56 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style ="text-align: center"> Provide your account infomation</h1>
        <form action="ShoppingServlet" method="POST">
            <table>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="username" value="" required/></td>
                </tr>
                <tr>
                    <td>Visa Card Number: </td>
                    <td><input type="text" name="cardnum" value="" required/></td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td><input type="text" name="address" value="" required/></td>
                </tr>
            </table>
              <input type="submit" name="action" value="Submit" />
        </form>
    </body>
</html>
