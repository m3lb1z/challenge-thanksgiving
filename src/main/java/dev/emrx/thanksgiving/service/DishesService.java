package dev.emrx.thanksgiving.service;

import dev.emrx.thanksgiving.model.Dishes;
import dev.emrx.thanksgiving.repository.DishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DishesService {

    @Autowired
    private DishesRepository dishesRepository;

    public Dishes createDish(Dishes dish) {
        return dishesRepository.save(dish);
    }

    public List<Dishes> getAllDishes() {
        return dishesRepository.findAll();
    }

    public Dishes getDishById(UUID id) {
        return dishesRepository.findById(id).orElse(null);
    }

    public Dishes updateDish(UUID id, Dishes dishDetails) {
        Dishes dish = getDishById(id);
        if (dish != null) {
            dish.setName(dishDetails.getName());
            dish.setFoodType(dishDetails.getFoodType());
            dish.setChef(dishDetails.getChef());
            dish.setDescription(dishDetails.getDescription());
            return dishesRepository.save(dish);
        }
        return null;
    }

    public void deleteDish(UUID id) {
        dishesRepository.deleteById(id);
    }
}
