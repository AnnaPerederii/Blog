package ua.od.atomspace.twitter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TwitterApplication.class)
@AutoConfigureMockMvc
@Sql(scripts = { "/test-schema.sql" }, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public abstract class BaseTest {
  @Autowired
  protected ObjectMapper mapper;

}
