<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<main>
    <div class="container">
        <form class="form-horizontal" action="do?command=SignOut" method="POST">

            <p>Ваш логин:<b> ${ProfileLogin}</b></p>
            <hr>
            <p>Ваш e-mail:<b> ${ProfileEmail}</b></p>
            <hr>
            <p>Данные из cookies:<b> ${DataCookies}</b></p>
            <hr>

            <fieldset>

                <!-- Form Name -->
                <legend>Вы хотите завершенить сеанс?</legend>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="LogoutButton"></label>
                    <div class="col-md-4">
                        <button id="LogoutButton" name="LogoutButton" value="1" class="btn btn-success">Да, завершить.
                        </button>
                    </div>
                </div>

            </fieldset>
        </form>
    </div>
</main>

<%@ include file="include/end-html.jsp" %>