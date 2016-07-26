package by.it.project.java;

import by.it.project.java.beans.User;
import by.it.project.java.dao.DAO;
import by.it.project.java.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;

public class CommandSignUp implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String resultPage = Action.SIGNUP.inPage;

        String login = request.getParameter("Login");
        String password = request.getParameter("Password");
        String email = request.getParameter("Email");
        UserDAO userDAO = DAO.getDAO().getUserDAO();

        //проверка на ввод данных
        if (login == null || password == null || email == null) {
            request.setAttribute(Action.msgMessage, "Пользователь не создан. Заполните данные для регистрации.");
            return resultPage;
        }

        //проверка валидности и занятости логина
        FormHelper formHelper = new FormHelper(request);
        if (!(userDAO.getAll(String.format("where Login='%s'", login)).isEmpty())) {
            request.setAttribute(Action.msgMessage, "Пользователь не создан. Данный логин занят.");
            return resultPage;
        }

        //проверка валидности и занятости email
        if (!(userDAO.getAll(String.format("where Email='%s'", email)).isEmpty())) {
            request.setAttribute(Action.msgMessage, "Пользователь не создан. Данный email зарегистрирован.");
            return resultPage;
        }

        //создание пользовательского bean
        User user = new User();
        user.setId(0);
        user.setLogin(request.getParameter("Login"));
        user.setPassword(request.getParameter("Password")); //пароль нужно солить и хэшировать - проблема безопасности
        user.setEmail(request.getParameter("Email"));
        user.setFk_role(2);

        if (userDAO.create(user)) {
            request.setAttribute(Action.msgMessage, "Пользователь создан. Введите данные для авторизации.");
            resultPage = Action.SIGNUP.okPage;
        } else {
            request.setAttribute(Action.msgMessage, "Пользователь НЕ создан.");
            resultPage = Action.SIGNUP.inPage;
        }

        return resultPage;
    }
}