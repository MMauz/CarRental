<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<main>
    <div class="container">
        <legend>Заказ оформлен</legend>
        <p>Имя клиента:<b> ${user.login}</b></p>
        <p>Автомобиль:<b>   ${car.brand} ${car.model}</b></p>
        <p>Начало аренды:<b> ${order.startRent}</b></p>
        <p>Окончание аренды:<b> ${order.endRent}</b></p>
        <p>Стоимость аренды:<b> ${order.totalCost}</b></p>
    </div>
</main>

<%@ include file="include/end-html.jsp" %>