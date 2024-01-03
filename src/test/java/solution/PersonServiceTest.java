package solution;

import com.betrybe.agrix.AgrixApplication;
import com.betrybe.agrix.models.entities.Person;
import com.betrybe.agrix.security.Role;
import com.betrybe.agrix.services.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = AgrixApplication.class)
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
public class PersonServiceTest {
  @Autowired
  private PersonService personService;
  private Person initialPerson;

  @BeforeAll
  public void setUp() {
    initialPerson = new Person();
    initialPerson.setUsername("newuser");
    initialPerson.setPassword("123456");
    initialPerson.setRole(Role.ADMIN);
  }

  @Test
  @DisplayName("Test Create Person")
  public void testCreatePerson() {
    Person returnedPerson = personService.create(initialPerson);

    Assertions.assertEquals(returnedPerson.getId(), initialPerson.getId());
    Assertions.assertEquals(returnedPerson.getUsername(), initialPerson.getUsername());
    Assertions.assertEquals(returnedPerson.getPassword(), initialPerson.getPassword());
    Assertions.assertEquals(returnedPerson.getRole(), initialPerson.getRole());
  }

  @Test
  @DisplayName("Test Get Person by Id")
  public void testPersonById() {
    Long personId = personService.create(initialPerson).getId();
    Person returnedPerson = personService.getPersonById(personId);

    Assertions.assertEquals(returnedPerson.getId(), initialPerson.getId());
    Assertions.assertEquals(returnedPerson.getUsername(), initialPerson.getUsername());
    Assertions.assertEquals(returnedPerson.getPassword(), initialPerson.getPassword());
    Assertions.assertEquals(returnedPerson.getRole(), initialPerson.getRole());
  }

  @Test
  @DisplayName("Test Get Person by Username")
  public void testPersonByUsername() {
    String personUsername = personService.create(initialPerson).getUsername();
    Person returnedPerson = personService.getPersonByUsername(personUsername);

    Assertions.assertEquals(returnedPerson.getId(), initialPerson.getId());
    Assertions.assertEquals(returnedPerson.getUsername(), initialPerson.getUsername());
    Assertions.assertEquals(returnedPerson.getPassword(), initialPerson.getPassword());
    Assertions.assertEquals(returnedPerson.getRole(), initialPerson.getRole());
  }
}
