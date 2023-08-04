package ru.maxima.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.maxima.models.Person;
import ru.maxima.service.ItemService;
import ru.maxima.service.PeopleService;


@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    private final ItemService itemService;

    @Autowired
    public PeopleController(PeopleService peopleService, ItemService itemService) {
        this.peopleService = peopleService;
        this.itemService = itemService;
    }

    @GetMapping()
    public String getPeople(Model model) {
        peopleService.findAllByName("A");
        peopleService.findAllOrderByEmail("T");
        peopleService.findAllByNameStartingWith("T");
        peopleService.findAllByNameStartingWith("T");

        itemService.findByOwner(peopleService.findById(1L));
        itemService.findAllByItemName("T");

        model.addAttribute("allPeople", peopleService.findAll());
        // model.addAttribute("allName", personDAO.searchByName());
        return "people/get-all-people";

    }

    @GetMapping("/{id}")
    public String getPersonById(@PathVariable Long id, Model model) {
        model.addAttribute("onePersonById", peopleService.findById(id));
        return "people/get-person";

    }

    @GetMapping("/new")
    public String getFromToCreatNewPerson(Model model) {
        model.addAttribute("newPerson", new Person());
        return "people/new-person";

    }

    @PostMapping()
    public String createPerson(@ModelAttribute("newPerson") @Valid Person person
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new-person";
        peopleService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String getFromToUpdateCurrentNewPerson(@PathVariable("id") Long id, Model model) {
        model.addAttribute("editPerson", peopleService.findById(id));
        return "people/edit-person";

    }

    @PatchMapping("/{id}")
    public String editPerson(@PathVariable("id") Long id
            , @ModelAttribute("editPerson") @Valid Person person
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/edit-person";
        peopleService.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        peopleService.delete(id);
        return "redirect:/people";
    }

}
