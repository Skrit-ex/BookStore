package by.pack.test;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.logging.Logger;

@RunWith(JUnit4.class)
public class InitializeTest {

    private static final Logger LOGGER = Logger.getLogger(InitializeTest.class.getName());
    HibernateBookTest hibernateBookTest = new HibernateBookTest();

    @Before
    public void setup() {
        LOGGER.info("startup");
        hibernateBookTest.initializerHibernateBookDao();
    }

        @Test
        public void init(){
        hibernateBookTest.testFindByNameBook();
    }

}
