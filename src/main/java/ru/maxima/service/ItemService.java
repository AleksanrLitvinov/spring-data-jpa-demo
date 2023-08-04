package ru.maxima.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.models.Item;
import ru.maxima.models.Person;
import ru.maxima.repositories.ItemRepositories;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepositories itemRepositories;

    @Autowired
    public ItemService(ItemRepositories itemRepositories) {
        this.itemRepositories = itemRepositories;
    }

    public List<Item> findAll() {
        return itemRepositories.findAll();
    }

    public Item findById(Long id) {
        return itemRepositories.findById(id).orElse(null);
    }

    @Transactional
    public void save(Item item) {
        itemRepositories.save(item);
    }


    @Transactional
    public void update(Long id, Item itemFromForm) {
        itemFromForm.setId(id);
        itemRepositories.save(itemFromForm);
    }

    @Transactional
    public void delete(Long id) {
        itemRepositories.deleteById(id);
    }

    public Item findAllByItemName(String name) {
        return itemRepositories.findAllByItemName(name);
    }

    public Item findByOwner(Person owner) {
        return itemRepositories.findByOwner(owner);
    }

    public List<Item> findAllByItemNameStartsWith(String name){
        return itemRepositories.findAllByItemNameStartsWith(name);
    }
    public List<Item> findAllByItemNameEndingWith(String name){
        return itemRepositories.findAllByItemNameEndingWith(name);
    }
    public List<Item> findDistinctByItemName(String name){
        return itemRepositories.findDistinctByItemName(name);
    }
    public List<Item> findAllOrderByItemName(String s){
        return itemRepositories.findAllOrderByItemName(s);
    }
    public List<Item> findAllByOrderByOwnerAsc(){
        return itemRepositories.findAllByOrderByOwnerAsc();
    }

}
