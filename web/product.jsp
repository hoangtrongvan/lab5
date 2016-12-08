<%-- 
    Document   : product.jsp
    Created on : Nov 21, 2016, 9:11:01 AM
    Author     : admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Test.Product" %>
<!DOCTYPE html>
<html> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <jsp:useBean id="customer" scope="session" class="Test.Accountbean" />
        <h1>Hello <%out.print(customer.getName()); %>
            </h1>
            <h2>
                Please select our products and its quantity
            </h2>
            
            <form action ="ShoppingServlet" method ="POST">
                <table>
                    <tr>
                        <td>
                            <strong>Product: </strong>
                        </td>
                        <td>          
                <select name="Product"> 
                    <option value="1">Pac</option>
                    <option value="2">Ppad</option>
                    <option value="3">Pphone</option>
                    <option value="4">Pwatch</option>
                    <option value="5">PTV</option>
                </select>
                        </td>
                        <td>
                            Quantity: 
                        </td>
                        <td>
                            <input type="text" name="quantity" size ="10px" value="" required/>
                        </td>
                        <td>
                            <input type="submit" name ="action" value="AddtoCart" />
                        </td>
                </tr>
                </table>    
            </form>
            <form action ="ShoppingServlet">
            <%     HttpSession session1 = request.getSession(false);
                        if (session1.getAttribute("list")!=null){
                        ArrayList<Product> ProList=  (ArrayList<Product>) session1.getAttribute("list");
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
                    Product Price
                </th>
                <th>
                    Quantity
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
                       <%out.print(ProList.get(i).getPro_price());%>
                    </th>
                    <th>
                       <%out.print(ProList.get(i).getPro_quantity());%>
                    </th>
                    <th>
                        <button type="submit" name = "action" value ="<%=i%>">Delete</button>
                    </th>
                    <%}}%>
                </tr>
            </table>
                <input type="submit" value="Checkout" name="action"/>
    </form>
            </center>
    </body>
</html>
