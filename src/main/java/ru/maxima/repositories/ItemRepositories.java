package ru.maxima.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxima.models.Item;
import ru.maxima.models.Person;

import java.util.List;

@Repository
public interface ItemRepositories extends JpaRepository<Item, Long> {

    Item findAllByItemName(String name);
    Item findByOwner(Person owner);

    //    Написать по 5 оригинальных методов на каждый репозиторий и проверить их работоспособность.

     List<Item> findAllByItemNameStartsWith(String name);

     List<Item> findAllByItemNameEndingWith(String string);

     List<Item> findDistinctByItemName(String itemName);
    List<Item> findAllOrderByItemName(String s);

    List<Item> findAllByOrderByOwnerAsc();








}
