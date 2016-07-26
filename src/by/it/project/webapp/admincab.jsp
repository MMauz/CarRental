<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<main>
    <div class="container">
        <form class="form-horizontal" action="do?command=ShowAllUsers" method="POST">
            <p>Здесь будет список всех пользователей</p>
            <p>${ListUsers}</p>
        </form>
    </div>
</main>
<%@ include file="include/end-html.jsp" %>