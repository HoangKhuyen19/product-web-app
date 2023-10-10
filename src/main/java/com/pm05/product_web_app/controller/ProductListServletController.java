package com.pm05.product_web_app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.pm05.product_web_app.model.Product;
import com.pm05.product_web_app.model.DB.DBCrud;
import com.pm05.product_web_app.model.DB.MySQLConnector;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/productList")
public class ProductListServletController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        List<Product> productList = null;
        //Connection DB
        conn = MySQLConnector.getMySQLConnection();
        //Get product list
        productList = DBCrud.getAllProduct(conn);
        //Close connection
        MySQLConnector.closeConnection(conn);
        //Đưa danh sách sp vào request
        req.setAttribute("productList", productList);
        
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/ProductList.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
    
}
