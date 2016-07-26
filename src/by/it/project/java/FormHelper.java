package by.it.project.java;


import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс с утилитами для работы с формами
 */
public class FormHelper {
    private HttpServletRequest request;

    public FormHelper(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Метод определяет типа запроса (POST или нет)
     *
     * @return true(post)/false(not post)
     */
    public boolean isPost() {
        return request.getMethod().equalsIgnoreCase("post");
    }

    /**
     * Метод проверяет данные на валидность и соответствие шаблону
     *
     * @param data  данные
     * @param regex шаблон
     * @return true (вылидны)
     */
    private boolean validData(String data, String regex) {
        if (data == null) {
            return false;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод возвращает валидное значение-строку параметра
     *
     * @param nameFieldForm название параметра
     * @return валидное значение
     * @throws Exception
     */
    public String getString(String nameFieldForm) throws Exception {
        String value = request.getParameter(nameFieldForm);
        boolean isValid = validData(value, ".*");
        if (isValid) {
            return value;
        } else {
            throw new Exception("Данные не валидны: это не строка");
        }
    }

    /**
     * Метод возвращает валидное значение-число по названию параметра
     *
     * @param nameFieldForm название параметра
     * @return значение-число
     * @throws Exception
     */
    public Integer getInt(String nameFieldForm) throws Exception {
        String value = request.getParameter(nameFieldForm);
        boolean res = (value != null && validData(value, "^(([1-9]*)|(([1-9]*),([0-9]*)))$"));
        if (res) {
            return Integer.parseInt(value);
        } else
            throw new Exception("Данные не валидны: это не число");
    }

    //это экземплярный метод для отладки. Он покажет в виде текста, что пришло из формы
    //пока приватный, но вполне может быть и публичным
    public String strDebugForm() {
        String formText = "";
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String field = parameterNames.nextElement();
            String value = request.getParameter(field);
            formText = formText.concat(field + "=" + value + "; ");
        }
        return formText;
    }

}
