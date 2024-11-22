package dev.emrx.thanksgiving.service;

import dev.emrx.thanksgiving.domain.CreateDishRequest;
import dev.emrx.thanksgiving.domain.DishResponse;
import dev.emrx.thanksgiving.domain.UpdateDishRequest;
import dev.emrx.thanksgiving.model.Dishes;
import dev.emrx.thanksgiving.repository.DishesRepository;
import jakarta.transaction.Transactional;
import dev.emrx.thanksgiving.mapper.DishMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DishesService {

    private final DishesRepository dishesRepository;
    private final DishMapper dishMapper;

    public DishesService(DishesRepository dishesRepository, DishMapper dishMapper) {
        this.dishesRepository = dishesRepository;
        this.dishMapper = dishMapper;
    }

    private Dishes _getDishById(UUID id) {
        return dishesRepository.findById(id).orElse(null);
    }

    @Transactional
    public DishResponse createDish(CreateDishRequest request) {
        Dishes dish = dishMapper.toEntity(request);
        Dishes savedDish = dishesRepository.save(dish);
        return dishMapper.toResponse(savedDish);
    }

    public List<DishResponse> getAllDishes() {
        return dishesRepository.findAll().stream()
                .map(dishMapper::toResponse)
                .toList();
    }

    public DishResponse getDishById(UUID id) {
        Dishes dish = _getDishById(id);
        return dish != null ? dishMapper.toResponse(dish) : null;
    }

    @Transactional
    public DishResponse updateDish(UUID id, UpdateDishRequest request) {
        Dishes dish = _getDishById(id);
        if (dish != null) {
            dish = dishMapper.updateEntity(dish, request);
            Dishes updatedDish = dishesRepository.save(dish);
            return dishMapper.toResponse(updatedDish);
        }
        return null;
    }

    @Transactional
    public void deleteDish(UUID id) {
        dishesRepository.deleteById(id);
    }
}
