package com.springboot21.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "assets")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Code is required")
    @Column(name = "code") private String code;

    @Column(name = "description") private String description;
    @Column(name = "created_at") private LocalDateTime created_at;
    @Column(name = "updated_at") private LocalDateTime updated_at;

    @NotNull(message = "Status is required")
    @ManyToOne
    @JoinColumn(name = "asset_status_id")
    private AssetStatus status;

    @NotNull(message = "Type is required")
    @ManyToOne
    @JoinColumn(name = "asset_type_id")
    private AssetType type;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        created_at = now;
        updated_at = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updated_at = LocalDateTime.now();
    }
}
