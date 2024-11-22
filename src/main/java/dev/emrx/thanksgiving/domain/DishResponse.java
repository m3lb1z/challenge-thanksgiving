package dev.emrx.thanksgiving.domain;

import java.util.UUID;

public record DishResponse(
    UUID id,
    String name,
    String foodType,
    String chef,
    String description
) {}
