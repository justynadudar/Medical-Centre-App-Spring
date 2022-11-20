package com.example.task.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(path = "add")
    public void addPerson(@RequestBody @Valid Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping(path = "delete/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "edit/{id}")
    public void updatePerson(@PathVariable Long id, @RequestBody Person person) {
        personService.updatePerson(id, person);
    }

}
