


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/customstyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<div class="header_menu mb-5">
    <div class="row justify-content-center align-items-center g-0">
        <div class="col-11 col-md-10 px-3">
            <div class="d-flex justify-content-between mx-3">
                <ul class="list-unstyled d-flex">
                    <li><a href="index.jsp">Home</a></li>
                </ul>
                <ul class="list-unstyled d-flex">
                    <c:choose>
                        <c:when test="${sessionScope.account.check == 0}">
                            <li class="text-warning">Welcome <strong>${sessionScope.account.usr}</strong></li>
                            <c:if test="${sessionScope.account.role == 0}">
                                <li><a href="AccountList">Admin</a></li>
                            </c:if>
                            <li><a href="Logout">Logout</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="login.jsp">Login</a></li>
                            <li><a href="registry.jsp">Registry</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </div>
</div>