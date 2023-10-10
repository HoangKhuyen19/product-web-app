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
@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get code from url query string
        String code = req.getParameter("code");
        //connect to DB
        Connection conn = MySQLConnector.getMySQLConnection();
        //get Product by code
        Product product= DBCrud.findProductByCode(conn, code);
        //close
        MySQLConnector.closeConnection(conn);
        //place product into request object
        req.setAttribute("product", product);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/EditProduct.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get code from form??
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String priceStr = req.getParameter("price");
        double price = 0;
        try {
            price = Double.parseDouble(priceStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Convert to Product object
        Product product = new Product(code, name, price);
        //Connect to DB
        Connection conn = MySQLConnector.getMySQLConnection();
        //update product
        DBCrud.updateProduct(conn, product);
        //close
        MySQLConnector.closeConnection(conn);
        //redirect producList
        resp.sendRedirect(req.getContextPath()+"/productList");
    }
    
}
