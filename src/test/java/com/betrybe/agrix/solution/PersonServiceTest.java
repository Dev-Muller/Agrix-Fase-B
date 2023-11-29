package com.betrybe.agrix.solution;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.security.Role;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class PersonServiceTest {

  @Autowired
  PersonService personService;

  @MockBean
  PersonRepository personRepository;

  @Test
  public void testGetPersonById() {
    Person person = new Person();
    person.setId(1L);
    person.setUsername("Pedro");
    person.setPassword("2345678");
    person.setRole(Role.USER);

    Mockito.when(personRepository.findById(1L)).thenReturn(Optional.of(person));

    Person personById = personService.getPersonById(1L);

    Mockito.verify(personRepository).findById(1L);

    Assertions.assertEquals(person.getId(), personById.getId());
  }

  @Test
  public void testGetPersonByIdNotFound() {
    Mockito.when(personRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.empty());

    Assertions.assertThrows(PersonNotFoundException.class, () -> {
      personService.getPersonById(1L);
    });
  }

  @Test
  public void testGetPersonByUsername() {
    Person person = new Person();
    person.setId(1L);
    person.setUsername("Pedro");
    person.setPassword("2345678");
    person.setRole(Role.USER);

    Mockito.when(personRepository.findByUsername("Pedro")).thenReturn(Optional.of(person));

    Person personByUsername = personService.getPersonByUsername("Pedro");

    Mockito.verify(personRepository).findByUsername("Pedro");

    Assertions.assertEquals(person.getUsername(), personByUsername.getUsername());
  }

  @Test
  public void testGetPersonByUsernameNotFound() {
    Mockito.when(personRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(Optional.empty());

    Assertions.assertThrows(PersonNotFoundException.class, () -> {
      personService.getPersonByUsername("Pedro");
    });
  }

  @Test
  public void testCreate() {
    Person person = new Person();
    person.setId(1L);
    person.setUsername("Pedro");
    person.setPassword("2345678");
    person.setRole(Role.USER);

    Mockito.when(personRepository.save(person)).thenReturn(person);

    Person createdPerson = personService.create(person);

    Mockito.verify(personRepository).save(person);

    Assertions.assertEquals(person.getId(), createdPerson.getId());
  }

}
