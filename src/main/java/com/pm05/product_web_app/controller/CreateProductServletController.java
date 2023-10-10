package com.pm05.product_web_app.controller;

import java.io.IOException;
import java.sql.Connection;

import com.pm05.product_web_app.model.Product;
import com.pm05.product_web_app.model.DB.DBCrud;
import com.pm05.product_web_app.model.DB.MySQLConnector;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/createProduct")
public class CreateProductServletController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/CreateProductView.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get data from form request
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String priceStr = req.getParameter("price") ;
        double price = 0;
        try{
            price = Double.parseDouble(priceStr);    
        }catch(Exception e){
            e.printStackTrace();
        }
        //Convert data to Product object
        Product product = new Product(code, name, price);
        //Connect to DB
        Connection conn = null;
        conn = MySQLConnector.getMySQLConnection();
        //Save product object to DB
        DBCrud.insertProduct(conn, product);
        //close DB
        MySQLConnector.closeConnection(conn);
        //senRedirect to productList
        resp.sendRedirect(req.getContextPath()+"/productList");
    }
    
}
