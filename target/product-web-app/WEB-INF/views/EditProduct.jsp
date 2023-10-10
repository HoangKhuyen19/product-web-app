<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!Doctype html>
<html>
    <head>
        <title>Create Product Page</title>
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="Header.jsp"></jsp:include>
        <!-- Menu -->
        <jsp:include page="Menu.jsp"></jsp:include>
        <!-- Content -->
        <h1>Edit Product</h1>
        <c:if test="${not empty product}">
            <form action="editProduct" method="post">
                <input hidden name="code", value="${product.code}">
                <table border="1">     
                    <!-- <tr>
                        <th>Code</th>
                        <td><input type="text" name="code" value="${product.code}"></td>
                    </tr> -->
                    <tr>    
                        <th>Name</th>
                        <td><input type="text" name="name" value="${product.name}"></td>
                    </tr>
                    <tr>
                        <th>Price</th>
                        <td><input type="text" name="price" value="${product.price}"> </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Edit">
                            <a href="editProduct"></a>
                            <a href="productList">Cancel</a>
                        </td>
                    </tr>
                </table>
            </form>
        </c:if>
        
        <!-- Footer -->
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
</html>