<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<main>
    <div class="container">

        <!-- Form Name -->
        <legend>Оформление заказа</legend>
        <p>Имя клиента:<b> ${user.login}</b></p>
        <p>Автомобиль:<b>   ${car.brand} ${car.model}</b></p>
        <p>Стоимость за сутки аренды:<b> ${car.cost}</b></p>
        <form class="form-horizontal" action="do?command=AddOrder&idCar=${car.id}" method="POST">
            <fieldset>
                <div class="row">
                    <!--Set start rental-->
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label for="start">Начало аренды</label>
                            <div class="input-group date" id="start">
                                <input type="text" class="form-control" name="start" required/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                    </div>
                    <!--Set end rental-->
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label for="end">Окончание аренды</label>
                            <div class="input-group date" id="end">
                                <input type="text" class="form-control" name="end" required/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Button -->
                <div class="form-group">
                    <div class="col-md-4">
                        <button class="btn btn-success" type="submit">Оформить заказ</button>
                    </div>
                </div>
            </fieldset>
        </form>


    </div>
</main>

<script type="text/javascript">
    $(function () {
        //Инициализация start и end
        $("#start").datetimepicker({
            format: 'YYYY-MM-DD hh:mm:ss'
        });
        $("#end").datetimepicker({
            format: 'YYYY-MM-DD hh:mm:ss'
        });
        //При изменении даты в start, она устанавливается как минимальная для end
        $("#start").on("dp.change", function (e) {
            $("#end").data("DateTimePicker").setMinDate(e.date);
        });
        //При изменении даты в end, она устанавливается как максимальная для start
        $("#end").on("dp.change", function (e) {
            $("#start").data("DateTimePicker").setMaxDate(e.date);
        });
    });
</script>

<%@ include file="include/end-html.jsp" %>