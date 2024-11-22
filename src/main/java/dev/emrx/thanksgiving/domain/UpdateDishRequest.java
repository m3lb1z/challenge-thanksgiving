package dev.emrx.thanksgiving.domain;

public record UpdateDishRequest(
    String name,
    String foodType,
    String chef,
    String description
) {}
