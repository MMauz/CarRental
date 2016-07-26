package by.it.project.java;


import by.it.project.java.beans.Car;
import by.it.project.java.beans.Order;
import by.it.project.java.beans.User;
import by.it.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;


public class CommandAddOrder implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String resultPage = Action.ADDORDER.inPage;
        FormHelper formHelper = new FormHelper(request);

        /**
         * Проверка авторизации пользователя, если не авторизован, отправляется на страницу авторизации
         * done!
         */
        User user = (User) request.getSession(true).getAttribute("user");
        if (user == null) {
            request.setAttribute(Action.msgMessage, "Для заказа авто нужно авторизоваться");
            return Action.SIGNIN.inPage;
        }

        /**
         * Получение car из атрибута idCar Integer.parseInt(request.getParameter("idCar"))
         */
        Car car = DAO.getDAO().getCarDAO().read(Integer.parseInt(request.getParameter("idCar")));
        request.setAttribute("car", car);

        if (formHelper.isPost()) {
            /**
             * Создание заказа
             */
            Order order = new Order();
            order.setFk_user(user.getId());
            order.setFk_car(car.getId());

            /**
             * Формат для календаря yyyy-MM-dd hh:mm:ss (+tt for AM/PM)
             */
            order.setStartRent(Timestamp.valueOf(request.getParameter("start")));
            order.setEndRent(Timestamp.valueOf(request.getParameter("end")));

            /**
             * Общая стоимость = время_аренды (сутки) * стоимость_аренды (в сутки)
             */
            long totalCost = ((order.getEndRent().getTime() - order.getStartRent().getTime()) / 1000) / (60 * 60 * 24);
            order.setTotalCost((int) totalCost * car.getCost());

            if (DAO.getDAO().getOrderDAO().create(order)) {
                request.setAttribute("order", order);
                request.setAttribute(Action.msgMessage, "Заказ оформлен");
                resultPage = Action.ADDORDER.okPage;
            } else {
                request.setAttribute(Action.msgMessage, "Заказ не оформлен");
                resultPage = Action.ADDORDER.inPage;
            }
        }

        return resultPage;
    }
}
