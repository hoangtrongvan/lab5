package Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class ShoppingServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     ArrayList<Product> ProductList = new ArrayList<>();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if ("Submit".equals(action)){
            String name= request.getParameter("username");
        String num= request.getParameter("cardnum");
        String add = request.getParameter("address");
        Accountbean customer1 = new Accountbean();
        customer1.setName(name);
        customer1.setVisaCardNum(num);
        customer1.setAddress(add);
        HttpSession session = request.getSession(true);
        session.setAttribute("customer",customer1);
        session.setMaxInactiveInterval(60*60*24);
        //response.sendRedirect("product.jsp");
        request.getRequestDispatcher("product.jsp").forward(request, response);
            }
        if("AddtoCart".equals(action)){
            Product Pac = new Product();
        Product Ppac= new Product();
        Product Pphone = new Product();
        Product Pwatch = new Product();
        Product PTV = new Product();
        Pac.setPro_name("Pac");
        Pac.setPro_manuf("PineApple");
        Pac.setPro_price(1200);
        Pac.setPro_quantity(1);
        Ppac.setPro_name("PPac");
        Ppac.setPro_manuf("PineApple");
        Ppac.setPro_price(1000);
        Ppac.setPro_quantity(1);
        Pphone.setPro_name("PPhone");
        Pphone.setPro_manuf("PineApple");
        Pphone.setPro_price(800);
        Pphone.setPro_quantity(1);
        Pwatch.setPro_name("PWatch");
        Pwatch.setPro_manuf("PineApple");
        Pwatch.setPro_price(600);
        Pwatch.setPro_quantity(1);
        PTV.setPro_name("PTV");
        PTV.setPro_manuf("PineApple");
        PTV.setPro_price(1500);
        PTV.setPro_quantity(1);
          String a = request.getParameter("Product");
          int indx = Integer.parseInt(request.getParameter("quantity"));
          int price;
          HttpSession session = request.getSession(true);
          if (a.equals("1")){
              Pac.setPro_quantity(indx);
              price = indx*1200;
              Pac.setPro_price(price);
              ProductList.add(Pac);
              //HttpSession session = request.getSession(true);
              session.setAttribute("list", ProductList);
          }
          if (a.equals("2")){
              Ppac.setPro_quantity(indx);
              price = indx*1000;
              Ppac.setPro_price(price);
              ProductList.add(Ppac);
              //HttpSession session = request.getSession(true);
              session.setAttribute("list", ProductList);
          }
          if (a.equals("3")){
              Pphone.setPro_quantity(indx);
              price = indx*800;
              Pphone.setPro_price(price);
              ProductList.add(Pphone);
              //HttpSession session = request.getSession(true);
              session.setAttribute("list", ProductList);
          }
          if (a.equals("4")){
              Pwatch.setPro_quantity(indx);
              price = indx*600;
              Pwatch.setPro_price(price);
              ProductList.add(Pwatch);
              //HttpSession session = request.getSession(true);
              session.setAttribute("list", ProductList);
          }
          if (a.equals("5")){
              PTV.setPro_quantity(indx);
              price = indx*1500;
              PTV.setPro_price(price);
              ProductList.add(PTV);
              //HttpSession session = request.getSession(true);
              session.setAttribute("list", ProductList);
          }
          //HttpSession session = request.getSession(true);
          //session.setAttribute("list", ProductList);
          
        request.getRequestDispatcher("product.jsp").forward(request, response);
        }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
       
     if("Checkout".equals(action)){
         if(ProductList.size()==0){
             request.getRequestDispatcher("product.jsp").forward(request, response);
         }
         else{
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
         }
     }
     if((!"Checkout".equals(action))&&(!"AddtoCart".equals(action))&&(!"Shop some more".equals(action))&&(!"Logout".equals(action))){
        int d = Integer.parseInt(action);
        ProductList.remove(d);
        HttpSession session = request.getSession(true);
        session.setAttribute("list",ProductList);
        request.getRequestDispatcher("product.jsp").forward(request, response);
     }
     if(("Shop some more".equals(action))){
         ProductList.removeAll(ProductList);
         HttpSession session = request.getSession(true);
         session.setAttribute("list",ProductList);
        response.sendRedirect("product.jsp"); 
     }
     if(("Logout".equals(action))){
         response.sendRedirect("account.jsp");
     }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
