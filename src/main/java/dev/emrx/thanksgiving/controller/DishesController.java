package dev.emrx.thanksgiving.controller;

import dev.emrx.thanksgiving.domain.CreateDishRequest;
import dev.emrx.thanksgiving.domain.DishResponse;
import dev.emrx.thanksgiving.domain.UpdateDishRequest;
import dev.emrx.thanksgiving.infra.validation.DataErrorValidation;
import dev.emrx.thanksgiving.service.DishesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Crear un plato", description = "Crea un nuevo plato para la cena de Acción de Gracias")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Plato creado"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida", content = @Content(schema = @Schema(implementation = DataErrorValidation.class)))
    })
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

    @Operation(summary = "Obtener todos los platos", description = "Devuelve una lista de todos los platos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de platos obtenida"),
        @ApiResponse(responseCode = "204", description = "No hay contenido", content = @Content(schema = @Schema(implementation = Void.class)))
    })
    @GetMapping
    public ResponseEntity<List<DishResponse>> getAllDishes() {
        List<DishResponse> dishes = dishesService.getAllDishes();
        if (dishes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dishes);
    }

    @Operation(summary = "Obtener un plato por ID", description = "Devuelve un plato específico por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Plato encontrado"),
        @ApiResponse(responseCode = "404", description = "Plato no encontrado", content = @Content(schema = @Schema(implementation = Void.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<DishResponse> getDishById(@PathVariable UUID id) {
        DishResponse dish = dishesService.getDishById(id);
        if (dish != null) {
            return ResponseEntity.ok(dish);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Actualizar un plato", description = "Actualiza un plato existente por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Plato actualizado"),
        @ApiResponse(responseCode = "404", description = "Plato no encontrado", content = @Content(schema = @Schema(implementation = DataErrorValidation.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<DishResponse> updateDish(@PathVariable UUID id, @RequestBody @Valid UpdateDishRequest request) {
        DishResponse updatedDish = dishesService.updateDish(id, request);
        if (updatedDish != null) {
            return ResponseEntity.ok(updatedDish);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar un plato", description = "Elimina un plato existente por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Plato eliminado"),
        @ApiResponse(responseCode = "404", description = "Plato no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable UUID id) {
        dishesService.deleteDish(id);
        return ResponseEntity.noContent().build();
    }
}
