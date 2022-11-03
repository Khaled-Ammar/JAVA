<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>fruityloops</title>
        </head>
        
        <body>
            <h1>Fruity</h1>
            <table border=1>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                </tr>
                <c:forEach var="fruity" items="${fruity1}">
                    <tr>
                        <td>
                            <c:out value="${fruity.name}"></c:out>
                        </td>
                        <td>
                            <c:out value="${fruity.price}"></c:out>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </body>

        </html>