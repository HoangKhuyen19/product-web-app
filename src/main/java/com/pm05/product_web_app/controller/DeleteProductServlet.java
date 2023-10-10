package com.pm05.product_web_app.controller;

import java.io.IOException;
import java.sql.Connection;

import com.pm05.product_web_app.model.DB.DBCrud;
import com.pm05.product_web_app.model.DB.MySQLConnector;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get code from url query
        String code = req.getParameter("code");
        // Connect to DB
        Connection conn = MySQLConnector.getMySQLConnection();
        // Delete product by code
        DBCrud.deleteProduct(conn, code);
        // Close DB
        MySQLConnector.closeConnection(conn);
        // redirect productList
        resp.sendRedirect(req.getContextPath() + "/productList");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
