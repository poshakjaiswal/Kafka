package com.sap.learn.Kafka.controller;

// ItemController.java
import com.sap.learn.Kafka.DTO.Item;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final AtomicLong counter = new AtomicLong();
    private final List<Item> items = new ArrayList<>();

    @GetMapping
    public List<Item> getAllItems() {
        return items;
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable("id") long id) {
        for (Item item : items) {

            if (item.getId() == id) {
                return item;
            }
        }
        throw new RuntimeException("Item not found with id: " + id);
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        item.setId(counter.incrementAndGet());
        items.add(item);
        return item;
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable("id") long id, @RequestBody Item updatedItem) {
        for (Item item : items) {
            if (item.getId() == id) {
                item.setName(updatedItem.getName());
                item.setPrice(updatedItem.getPrice());
                return item;
            }
        }
        throw new RuntimeException("Item not found with id: " + id);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") long id) {
        items.removeIf(item -> item.getId() == id);
    }
}