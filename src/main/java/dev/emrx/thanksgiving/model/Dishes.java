package dev.emrx.thanksgiving.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "dishes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dishes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(name = "food_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private FoodType foodType;

    @Column(nullable = false)
    private String chef;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;

    // Enum para el tipo de comida
    public enum FoodType {
        APERITIVO, PLATO_PRINCIPAL, GUARNICION, POSTRE, BEBIDA
    }
}
