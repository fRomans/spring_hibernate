package hiber;

import hiber.config.AppConfig;
//import hiber.model.Car;
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
      Car car1 = new Car("bmw",1,"111");
      Car car3 = new Car("bmw",3,"333");
      Car car5 = new Car("bmw",5,"555");
      Car car7 = new Car("bmw",7,"777");


      userService.add(new User("User1", "Lastname1", "user1@mail.ru",car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",car3));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru",car5));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",car7));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("car = "+user.toString());
         System.out.println();
      }
     Car car = userService.getUserByNumberAndSeries("333",3);
      System.out.println("тачка по номеру и серии- " + car.toString());
      context.close();
   }
}
