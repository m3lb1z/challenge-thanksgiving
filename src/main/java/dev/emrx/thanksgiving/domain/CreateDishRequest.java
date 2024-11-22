package dev.emrx.thanksgiving.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto que representa una solicitud para crear un plato")
public record CreateDishRequest(
    @NotBlank(message = "El nombre del plato no puede estar vacío")
    @Size(max = 100, message = "El nombre del plato no puede exceder los 100 caracteres")
    @Schema(description = "El nombre del plato", example = "Deviled Eggs")
    String name,

    @NotBlank(message = "El tipo de comida no puede estar vacío")
    @Pattern(regexp = "APERITIVO|PLATO_PRINCIPAL|GUARNICION|POSTRE|BEBIDA", message = "El tipo de comida debe ser uno de los siguientes: APERITIVO, PLATO_PRINCIPAL, GUARNICION, POSTRE, BEBIDA")
    @Schema(description = "El tipo de comida del plato", example = "APERITIVO")
    String foodType,

    @NotBlank(message = "El nombre del chef no puede estar vacío")
    @Size(max = 100, message = "El nombre del chef no puede exceder los 100 caracteres")
    @Schema(description = "El nombre del chef que prepara el plato", example = "Martha Stewart")
    String chef,

    @Size(max = 1000, message = "La descripción no puede exceder los 1000 caracteres")
    @Schema(description = "Descripción detallada del plato", example = "Huevos rellenos tradicionales con mayonesa, mostaza y pimentón")
    String description
) {}
