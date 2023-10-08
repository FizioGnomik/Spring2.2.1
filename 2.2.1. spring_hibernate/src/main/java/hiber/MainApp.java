package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Дмитрий", "Lastname1", "user1@mail.ru");
      User user2 = new User("Иван", "Lastname2", "user2@mail.ru");
      User user3 = new User("Сергей", "Lastname3", "user3@mail.ru");
      User user4 = new User("Евгений", "Lastname4", "user4@mail.ru");

      Car car1 = new Car("car1", 1);
      Car car2 = new Car("car2", 2);
      Car car3 = new Car("car3", 3);
      Car car4 = new Car("car4", 4);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));

      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
      }

      System.out.println(userService.getUserByCar("car3", 3));

      context.close();
   }
}
