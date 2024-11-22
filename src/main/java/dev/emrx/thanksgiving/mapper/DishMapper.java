package dev.emrx.thanksgiving.mapper;

import dev.emrx.thanksgiving.domain.*;
import dev.emrx.thanksgiving.model.Dishes;
import org.springframework.stereotype.Component;

@Component
public class DishMapper {

    // Método para convertir de CreateDishRequest a Dishes
    public Dishes toEntity(CreateDishRequest request) {
        return Dishes.builder()
                .name(request.name())
                .foodType(Dishes.FoodType.valueOf(request.foodType().toUpperCase()))
                .chef(request.chef())
                .description(request.description())
                .build();
    }

    // Método para convertir de UpdateDishRequest a Dishes
    public Dishes updateEntity(Dishes entity, UpdateDishRequest request) {
        if (request.name() != null) entity.setName(request.name());
        if (request.foodType() != null) entity.setFoodType(Dishes.FoodType.valueOf(request.foodType().toUpperCase()));
        if (request.chef() != null) entity.setChef(request.chef());
        if (request.description() != null) entity.setDescription(request.description());

        return entity;
    }

    // Método para convertir de Dishes a DishResponse
    public DishResponse toResponse(Dishes entity) {
        return new DishResponse(
                entity.getId(),
                entity.getName(),
                entity.getFoodType().name(),
                entity.getChef(),
                entity.getDescription()
        );
    }
}
