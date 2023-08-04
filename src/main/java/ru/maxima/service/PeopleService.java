package ru.maxima.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.models.Person;
import ru.maxima.repositories.PeopleRepositories;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PeopleRepositories peopleRepositories;

    @Autowired
    public PeopleService(PeopleRepositories peopleRepositories) {
        this.peopleRepositories = peopleRepositories;
    }

    public List<Person> findAll(){
        return peopleRepositories.findAll();
    }

    public Person findById(Long id) {
        return peopleRepositories.findById(id).orElse(null);
    }

    @Transactional
    public void save(Person person) {
        peopleRepositories.save(person);
    }


    @Transactional
    public void update(Long id,Person personFromForm) {
        personFromForm.setId(id);
        peopleRepositories.save(personFromForm);
    }
    @Transactional
    public void delete(Long id) {
        peopleRepositories.deleteById(id);
    }

//    List<Person> findAllByName(String name);
//    List<Person> findAllByOrderByEmail(String email);
//    Person findAllByNameStartingWith(String start);
//    List<Person> findByNameOrEmail(String name, String email);

    public List<Person> findAllByName(String name) {
        return peopleRepositories.findAllByName(name);
    }

    public List<Person> findAllOrderByEmail(String email) {
        return peopleRepositories.findAllOrderByEmail(email);
    }
    public Person findAllByNameStartingWith(String start) {
        return peopleRepositories.findAllByNameStartingWith(start);
    }
    public List<Person> findByNameOrEmail(String name, String email) {
        return peopleRepositories.findByNameOrEmail(name, email);
    }



    public List<Person> findAllByNameContains(String name) {
        return peopleRepositories.findAllByNameContains(name);
    }

    public List<Person> findAllByOrderByAge() {
        return peopleRepositories.findAllByOrderByAge();
    }


    public Person findByAge(int id) {
        return peopleRepositories.findByAge(id);
    }

    public List<Person> findAllByOrderByEmail() {
        return peopleRepositories.findAllByOrderByEmail();
    }

    public Person findAllByEmailEndingWith(String start) {
        return peopleRepositories.findAllByEmailEndingWith(start);
    }







}
