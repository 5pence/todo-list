<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="spencer.barriball.util.Mappings" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>View Item</title>
</head>
<body>
    <div align="center">
        <h1>Item Details</h1>
        <table>
            <tr>
                <td><label>ID</label></td>
                <td>
                    <c:out value="${todoItem.id}" />
                </td>
            </tr>
            <tr>
                <td><label>Title</label></td>
                <td>
                    <c:out value="${todoItem.title}" />
                </td>
            </tr>
            <tr>
                <td><label>Details</label></td>
                <td>
                    <c:out value="${todoItem.details}" />
                </td>
            </tr>
            <tr>
                <td><label>Deadline</label></td>
                <td>
                    <c:out value="${todoItem.deadLine}" />
                </td>
            </tr>
        </table>
        <a href="${Mappings.ITEMS}">List Items</a>
    </div>
</body>
</html>