package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.CreateItem;
import com.farmingweb.farmingwebsite.entities.CreateItemId;
import com.farmingweb.farmingwebsite.services.CreateItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/api/createitems")
public class CreateItemController {
    @Autowired
    private CreateItemService createitemService;

    @GetMapping
    public List<CreateItem> getAll() {
        return createitemService.getAll();
    }

    @PostMapping
    public CreateItem create(@RequestBody CreateItem createitem) {
        return createitemService.create(createitem);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable CreateItemId id) {
        createitemService.delete(id);
    }
}
