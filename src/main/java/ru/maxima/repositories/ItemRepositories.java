package ru.maxima.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxima.models.Item;
import ru.maxima.models.Person;

@Repository
public interface ItemRepositories extends JpaRepository<Item, Long> {

    Item findAllByItemName(String name);
    Item findByOwner(Person owner);








}
