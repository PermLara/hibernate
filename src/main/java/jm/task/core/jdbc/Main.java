package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        String testName = "Ivan";
        String testLastName = "Ivanov";
        byte testAge = 5;

        userService.dropUsersTable();
        System.out.println("дропнули");
        userService.createUsersTable();
        System.out.println("создали заново");

        User u5 = new User(testName, testLastName, testAge);
        userService.saveUser(u5.getName(), u5.getLastName(), u5.getAge());

        User user = userService.getAllUsers().get(0);

        if (!testName.equals(user.getName())
                || !testLastName.equals(user.getLastName())
                || testAge != user.getAge()
        ) {
            System.out.println("User был некорректно добавлен в базу данных");
        }

    }
}
