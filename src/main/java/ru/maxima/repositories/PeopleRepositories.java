package ru.maxima.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxima.models.Person;

import java.util.List;

@Repository
public interface PeopleRepositories extends JpaRepository<Person, Long> {
    List<Person> findAllByName(String name);
    List<Person> findAllOrderByEmail(String email);
    Person findAllByNameStartingWith(String start);
    List<Person> findByNameOrEmail(String name, String email);

//    Написать по 5 оригинальных методов на каждый репозиторий и проверить их работоспособность.


    List<Person> findAllByNameContains(String name);
    List<Person> findAllByOrderByAge();
    Person findByAge(int age);
    List<Person> findAllByOrderByEmail();
    Person findAllByEmailEndingWith(String start);



}
