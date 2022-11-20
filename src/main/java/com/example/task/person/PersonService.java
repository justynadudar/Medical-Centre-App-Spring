package com.example.task.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addPerson(Person person) {
        Optional<Person> personOptional = personRepository.findPersonByEmail(person.getEmail());
        if (personOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        personRepository.save(person);
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findPersonById(id).orElseThrow(() -> new IllegalStateException("Person with id " + id + " does not exists"));
    }

    public void deletePerson(Long id) {
        personRepository.findPersonById(id).orElseThrow(() -> new IllegalStateException("Person with id " + id + " does not exists"));
        personRepository.deleteById(id);
    }

    public void updatePerson(Long id, Person person) {
        personRepository.findById(id).orElseThrow(() -> new IllegalStateException("Person with id " + id + " does not exists"));
        person.setId(id);
        personRepository.save(person);
    }

}
