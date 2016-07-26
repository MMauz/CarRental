package by.it.project.java;

enum Action {
    //регистрация
    SIGNUP {
        {
            this.command = new CommandSignUp();
            this.inPage = "/signup.jsp";
            this.okPage = "/signin.jsp";
        }
    },
    //авторизация
    SIGNIN {
        {
            this.command = new CommandSignIn();
            this.inPage = "/signin.jsp";
            this.okPage = "/index.jsp";
        }
    },
    //завершить сессию
    SIGNOUT {
        {
            this.command = new CommandSignOut();
            this.inPage = "/signout.jsp";
            this.okPage = "/signin.jsp";
        }
    },
    //главная страница
    INDEX {
        {
            this.command = new CommandIndex();
            this.inPage = "/index.jsp";
            this.okPage = "/order.jsp";
        }
    },
    //показать всех пользователей в кабинете администратора
    SHOWALLUSERS {
        {
            this.command = new CommandShowAllUsers();
            this.inPage = "/admincab.jsp";
            this.okPage = "/admincab.jsp";
        }
    },
    //добавление заказа
    ADDORDER {
        {
            this.command = new CommandAddOrder();
            this.inPage = "/order.jsp";
            this.okPage = "/orderok.jsp";
        }
    },
    //
    ERROR {
        {
            this.command = new CommandSignOut();
        }
    };
    public String inPage = "/error.jsp";
    public String okPage = "/error.jsp";
    public ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }

    public static final String msgError = "msg_error";
    public static final String msgMessage = "message";

}