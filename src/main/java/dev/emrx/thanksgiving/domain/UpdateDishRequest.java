package dev.emrx.thanksgiving.domain;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto que representa una solicitud para actualizar un plato")
public record UpdateDishRequest(
    @Size(max = 100, message = "El nombre del plato no puede exceder los 100 caracteres")
    @Schema(description = "El nombre del plato", example = "Honey Glazed Ham")
    String name,

    @Pattern(regexp = "APERITIVO|PLATO_PRINCIPAL|GUARNICION|POSTRE|BEBIDA", message = "El tipo de comida debe ser uno de los siguientes: APERITIVO, PLATO_PRINCIPAL, GUARNICION, POSTRE, BEBIDA")
    @Schema(description = "El tipo de comida del plato", example = "PLATO_PRINCIPAL")
    String foodType,

    @Size(max = 100, message = "El nombre del chef no puede exceder los 100 caracteres")
    @Schema(description = "El nombre del chef que prepara el plato", example = "Bobby Flay")
    String chef,

    @Size(max = 1000, message = "La descripción no puede exceder los 1000 caracteres")
    @Schema(description = "Descripción detallada del plato", example = "Jamón glaseado con miel y mostaza, decorado con clavos de olor")
    String description
) {}
