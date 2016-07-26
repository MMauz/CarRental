<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<main>
    <div class="container">
        <form class="form-horizontal" action="do?command=SignUp" method="POST">
            <fieldset>

                <!-- Form Name -->
                <legend>Регистрация нового пользователя</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="Login">Логин</label>
                    <div class="col-md-4">
                        <input id="Login" name="Login" type="text" placeholder=""
                               class="form-control input-md" required>

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="Email">E-mail</label>
                    <div class="col-md-4">
                        <input id="Email" name="Email" type="text" placeholder=""
                               class="form-control input-md" required>

                    </div>
                </div>

                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="Password">Пароль</label>
                    <div class="col-md-4">
                        <input id="Password" name="Password" type="password" placeholder=""
                               class="form-control input-md" required>

                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="btn"></label>
                    <div class="col-md-4">
                        <button id="btn" name="btn" class="btn btn-primary">Зарегистрировать</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</main>

<%@ include file="include/end-html.jsp" %>


