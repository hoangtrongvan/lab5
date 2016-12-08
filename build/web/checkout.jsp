<%-- 
    Document   : checkout
    Created on : Nov 24, 2016, 10:44:21 PM
    Author     : admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Test.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="customer" scope="session" class="Test.Accountbean" />
        <h1>Customer: <%out.print(customer.getName()); %></h1>
        <h1>VISA CardNumber: <%out.print(customer.getVisaCardNum()); %></h1>
        <h1>Address: <%out.print(customer.getAddress()); %></h1>
    <center><h2>Product Lists</h2>
        <form action="ShoppingServlet">
        <%     HttpSession session1 = request.getSession(false);
                        if (session1.getAttribute("list")!=null){
                        ArrayList<Product> ProList=  (ArrayList<Product>) session1.getAttribute("list");
                        int total=0;
                       %>  
            <table width="50%">
                <tr>
                <th>
                   Product Name
                </th>
                <th>
                   Product Manufacture
                </th>
                <th>
                    Quantity
                </th>
                <th>
                    Price
                </th>
                </tr>
                <% for(int i=0;i<ProList.size();i++){%>
                
                <tr>    
                    <th>   
                        <%out.print(ProList.get(i).getPro_name());%>
                    </th>
                    <th>
                        <%out.print(ProList.get(i).getPro_manuf());%>
                    </th>
                    <th>
                       <%out.print(ProList.get(i).getPro_quantity());%>
                    </th>
                    <th>
                       $<%out.print(ProList.get(i).getPro_price());
                         total=total+ProList.get(i).getPro_price();%> 
                    </th>
                    <%}%>
                </tr>
                <td>
                    <h2>Total: $<%=total%></h2>
                    <%}%>
                </td>
            </table>
                    <input type="submit" name="action" value="Shop some more"/>
                    <input type="submit" name="action" value ="Logout"/>  
        </form>            
    </center>
    </body>
</html>
