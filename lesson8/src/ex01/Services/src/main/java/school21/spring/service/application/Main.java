package school21.spring.service.application;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;
import school21.spring.service.repositories.UsersRepositoryJdbcImpl;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("context.xml");
//        UsersRepository usersRepositoryJdbc = applicationContext.getBean(
//                "usersRepositoryJdbcImpl",
//                UsersRepository.class
//        );
//        User user = new User(666L, "MEGAabobUS@aboba.com");
//        usersRepositoryJdbc.save(user);

        UsersRepository usersRepositoryJdbcTemplateImpl = applicationContext.getBean(
                "usersRepositoryJdbcTemplateImpl",
                UsersRepository.class
        );
        User user = new User(999L, "ULTRAMEGAabobUS@aboba.com");
        usersRepositoryJdbcTemplateImpl.save(user);
    }
}
