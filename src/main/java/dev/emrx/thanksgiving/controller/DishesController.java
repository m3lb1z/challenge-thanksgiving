package dev.emrx.thanksgiving.controller;

import dev.emrx.thanksgiving.model.Dishes;
import dev.emrx.thanksgiving.service.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dishes")
public class DishesController {

    @Autowired
    private DishesService dishesService;

    @PostMapping
    public ResponseEntity<Dishes> createDish(@RequestBody Dishes dish, UriComponentsBuilder uriBuilder) {
        Dishes createdDish = dishesService.createDish(dish);
        if (createdDish != null) {
            URI location = uriBuilder.path("/dishes/{id}").buildAndExpand(createdDish.getId()).toUri();
            return ResponseEntity.created(location).body(createdDish);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Dishes>> getAllDishes() {
        return ResponseEntity.ok(dishesService.getAllDishes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dishes> getDishById(@PathVariable UUID id) {
        Dishes dish = dishesService.getDishById(id);
        if (dish != null) {
            return ResponseEntity.ok(dish);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dishes> updateDish(@PathVariable UUID id, @RequestBody Dishes dishDetails) {
        Dishes updatedDish = dishesService.updateDish(id, dishDetails);
        if (updatedDish != null) {
            return ResponseEntity.ok(updatedDish);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable UUID id) {
        dishesService.deleteDish(id);
        return ResponseEntity.noContent().build();
    }
}
