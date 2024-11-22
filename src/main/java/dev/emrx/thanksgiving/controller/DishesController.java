package dev.emrx.thanksgiving.controller;

import dev.emrx.thanksgiving.domain.CreateDishRequest;
import dev.emrx.thanksgiving.domain.DishResponse;
import dev.emrx.thanksgiving.domain.UpdateDishRequest;
import dev.emrx.thanksgiving.service.DishesService;
import jakarta.validation.Valid;

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
    public ResponseEntity<DishResponse> createDish(@RequestBody @Valid CreateDishRequest request, UriComponentsBuilder uriBuilder) {
        DishResponse createdDish = dishesService.createDish(request);
        if (createdDish != null) {
            URI location = uriBuilder.path("/dishes/{id}").buildAndExpand(createdDish.id()).toUri();
            return ResponseEntity.created(location).body(createdDish);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<DishResponse>> getAllDishes() {
        return ResponseEntity.ok(dishesService.getAllDishes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DishResponse> getDishById(@PathVariable UUID id) {
        DishResponse dish = dishesService.getDishById(id);
        if (dish != null) {
            return ResponseEntity.ok(dish);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DishResponse> updateDish(@PathVariable UUID id, @RequestBody @Valid UpdateDishRequest request) {
        DishResponse updatedDish = dishesService.updateDish(id, request);
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
