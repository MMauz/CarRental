package by.it.project.java;

import by.it.project.java.beans.Car;
import by.it.project.java.dao.CarDAO;
import by.it.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandIndex implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String resultPage = Action.INDEX.inPage;

        CarDAO carDAO = DAO.getDAO().getCarDAO();
        List<Car> cars = carDAO.getAll("");
        request.setAttribute("ListCars", cars);

        return resultPage;
    }
}
