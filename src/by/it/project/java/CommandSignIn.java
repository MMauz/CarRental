package by.it.project.java;

import by.it.project.java.beans.User;
import by.it.project.java.dao.DAO;
import by.it.project.java.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandSignIn implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        //страница для отправки пользователю
        String resultPage = Action.SIGNIN.inPage;
        //объект для работы с данным запроса (request)
        FormHelper formHelper = new FormHelper(request);

        /**
         * Проверка отправки данных из форм, если данные из формы пришли,
         * обрабатываем их, иначе отправляем страницу с вводом данных и
         * сообщение о вводе данных
         */
        if (formHelper.isPost()) {
            try {
                //логин
                String login = formHelper.getString("Login");
                //пароль
                String password = formHelper.getString("Password");

                UserDAO userDAO = DAO.getDAO().getUserDAO();
                User user = userDAO.getUserByAuthorization(login, password);

                /**
                 * Если пользователь с такими данными существует, создаем для него сессию
                 * и отправляем страницу успешной авторизации, иначе отправка на страницу авторизации
                 */
                if (user != null) {
                    HttpSession userSession = request.getSession(true);
                    userSession.setAttribute("user", user);
                    request.setAttribute(Action.msgMessage, "Добро пожаловать, " + user.getLogin());
                    resultPage = Action.SIGNIN.okPage;
                } else {
                    request.setAttribute(Action.msgMessage, "Пользователя с такими данными не существует");
                    resultPage = Action.SIGNIN.inPage;
                }
            } catch (Exception e) {
                request.setAttribute(Action.msgMessage, "Неверные данные");
            }
        } else {
            request.setAttribute(Action.msgMessage, "Введите данные для авторизации");
            resultPage = Action.SIGNIN.inPage;
        }
        return resultPage;
    }
}