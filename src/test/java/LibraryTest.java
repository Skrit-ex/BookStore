import by.pack.controller.LibraryController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {

    @Mock
    private LibraryController libraryController;

    @InjectMocks
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(libraryController).build();
    }


    @Test
    public void testController() throws Exception {
        String nameBook = "TestBook";
        String nameAuthor = "TestNa qmeAuthor";

        mockMvc.perform(get("/search"))
                .param("nameBook", nameBook)
                .param("nameAuthor", nameAuthor)
                .andExpect(status().isOk())
                .andExpect(view().name("library"))
                .andExpect(model().attribute("nameBook", nameBook))
                .andExpect(model().attribute("nameAuthor", nameAuthor));
    }
}
