package by.pack.test;

import by.pack.configuration.WebConfiguration;
import by.pack.dao.HibernateUserDao;
import by.pack.dto.RegUserDto;
import by.pack.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebConfiguration.class)
public class TestUserDao {


    private HibernateUserDao hibernateUserDao;

    @Before
    public void setup(){
        hibernateUserDao = new HibernateUserDao();
    }

    private final static Logger LOGGER = Logger.getLogger(TestUserDao.class.getName());

    @Test
    public void testFindByEmail() {
        RegUserDto regUserDto = new RegUserDto();
        regUserDto.setEmail("Sa2@gmail.com");
        Optional<User> byUserEmail = hibernateUserDao.findByEmail(regUserDto.getEmail());
        if (byUserEmail.isPresent()) {
            User user = byUserEmail.get();
            LOGGER.info("Your email exist");
            System.out.println(user.getEmail());
        }else {
            System.out.println("Your email isn't correct or not exist");
        }
    }
}
