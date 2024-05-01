import by.pack.configuration.WebConfiguration;
import by.pack.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = WebConfiguration.class)
@RunWith(SpringRunner.class)
public class TestBookDescription {



    @Autowired
    BookService bookService;



    @Test
    public void testDescription(){
       bookService.readAndSaveDescription();
    }
}
