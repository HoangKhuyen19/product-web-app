<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!Doctype html>
<html>
    <head>
        <title>Product List Page</title>
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="Header.jsp"></jsp:include>
        <!-- Menu -->
        <jsp:include page="Menu.jsp"></jsp:include>
        <!-- Content -->
        <h2>Create Product Page</h2>
        <form action="createProduct" method="post">
            <table border="1">
                <tr>
                    <th>Code</th>
                    <td><input type="text" name="code" required></td>
                </tr>
                <tr>
                    <th>Name</th>
                    <td><input type="text" name="name" required></td>
                </tr>
                <tr>
                    <th>Price</th>
                    <td><input type="number" name="price"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="save">
                        <a href="createProduct"></a>
                        <a href="productList">Cancel</a>
                    </td>
                </tr>
            </table>
        </form>
        <!-- Footer -->
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
</html>