package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        User u1 = new User("User1", "Lastname2", "user1@mail.ru");
        Car c1 = new Car("BMW", 777);
        c1.setUser(u1);
        u1.setCar(c1);

        User u2 = new User("User2", "Lastname2", "user2@mail.ru");
        Car c2 = new Car("Medd", 999);
        c2.setUser(u2);
        u2.setCar(c2);

        User u3 = new User("User3", "Lastname3", "user3@mail.ru");
        Car c3 = new Car("KKK", 555);
        c3.setUser(u3);
        u3.setCar(c3);

        User u4 = new User("User4", "Lastname4", "user4@mail.ru");
        Car c4 = new Car("OOO", 222);
        c4.setUser(u4);
        u4.setCar(c4);

        userService.add(u1, c1);
        userService.add(u2, c2);
        userService.add(u3, c3);
        userService.add(u4, c4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("User" + "                         " + "Car");
            System.out.println("Id = " + user.getId() + "                        " + user.getCar().getId());
            System.out.println("First Name = " + user.getFirstName() + "           " + user.getCar().getModel());
            System.out.println("Last Name = " + user.getLastName() + "        " + user.getCar().getSeries());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        System.out.println(carService.getUserForCar(c1));
        System.out.println(carService.getUserForCar(c2));
        System.out.println(carService.getUserForCar(c3));
        System.out.println(carService.getUserForCar(c4));

        context.close();
    }
}
