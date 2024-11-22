package dev.emrx.thanksgiving.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

public record CreateDishRequest(
    @NotBlank(message = "El nombre del plato no puede estar vacío")
    @Size(max = 100, message = "El nombre del plato no puede exceder los 100 caracteres")
    String name,

    @NotBlank(message = "El tipo de comida no puede estar vacío")
    @Pattern(regexp = "APERITIVO|PLATO_PRINCIPAL|GUARNICION|POSTRE|BEBIDA", message = "El tipo de comida debe ser uno de los siguientes: APERITIVO, PLATO_PRINCIPAL, GUARNICION, POSTRE, BEBIDA")
    String foodType,

    @NotBlank(message = "El nombre del chef no puede estar vacío")
    @Size(max = 100, message = "El nombre del chef no puede exceder los 100 caracteres")
    String chef,

    @Size(max = 1000, message = "La descripción no puede exceder los 1000 caracteres")
    String description
) {}
