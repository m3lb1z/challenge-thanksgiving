package dev.emrx.thanksgiving.domain;

import java.util.UUID;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto que representa la respuesta de un plato")
public record DishResponse(
    @Schema(description = "El ID único del plato", example = "7001fa2e-5dd2-4c53-8d0d-f5e0bb8ef97f")
    UUID id,

    @Schema(description = "El nombre del plato", example = "Traditional Roast Turkey")
    String name,

    @Schema(description = "El tipo de comida del plato", example = "PLATO_PRINCIPAL")
    String foodType,

    @Schema(description = "El nombre del chef que prepara el plato", example = "Julia Child")
    String chef,

    @Schema(description = "Descripción detallada del plato", example = "Pavo asado clásico relleno con hierbas aromáticas y mantequilla")
    String description
) {}
