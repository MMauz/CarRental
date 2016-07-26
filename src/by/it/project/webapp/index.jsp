<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
    <div class="container">
        <div class="row">
            <div class="col-md-1">№</div>
            <div class="col-md-2">Brand</div>
            <div class="col-md-2">Model</div>
            <div class="col-md-2">Category</div>
            <div class="col-md-1">Cost</div>
            <div class="col-md-1">Consumption</div>
        </div>

        <% Integer i = 1; %>
        <c:forEach items="${ListCars}" var="car">
            <br/>
            <div class="row">
                <div class="col-md-1"><% out.print(i++); %></div>
                <div class="col-md-2">${car.brand}</div>
                <div class="col-md-2">${car.model}</div>
                <div class="col-md-2">${car.category}</div>
                <div class="col-md-1">${car.cost}</div>
                <div class="col-md-1">${car.consumption}</div>
                <div class=col-md-1>
                    <a href="do?command=AddOrder&idCar=${car.id}" class="btn btn-success" value="${car.id}">
                        Арендовать
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
</main>
<%@ include file="include/end-html.jsp" %>
