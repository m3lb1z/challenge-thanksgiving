package dev.emrx.thanksgiving.repository;

import dev.emrx.thanksgiving.model.Dishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DishesRepository extends JpaRepository<Dishes, UUID> {
    // No es necesario añadir métodos adicionales ya que JpaRepository ya proporciona los métodos CRUD básicos.
}
